package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.*;


public class TestAventurier {
	/**
	 * test du constructeur vide
	 */
	@Test
	public void testConstructeur_1() {
		//initialisation des donnees
		Aventurier a = new Aventurier();
		//methodes testees
		int pv = a.getVie();
		//assertion
		assertEquals("La vie devrait etre egale a 100",a.getVie(), pv);
		assertFalse("L'aventurier devrait etre en vie",a.isMort());
	}
	/**
	 * test du constructeur avec parametres valides
	 */
	@Test
	public void testConstructeur_2() {
		//initialisation des donnees
		Aventurier a = new Aventurier(new Coordonnee(10,100), new Salle(), new Etage(0));
		//methodes testees 
		int pv = a.getVie();
		
		assertEquals("La vie devrait etre egale a 100",a.getVie(),pv);
		assertFalse("L'aventurier devrait etre en vie",a.isMort());
		assertEquals("La coordonnee en x devrait etre egale a 10", 10,a.getCoor().getX());
		assertEquals("La coordonnee en y devrait etre egale a 100", 100,a.getCoor().getY());
	}
	/**
	 * test du constructeur avec parametre non valides
	 */
	@Test
	public void testConstructeur_3() {
		//initialisation des donnees
		Aventurier a = new Aventurier(new Coordonnee(0,0), new Salle(), new Etage(0));
		//asseertion
		assertEquals("La vie devrait etre egale a 100", 100,a.getVie());
		assertFalse("L'aventurier devrait etre en vie",a.isMort());
		assertEquals("La position devrait etre un mur", "mur",a.getCase().getType());
		assertEquals("La position ne devrait pas etre traversable", false,a.getCase().estTraversable());
	}
	/**
	 * test de la methode enVie de Personnage
	 */
	@Test
	public void testAventurierEnVie() {
		//initialisation des donnees
		Aventurier a = new Aventurier();
		//methode testee
		boolean res = a.enVie();
		//assertion
		assertFalse("Le joueur devrait etre en vie", res);
	}
	/**
	 * test de la methode modifierVie avec une valeur négative
	 */
	@Test
	public void testModifierVieNegatif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.modifierVie(-20);
		//Test
		assertEquals("La vie devrait avoir diminue", 80,a.getVie());
	}
	/**
	 * test de la methode modifierVie avec une valeur positive
	 */
	@Test
	public void testModifierViePositif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.modifierVie(10);
		//Test
		assertEquals("La vie devrait avoir augmente", 110,a.getVie());
	}
	/**
	 * test de la methode subirDegat avec l'aventurier toujours en vie
	 */
	@Test
	public void testSubirDegatPositifToujoursEnVie() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.subirDegats(20);
		//Test
		assertEquals("La vie devrait avoir diminue", 80,a.getVie());
		assertFalse("L'aventurier devrait etre en vie",a.isMort()); 
	}
	/**
	 * test de la methode subirDegat avec l'aventurier mort
	 */
	@Test
	public void testSubirDegatPositifMort() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.subirDegats(110);
		//Test
		assertTrue("L'aventurier devrait etre mort",a.isMort());
	}
	/**
	 * test de la methode subirDegat avec une valeur negative
	 */
	@Test
	public void testSubirDegatNegatif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.subirDegats(-10);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}
	/**
	 * test de la methode soigner avec une valeur negative
	 */
	@Test
	public void testSoignerNegatif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.soigner(-20);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}
	/**
	 * test de la methode soigner avec une valeur positive
	 */
	@Test
	public void testSoignerPositif() {
		//Donnees
		Aventurier a = new Aventurier();
		a.subirDegats(20);
		//Methode testée
		a.soigner(20);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}
	/**
	 * test de la methode soigner avec une valeur depassant les point de vie de l'aventurier
	 */
	@Test
	public void testSoignerSup100() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.soigner(20);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}
	/**
	 * test de la methode deplacerAventurier en dehors de la salle a droite et a gauche
	 */
	@Test
	public void testDeplacerEnDehorsDroiteGauche() {
		//initialisation des donnees
		Salle l = new Salle();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(0,1);
		Aventurier a = new Aventurier(c,l, new Etage(0)); 
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion 
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	/**
	 * test de la methode deplacerAventurier en dehors de la salle en haut et en bas
	 */
	@Test
	public void testDeplacerEnDehorsHautBas() {
		//initialisation des donnees
		Salle l = new Salle();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(1,0);
		Aventurier a = new Aventurier(c,l, new Etage(0));
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	/**
	 * test de la methode deplacerAventurier en dehors de la salle
	 */
	@Test
	public void testDeplacerEnDehorsLimiteLaby() {
		//initialisation des donnees
		Salle l = new Salle();
		int y = l.getGrille().length;
		Coordonnee c = new Coordonnee(1,49);
		Coordonnee c1 = new Coordonnee(1,y);
		Aventurier a = new Aventurier(c,l, new Etage(0));
		//Methode testee
		a.deplacerAventurier(c1); 
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	/**
	 * test de la methode deplacerAventurier en dehors de la salle
	 */
	@Test
	public void testDeplacerEnDehorsLimiteLaby2() {
		//initialisation des donnees
		Salle l = new Salle();
		int y = l.getGrille().length;
		Coordonnee c = new Coordonnee(49,1);
		Coordonnee c1 = new Coordonnee(y,1);
		Aventurier a = new Aventurier(c,l, new Etage(0));
		//Methode testee
		a.deplacerAventurier(c1); 
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	/**
	 * test de la methode deplacerAventurier avec un deplacement valide dans la salle
	 */
	@Test
	public void testDeplacerValide() {
		//initialisation des donnees
		Salle l = new Salle();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(1,2);
		Aventurier a = new Aventurier(c,l, new Etage(0));
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion
		assertTrue("Le joueur ne devrait pouvoir se deplacer", a.deplacerAventurier(c1));
	}
	/**
	 * test de la methode estTraversable de Case avec une case traversable
	 */
	@Test
	public void testDeplacerCaseTraversable() {
		//initialisation des donnees
		Salle l = new Salle();
		Coordonnee c = new Coordonnee(1,12);
		Coordonnee c1 = new Coordonnee(1,15);
		//Methode testee
		l.getGrille()[c1.getX()][c1.getY()].estTraversable();
		//assertion
		assertTrue("Le joueur devrait pouvoir se deplacer sur la case", l.getGrille()[c.getX()][c.getY()].estTraversable());
	}
	/**
	 * test de la methode estTraversable de Case avec une case non traversable
	 */
	@Test
	public void testDeplacerCaseNonTraversable() {
		//initialisation des donnees
		Salle l = new Salle();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(0,1);
		//Methode testee
		l.getGrille()[c1.getX()][c1.getY()].estTraversable();
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer sur la case", l.getGrille()[c1.getX()][c1.getY()].estTraversable());

	}
	/**
	 * test de la methode changementSalle avec un aventurier qui prend une entrée 
	 * et qui se retrouve a la sortie de la salle precedente
	 */
	@Test
	public void testDeplacerCaseEntree() {
		//initialisation des donnees
		Salle l = new Salle();
		Salle l1 = new Salle();
		Salle l2 = new Salle();
		Etage e = new Etage(1);
		Coordonnee co = new Coordonnee(4,5);
		Case c = l.getSortie();
		Aventurier a = new Aventurier(co,l1,e);
		//methode testee
		a.deplacerAventurier(l1.getEntree());
		a.getSalle().getEntree();
		a.changementSalle(l, c);
		//assertion
		assertEquals("Le joueur devrait etre sur la sortie de la salle precedente", l.getEntree(), a.getCase());
	}

}
