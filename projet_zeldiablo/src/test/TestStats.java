package test;
import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Stats;

public class TestStats {

	@Test
	public void testConstructeur() {
		Stats s = new Stats(4);
		
		
		assertEquals("le niveau devrai etre de 4",4, s.getNiveau());
		assertEquals("la resitance devrai etre de 100",100, s.getResistance());
		assertEquals("la force  devrai etre de 100",100, s.getForce());
		assertEquals("l'exp  devrai etre de 0",0, s.getExp());
		assertEquals("l'exp pour passer devrai etre de 11000",11000, s.getExpPourPasser());
	}
	
	@Test
	public void testChangementNiveau() {
		Stats s = new Stats(0);
		
		s.changementNiveau();
		s.changementNiveau();
		s.changementNiveau();
		s.changementNiveau();
		
		assertEquals("l'exp  devrai etre de 0",0, s.getExp());
		assertEquals("le niveau devrai etre de 4",4, s.getNiveau());
		assertEquals("la resitance devrai etre de 100",100, s.getResistance());
		assertEquals("la force  devrai etre de 100",100, s.getForce());
		assertEquals("l'exp pour passer devrai etre de 11000",11000, s.getExpPourPasser());
	}
	
	@Test
	public void ModifierNiveau(){
		Stats s = new Stats(0);
		
		s.modifierNiveau(4);
		
		assertEquals("l'exp  devrai etre de 0",0, s.getExp());
		assertEquals("le niveau devrai etre de 4",4, s.getNiveau());
		assertEquals("la resitance devrai etre de 100",100, s.getResistance());
		assertEquals("la force  devrai etre de 100",100, s.getForce());
		assertEquals("l'exp pour passer devrai etre de 11000",11000, s.getExpPourPasser());
	}
	
	@Test
	public void testAjoutExp() {
		Stats s = new Stats(0);
		
		s.ajoutExp(555);
		
		assertEquals("l'exp  devrai etre de 555",555, s.getExp());
	}
	
	
	@Test
	public void testChangementNiveauParAjoutDexp() {
		Stats s = new Stats(0);
		
		s.ajoutExp(1000);
		
		assertEquals("l'exp  devrai etre de 0",0, s.getExp());
		assertEquals("le niveau devrai etre de 1",1, s.getNiveau());
	}

}
