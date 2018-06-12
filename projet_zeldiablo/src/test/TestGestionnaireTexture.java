package test;
import java.awt.Image;
import java.awt.image.BufferedImage;

import zeldiablo.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGestionnaireTexture {
/*
 * Test du constructeur, verification de l'enrichissement de la liste
 */
	@Test
	public void testAttributionTexture() {
		//Preparation des données
		GestionnaireTexture gt = new GestionnaireTexture();
		//Test
		assertTrue("La liste devrait contenir des textures",gt.getListeTexture().size()>0);
	}
	

}
