package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*;
public class TestPotion {
	/**
	 * test du constructeur de la classe Potion
	 */
	@Test
	public void testConstructeur() {
		//initialisation des donnees
		Salle s = new Salle();
		Potion p = new Potion(s,2,3);
		//methodes testees
		String str = p.getType();
		Coordonnee c = p.getCoo();
		Salle sl = p.getSalle();
		//assertions
		assertEquals("La potion devrait s'appeller potion", p.getType(), str);
		assertEquals("La potion devrait etre dans la salle", p.getSalle(), sl);
		assertEquals("La potion devrait etre de coordonnee (2,3)",p.getCoo(), c);
	}
	
	/**
	 * Test des effets d'une potion avec une diminution de la vie
	 */
	@Test
	public void testEffetItemVieDiminutionDeVie() {
		//Preparation des donn�es
		Salle s = new Salle(2);
		Potion p = new Potion(s,12,13);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		av.setVie(70);
		int vie = av.getVie();
		//Methode testee
		p.effetItem(av);
		//Test
		assertTrue("La vie devrait augmenter",av.getVie()>vie);
	}
	
	/**
	 * Test des effets d'une potion sans une diminution de la vie
	 */
	@Test
	public void testEffetItemVie() {
		//Preparation des donn�es
		Salle s = new Salle(2);
		Potion p = new Potion(s,12,13);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		int vie = av.getVie();
		//Methode testee
		p.effetItem(av);
		//Test
		assertTrue("La vie devrait augmenter",av.getVie()==vie);
	}
	
	

}
