package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.*;


public class TestAventurier {

	@Test
	public void testConstructeur_1() {
		Aventurier a = new Aventurier();
		assertEquals("La vie devrait etre egale a 100", 100,a.getVie());
		assertEquals("L'aventurier devrait etre en vie", false,a.isMort());
	}

	@Test
	public void testConstructeur_2() {
		Aventurier a = new Aventurier(new Coordonnee(10,100), new Salle(), new Etage(0));
		assertEquals("La vie devrait etre egale a 100", 100,a.getVie());
		assertEquals("L'aventurier devrait etre en vie", false,a.isMort());
		assertEquals("La coordonnee en x devrait etre egale a 10", 10,a.getCoor().getX());
		assertEquals("La coordonnee en y devrait etre egale a 100", 100,a.getCoor().getY());
	}

	@Test
	public void testConstructeur_3() {
		Aventurier a = new Aventurier(new Coordonnee(0,0), new Salle(), new Etage(0));
		assertEquals("La vie devrait etre egale a 100", 100,a.getVie());
		assertEquals("L'aventurier devrait etre en vie", false,a.isMort());
		assertEquals("La position devrait etre un mur", "mur",a.getCase().getType());
		assertEquals("La position ne devrait pas etre traversable", false,a.getCase().estTraversable());
	}

	@Test
	public void testModifierVieNegatif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.modifierVie(-20);
		//Test
		assertEquals("La vie devrait avoir diminue", 80,a.getVie());
	}

	@Test
	public void testModifierViePositif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.modifierVie(10);
		//Test
		assertEquals("La vie devrait avoir augmente", 110,a.getVie());
	}

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

	@Test
	public void testSubirDegatPositifMort() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.subirDegats(110);
		//Test
		assertTrue("L'aventurier devrait etre mort",a.isMort());
	}

	@Test
	public void testSubirDegatNegatif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.subirDegats(-10);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}

	@Test
	public void testSoignerNegatif() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.soigner(-20);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}

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

	@Test
	public void testSoignerSup100() {
		//Donnees
		Aventurier a = new Aventurier();
		//Methode testée
		a.soigner(20);
		//Test
		assertEquals("La vie devrait ne pas avoir diminue",100, a.getVie());
	}

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
