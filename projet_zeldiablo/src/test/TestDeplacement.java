package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Aventurier;
import zeldiablo.Coordonnee;
import zeldiablo.Labyrinthe;

public class TestDeplacement {
	@Test
	public void testDeplacerEnDehors() {
		//initialisation des donnees
		Labyrinthe l = new Labyrinthe();
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee c1 = new Coordonnee(0,1);
		Aventurier a = new Aventurier(c,l);
		//Methode testee
		a.deplacerAventurier(c1);
		//assertion
		assertFalse("Le joueur ne devrait pas pouvoir se deplacer", a.deplacerAventurier(c1));
	}
}
