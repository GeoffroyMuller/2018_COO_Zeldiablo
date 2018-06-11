package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Etage;

public class TestEtage2 {

	/**
	 * Test du constructeur de Etage
	 */
	@Test
	public void testConstructeurEtage() {
		//Preparation de donnee
		Etage et = new Etage(2);
		//Test
		assertEquals("Il devrait y avoir 10 salles",10,et.getSalles().size());
		assertEquals("Le numero de l'étage devrait etre 2",2,et.getNumetage());
	}
	
}
