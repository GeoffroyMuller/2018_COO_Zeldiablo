package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*;
public class TestMur {
	/**
	 * test du constructeur de la classe Mur
	 */
	@Test
	public void test() {
		//initialisation des donnees
		Mur m = new Mur();
		//methode testee
		String s = m.getTextureMotCle();
		boolean res = m.isMonstrePresent();
		boolean r = m.isObjetPresent();
		//assertion
		assertFalse("Le mur ne devrait pas etre traversable", m.estTraversable());
		assertEquals("Le mur devrait s'appeller wall_dark", m.getTextureMotCle(), s);
		assertFalse("Le mur ne devrait pas contenir de monstre", res);
		assertFalse("Le mur ne devrait pas contenir d'objet", r);
	}

}
