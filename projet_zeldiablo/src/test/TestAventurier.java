package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Aventurier;

public class TestAventurier {

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

}
