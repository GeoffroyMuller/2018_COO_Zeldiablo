package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Salle;
import zeldiablo.Sortie;
import zeldiablo.*;
public class TestEntree {

	@Test
	public void testConstructeur() {
		Salle sa = new Salle();
		Entree e = new Entree(sa);
		//methodes testees
		String str = e.getTextureMotCle();
		//assertion
		assertTrue("La sortie devrait etre traversable", e.estTraversable());
		assertEquals("La sortie devrait avoir le nom de portail_sortie", e.getTextureMotCle(), str);
		assertEquals("La sortie devrait avoir une salle en salle suivante", e.getSallePrecedente(), sa);
		assertFalse("La sortie ne devrait pas contenir de monstre", e.isMonstrePresent());
		assertFalse("La sortie ne devrait pas contenir d'objet", e.isObjetPresent());
	}

}
