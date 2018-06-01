package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Labyrinthe;

public class TestLabyrinthe {
	
	@Test
	public void testConstructeurVide() throws Exception {
		// initialisation
		//Execution du test
		Labyrinthe laby = new Labyrinthe();
		
		assertEquals("entree devrais etre en 0,24","entree", laby.getGrille()[0][24].getType());
		assertEquals("entree devrais etre en 49,24","entree", laby.getGrille()[49][24].getType());
		//Assertion
	}

}
