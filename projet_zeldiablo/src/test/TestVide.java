package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*;
public class TestVide {
	/**
	 * test du constructeur de la classe Vide
	 */
	@Test
	public void testConstructeur() {
		//initialisation des donnees
				Vide v = new Vide();
				//methode testee
				String s = v.getTextureMotCle();
				boolean res = v.isMonstrePresent();
				boolean r = v.isObjetPresent();
				//assertion
				assertTrue("Le mur devrait etre traversable", v.estTraversable());
				assertEquals("Le mur devrait s'appeller sol_bois", v.getTextureMotCle(), s);
				assertFalse("Le mur ne devrait pas contenir de monstre", res);
				assertFalse("Le mur ne devrait pas contenir d'objet", r);
	}

}
