package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.*;

public class TestSalle {
/**
 * Test de la dectection des combats lorsqu'il y en a un
 */
	@Test
	public void testDetecterCombatDegat() {
		//Preparation des donn�es
		Salle s=new Salle(5);
		Monstre m = new Monstre(new Coordonnee(12,13),s);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		av.setSalle(s);
		s.getMonstrePresent().add(m);
		//Methode teste
		s.detecterCombat(av);
		//Test
		assertEquals("L'aventurier devrait avoir prit des d�gats",99,av.getVie());
	}
	
	/**
	 * Test de la dectection des combats lorsqu'il y en a pas
	 */
		@Test
		public void testDetecterCombatPasDeCombat() {
			//Preparation des donn�es
			Salle s=new Salle(5);
			Monstre m = new Monstre(new Coordonnee(14,14),s);
			Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
			av.setSalle(s);
			s.getMonstrePresent().add(m);
			//Methode teste
			s.detecterCombat(av);
			//Test
			assertEquals("L'aventurier devrait ne pas avoir prit des d�gats",100,av.getVie());
		}


}
