package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*
;public class TestZone {

	@Test
	public void testConstructeur() {
		//initialisation des donnees
		Zone z = new Zone("Moi");
		//methodes testees
		z.getGrilleZone()[z.TAILLE_ZONE][z.TAILLE_ZONE];
	}

}
