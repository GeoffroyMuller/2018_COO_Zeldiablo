package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Aventurier;
import zeldiablo.Coordonnee;
import zeldiablo.Labyrinthe;

public class TestDeplacement {
	@Test
	public void testDeplacerEnDehorsDroiteGauche() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(0,1);
		Aventurier a = new Aventurier(c,l); 
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion 
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	
	@Test
	public void testDeplacerEnDehorsHautBas() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(1,0);
		Aventurier a = new Aventurier(c,l);
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	
	@Test
	public void testDeplacerEnDehorsLimiteLaby() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		int y = l.getGrille().length;
		Coordonnee c = new Coordonnee(1,49);
		Coordonnee c1 = new Coordonnee(1,y);
		Aventurier a = new Aventurier(c,l);
		//Methode testee
		a.deplacerAventurier(c1); 
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	
	@Test
	public void testDeplacerEnDehorsLimiteLaby2() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		int y = l.getGrille().length;
		Coordonnee c = new Coordonnee(49,1);
		Coordonnee c1 = new Coordonnee(y,1);
		Aventurier a = new Aventurier(c,l);
		//Methode testee
		a.deplacerAventurier(c1); 
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer en dehors", a.deplacerAventurier(c1));
	}
	 
	@Test
	public void testDeplacerValide() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(1,2);
		Aventurier a = new Aventurier(c,l);
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion
		assertTrue("Le joueur ne devrait pouvoir se deplacer", a.deplacerAventurier(c1));
	}
	
	@Test
	public void testDeplacerCaseTraversable() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		Coordonnee c = new Coordonnee(1,48);
		Coordonnee c1 = new Coordonnee(1,47);
		//Methode testee
		l.getGrille()[c1.getX()][c1.getY()].estTraversable();
		//assertion
		assertTrue("Le joueur devrait pouvoir se deplacer sur la case", l.getGrille()[c.getX()][c.getY()].estTraversable());
	}
	
	@Test
	public void testDeplacerCaseNonTraversable() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(0,1);
		//Methode testee
		l.getGrille()[c1.getX()][c1.getY()].estTraversable();
		//assertion
		System.out.println(l);
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer sur la case", l.getGrille()[c1.getX()][c1.getY()].estTraversable());
		
	}
}
