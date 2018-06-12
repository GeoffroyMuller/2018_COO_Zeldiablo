package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.*;

public class TestSalle {
/**
 * Test de la dectection des combats
 */
	@Test
	public void testDetecterCombat() {
		//Preparation des données
		Salle s=new Salle(5);
		Monstre m = new Monstre(new Coordonnee(12,13),s);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		av.setSalle(s);
		s.getMonstrePresent().add(m);
		//Methode teste
		s.detecterCombat(av);
		//Test
		assertEquals("L'aventurier devrait avoir prit des dégats",99,av.getVie());
	}

}
