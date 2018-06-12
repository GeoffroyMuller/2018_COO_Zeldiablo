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
		//Preparation des données
		Salle s=new Salle(5);
		Monstre m = new Monstre(new Coordonnee(12,13),s);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		av.setSalle(s);
		av.setVie(100);
		int vie = 100 - m.getDegats();
		s.getMonstrePresent().add(m);
		//Methode teste
		s.detecterCombat(av);
		//Test
		assertEquals("L'aventurier devrait avoir prit des dégats",vie,av.getVie());
	}
	
	/**
	 * Test de la dectection des combats lorsqu'il y en a pas
	 */
		@Test
		public void testDetecterCombatPasDeCombat() {
			//Preparation des données
			Salle s=new Salle(5);
			Monstre m = new Monstre(new Coordonnee(14,14),s);
			Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
			av.setSalle(s);
			av.setVie(100);
			s.getMonstrePresent().add(m);
			//Methode teste
			s.detecterCombat(av);
			//Test
			assertEquals("L'aventurier devrait ne pas avoir prit des dégats",100,av.getVie());
		}
		
		/**
		 * Test de la dectection des combats lorsqu'il y en a pas
		 */
			@Test
			public void testDetecterMort() {
				//Preparation des données
				Salle s=new Salle(5);
				Monstre m = new Monstre(new Coordonnee(14,14),s);
				Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
				m.setMort(true);
				av.setSalle(s);
				s.getMonstrePresent().add(m);
				//Methode teste
				boolean res = s.detecterLesMorts();
				//Test
				assertTrue("Des morts devrait être détecté",res);
			}



}
