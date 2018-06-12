package test;
import java.awt.Image;
import java.awt.image.BufferedImage;

import zeldiablo.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGestionnaireTexture {

	@Test
	public void testAttributionTexture() {
		GestionnaireTexture gt = new GestionnaireTexture();
		Case v = new Vide();
		Case m = new Mur();
		Case e = new Entree(new Coordonnee(0,5));
		Case s = new Sortie(new Coordonnee(0,2));
		
		Texture tv = new Texture("sol_bois", "..\\texture\\wood.png" );
		Texture tm = new Texture("wall_dark", "..\\texture\\wall_dark_stone.png" );
		Texture te = new Texture("portail_entree", "..\\texture\\Portail_Entree.png" );
		Texture ts = new Texture("portail_sortie", "..\\texture\\Portail_Sortie.png" );
		
		Image deftv =tv.getImg();
		Image deftm =tm.getImg();
		Image defte =te.getImg();
		Image defts =ts.getImg();
		
		Image atv =gt.attribuerTexture(v);
		Image atm =gt.attribuerTexture(m);
		Image ate =gt.attribuerTexture(e);
		Image ats =gt.attribuerTexture(s);
		
		assertTrue("erreur sur la texture du bois",deftv.equals(atv));
		assertEquals("erreur sur la texture du mur sombre",deftm,atm);
		assertEquals("erreur sur la texture du portail entree",deftm,atm);
		assertEquals("erreur sur la texture du portail sortie",deftm,atm);
		
		
	}
	
	public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
	    // Les deux images doivent avoir la même tailles
	    if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
	        int width = imgA.getWidth();
	        int height = imgA.getHeight();
	 
	        // Boucle sur chaque pixel de l'image
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	                // comparaison des deux pixels
	                if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
	                    return false;
	                }
	            }
	        }
	    } else {
	        return false;
	    }
	 
	    return true;
	}
	

}
