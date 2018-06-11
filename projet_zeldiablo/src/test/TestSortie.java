package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*;

public class TestSortie {

	@Test
	public void testConstructeur1() {
		//initialisation des donnees
		Sortie s = new Sortie();
		//methodes testees
		String str = s.getTextureMotCle();
		//assertion
		assertTrue("La sortie devrait etre traversable", s.estTraversable());
		assertEquals("La sortie devrait avoir le nom de portail_sortie", s.getTextureMotCle(), str);
		assertFalse("La sortie ne devrait pas contenir de monstre", s.isMonstrePresent());
		assertFalse("La sortie ne devrait pas contenir d'objet", s.isObjetPresent());
	}
	
	@Test
	public void testConstructeur2() {
		//initialisation des donnees
		Salle sa = new Salle();
		Sortie s = new Sortie(sa);
		//methodes testees
		String str = s.getTextureMotCle();
		//assertion
		assertTrue("La sortie devrait etre traversable", s.estTraversable());
		assertEquals("La sortie devrait avoir le nom de portail_sortie", s.getTextureMotCle(), str);
		assertEquals("La sortie devrait avoir une salle en salle suivante", s.getSalleSuivante(), sa);
		assertFalse("La sortie ne devrait pas contenir de monstre", s.isMonstrePresent());
		assertFalse("La sortie ne devrait pas contenir d'objet", s.isObjetPresent());
	}
}
