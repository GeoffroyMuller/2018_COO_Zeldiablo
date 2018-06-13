package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		assertEquals("La vie devrait etre egale a 100", 150,a.getVie());
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
		a.setVie(100);
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
		a.setVie(100);
		//Methode testée
		a.modifierVie(10);
		//Test
		//pour loic
		assertEquals("La vie devrait avoir augmente", 110,a.getVie());
	}
	/**
	 * test de la methode subirDegat avec l'aventurier toujours en vie
	 */
	@Test
	public void testSubirDegatPositifToujoursEnVie() {
		//Donnees
		Aventurier a = new Aventurier();
		a.setVie(100);
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
		a.setVie(100);
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
		a.setVie(100);
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
		a.setVie(100);
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
		a.setVie(100);
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
		a.setVie(100);
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
		Coordonnee c = new Coordonnee(12,12);
		Coordonnee c1 = new Coordonnee(13,12);
		Aventurier a = new Aventurier(c,l, new Etage(0));
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion
		assertTrue("Le joueur ne devrait pouvoir se deplacer", a.getCoor()==c1);
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
	 * Test de la methode de deplacement sur une case traversable
	 */
	@Test
	public void testDeplacementPossibleCaseTraversable() {
		//Preparation des données
		Etage e = new Etage(7);
		Salle s = new Salle(7);
		ArrayList<Salle> lS = new ArrayList<Salle>();
		lS.add(s);
		e.setSalles(lS);
		Aventurier a = new Aventurier(new Coordonnee(12,12),s,e);
		//Methode testee
		a.deplacerAventurier(new Coordonnee(13,12));
		//Test
		assertEquals("L'aventurier devrait avoir avancer vers la gauche",13,a.getCoor().getX());
	}
	
	/**
	 * Test de la methode de deplacement sur une case non traversable
	 */
	@Test
	public void testDeplacementPossibleCaseNonTraversable() {
		//Preparation des données
		Salle s = new Salle(9);
		Aventurier a = new Aventurier(new Coordonnee(12,12),s,null);
		//Methode testee
		a.deplacerAventurier(new Coordonnee(15,15));
		//Test
		assertEquals("L'aventurier devrait ne pas bouger",12,a.getCoor().getX());
	}
	
	/**
	 * Test de la methode de deplacement sur une case entree
	 */
	@Test
	public void testDeplacementSurEntree() {
		//Preparation des données
		Etage e = new Etage(0);
		Salle sallePrecedente = e.getSalles().get(0).getEntree().getSallePrecedente();
		Coordonnee entree = e.getSalles().get(0).getEntree().getC();
		Aventurier a = new Aventurier(new Coordonnee(12,12),e.getSalles().get(0),e);
		//Methode testee
		a.deplacerAventurier(entree);
		//Test
		assertTrue("L'aventurier devrait avoir changer de salle",a.getSalle()==sallePrecedente);
	}
	
	
	
	@Test
	public void testChangementEtage() {
		Donjon d = new Donjon("Eltesto");
		Aventurier av = new Aventurier(new Coordonnee(12, 12),d.getEtages().get(0).getSalles().get(Etage.NUM_SALLES/2), d.getEtages().get(0));
		
		av.deplacerAventurier(new Coordonnee(12, 12));
		
		assertEquals("x devrais etre 12",12, av.getCoor().getX());

		assertEquals("y devrais etre 12",12, av.getCoor().getY());
		

		assertEquals("la salle devrais etre la salle 0 de l'eatge sup",d.getEtages().get(1).getSalles().get(0), av.getSalle());
		
		assertEquals("letage devrais etre létage 1 du donjon",d.getEtages().get(1), av.getEtage());
		
		
		
	}
	/**
	 * Test de l'attaque de l'aventurier quand un ennemi est proche
	 */
	@Test
	public void testAttaqueEnnemi(){
		//Preparation des données
				Salle s=new Salle(5);
				Monstre m = new Monstre(new Coordonnee(12,13),s);
				Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
				av.setSalle(s);
				s.getMonstrePresent().add(m);
				int vie = m.getVie()-av.getDegats();
				//Methode teste
				av.attaque();
				//Test
				assertEquals("Le monstre devrait avoir prit des dégats",vie,m.getVie());
	}
	
	/**
	 * Test de l'attaque de l'aventurier aucun ennemi est a proximité
	 */
	@Test
	public void testAttaqueEnnemiNonPresent(){
		//Preparation des données
				Salle s=new Salle(5);
				Monstre m = new Monstre(new Coordonnee(15,15),s);
				Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
				av.setSalle(s);
				s.getMonstrePresent().add(m);
				int vie = m.getVie();
				//Methode teste
				av.attaque();
				//Test
				assertEquals("Le monstre devrait avoir prit des dégats",vie,m.getVie());
	}
	
	/**
	 * Test de la methode de deplacement sur une case sortie
	 */
	@Test
	public void testDeplacementSurSortie() {
		//Preparation des données
		Etage e = new Etage(0);
		Coordonnee sortie = e.getSalles().get(0).getSortie().getCoord();
		Aventurier a = new Aventurier(new Coordonnee(12,12),e.getSalles().get(0),e);
		Salle actuel= a.getSalle();
		//Methode testee
		a.deplacerAventurier(e.getSalles().get(0).getSortie().getCoord());
		//Test
		assertTrue("L'aventurier devrait avoir changer de salle",a.getSalle()!=actuel);
	}
}
