package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Coordonnee;

/**
 * @author Lucas
 *
 */
public class TestCoordonnee {

	
	/**
	 * Test du Constructeur Coordonnee
	 */
	@Test
	public void testCoordonneeConstructeur() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		//Test
		assertEquals("Les coordonnee x devrait etre 10",10,c.getX());
		assertEquals("Les coordonnee y devrait etre 11",11,c.getY());
	}
	
	/**
	 * Test de la duplication de Coordonnee
	 */
	@Test
	public void testCoordonneeDupliquer() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		Coordonnee b = new Coordonnee(20,20);
		//Methode testee
		b.dupliquerCoordonnee(c);
		//Test
		assertEquals("Les coordonnee x devrait etre 10",10,b.getX());
		assertEquals("Les coordonnee y devrait etre 11",11,b.getY());
	}
	
	/**
	 * Test de la duplication de Coordonnee
	 */
	@Test
	public void testCoordonneeDupliquer() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		Coordonnee b = new Coordonnee(20,20);
		//Methode testee
		b.dupliquerCoordonnee(c);
		//Test
		assertEquals("Les coordonnee x devrait etre 10",10,b.getX());
		assertEquals("Les coordonnee y devrait etre 11",11,b.getY());
	}
	

}
