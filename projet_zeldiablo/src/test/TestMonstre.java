package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.*;

/**
 * @author Lucas
 *
 */
public class TestMonstre {
	
	
	/**
	 * Test du constructeur de Monstre
	 */
	@Test
	public void testMonstreConstructeur() {
		//Preparation des donnees
		Salle s = new Salle();
		Monstre m = new Monstre(new Coordonnee(10,10),s);
		
		//Test
		assertTrue("La salle devrait être la salle donnée en parametre",m.getSalle()==s);
		assertEquals("Le monstre devrait etre sur la case aux bonnes coordonnees x",10,m.getCoor().getX());
		assertEquals("Le monstre devrait etre sur la case aux bonnes coordonnees y",10,m.getCoor().getY());
		
		
	}
	
	/**
	 * Test du constructeur de Monstre
	 */
	@Test
	public void testMonstreDeplacementDroit() {
		//Preparation des donnees
		Salle s = new Salle(4);
		Aleatoire random = new AleatoireFaux(0);
		Monstre m = s.getMonstrePresent().get(0);
		Coordonnee cM = m.getCoor();
		//Methode testee
		m.deplacement(random);
		//Test
		assertEquals("Le monstre devrait se déplacer à droite", cM.getX()+1,m.getCoor().getX());
		
		
		
		
	}
	
	/**
	 * Test du constructeur de Monstre deplacement gauche
	 */
	@Test
	public void testMonstreDeplacementGauche() {
		//Preparation des donnees
		Salle s = new Salle(4);
		Aleatoire random = new AleatoireFaux(1);
		Monstre m = s.getMonstrePresent().get(0);
		Coordonnee cM = m.getCoor();
		//Methode testee
		m.deplacement(random);
		//Test
		assertEquals("Le monstre devrait se déplacer à gauche", cM.getX()-1,m.getCoor().getX());	
	}
	
	/**
	 * Test du constructeur de Monstre deplacement bas
	 */
	@Test
	public void testMonstreDeplacementBas() {
		//Preparation des donnees
		Salle s = new Salle(4);
		Aleatoire random = new AleatoireFaux(2);
		Monstre m = s.getMonstrePresent().get(0);
		Coordonnee cM = m.getCoor();
		//Methode testee
		m.deplacement(random);
		//Test
		assertEquals("Le monstre devrait se déplacer en bas", cM.getY()+1,m.getCoor().getY());	
	}
	
	/**
	 * Test du constructeur de Monstre deplacement haut
	 */
	@Test
	public void testMonstreDeplacementHaut() {
		//Preparation des donnees
		Salle s = new Salle(4);
		Aleatoire random = new AleatoireFaux(3);
		Monstre m = s.getMonstrePresent().get(0);
		Coordonnee cM = m.getCoor();
		//Methode testee
		m.deplacement(random);
		//Test
		assertEquals("Le monstre devrait se déplacer en haut", cM.getY()-1,m.getCoor().getY());	
	}

}
