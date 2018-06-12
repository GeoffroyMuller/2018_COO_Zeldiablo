package test;

import static org.junit.Assert.*;

import org.junit.Test;
import zeldiablo.*;

public class TestDonjon {
	@Test
	public void testConstructeur() {
		//initialisation des donnees
		Donjon d = new Donjon("Mireille");
		//methode testee
		String s = d.getNom();
		int nb = d.getEtages().size();
		//assertion
		assertEquals("Le donjon devrait s'appeller Mireille",d.getNom(),s);
		assertEquals("Le donjon devrait contenir 5 etages", d.getEtages().size(),nb);
	}

}
