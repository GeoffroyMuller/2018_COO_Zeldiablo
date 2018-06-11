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
	 * Test de l'incrémentation de X
	 */
	@Test
	public void testCoordonneeIncrementerX() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		//Methode testee
		c.incrementerX();
		//Test
		assertEquals("Les coordonnee x devrait etre 10",11,c.getX());
	}
	
	/**
	 * Test de l'incrémentation de Y
	 */
	@Test
	public void testCoordonneeIncrementerY() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		//Methode testee
		c.incrementerY();
		//Test
		assertEquals("Les coordonnee y devrait etre 10",12,c.getY());
	}
	
	/**
	 * Test de la decrementation de Y
	 */
	@Test
	public void testCoordonneeDecrementerY() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		//Methode testee
		c.decrementerY();
		//Test
		assertEquals("Les coordonnee y devrait etre 10",10,c.getY());
	}
	
	/**
	 * Test de la decrementation de X
	 */
	@Test
	public void testCoordonneeDecrementerX() {
		//Preparation donnee
		Coordonnee c = new Coordonnee(10,11);
		//Methode testee
		c.decrementerX();
		//Test
		assertEquals("Les coordonnee x devrait etre 10",9,c.getX());
	}
	

}
