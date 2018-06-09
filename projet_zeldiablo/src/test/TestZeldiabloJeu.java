package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Coordonnee;
import zeldiablo.Salle;
import zeldiablo.ZeldiabloJeu;

public class TestZeldiabloJeu {

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
	
	@Test
	public void testChangementSalle() {
		//Preparation des données
		ZeldiabloJeu jD = new ZeldiabloJeu();
		jD.getAv().setCoor(new Coordonnee(24, (int)25/2));
		Salle salleActuel =jD.getAv().getSalle() ;
		//Methode testée
		jD.changementSalle();
		//Test
		assertTrue("L'aventurier devrait avoir changer de salle",salleActuel != jD.getAv().getSalle());	
	}

}
