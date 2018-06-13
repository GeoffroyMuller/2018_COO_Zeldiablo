package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.PortailFin;

public class TestPortailFin {

	@Test
	public void testConstructeur() {
		PortailFin pf = new PortailFin();
		
		assertFalse("pas de monstre",pf.isMonstrePresent());
		assertFalse("pas d'abjet",pf.isObjetPresent());
		assertTrue("la case est traversable",pf.estTraversable());
		
	}

}
