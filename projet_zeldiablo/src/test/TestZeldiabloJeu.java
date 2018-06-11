package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Coordonnee;
import zeldiablo.Salle;
import zeldiablo.ZeldiabloJeu;

public class TestZeldiabloJeu {
	/**
	 * test du changement d'etage de la classe ZeldiabloJeu
	 */
	@Test
	public void testChangementEtage() {
		//Preparation des données
		ZeldiabloJeu jD = new ZeldiabloJeu();
		int numEtage = jD.getAv().getEtage().getNumetage();
		//Methode testée
		jD.changementEtage();
		//Test
		assertEquals("L'aventurier devrait avoir changer d'étage",numEtage+1, jD.getAv().getEtage().getNumetage());	
	}

}
