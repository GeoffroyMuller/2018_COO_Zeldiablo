package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*
;public class TestZone {
	/**
	 * test du constructeur de la classe Zone
	 */
	@Test
	public void testConstructeur() {
		//initialisation des donnees
		Zone z = new Zone("Moi");
		//methodes testees
		Case[][] tc = z.getGrilleZone();
		assertEquals("erreur sur nom"+z.getNomZone(),"Moi", z.getNomZone());
	}

}
