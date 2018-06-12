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
	
	

}
