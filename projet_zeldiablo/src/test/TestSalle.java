package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import zeldiablo.*;

public class TestSalle {
	/**
	 * Test de la dectection des combats lorsqu'il y en a un
	 */
	@Test
	public void testDetecterCombatDegat() {
		//Preparation des données
		Salle s=new Salle(5);
		Monstre m = new Monstre(new Coordonnee(12,13),s);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		av.setSalle(s);
		av.setVie(100);
		int vie = 100 - m.getDegats();
		s.getMonstrePresent().add(m);
		//Methode teste
		s.detecterCombat(av);
		//Test
		assertEquals("L'aventurier devrait avoir prit des dégats",vie,av.getVie());
	}

	/**
	 * Test de la dectection des combats lorsqu'il y en a pas
	 */
	@Test
	public void testDetecterCombatPasDeCombat() {
		//Preparation des données
		Salle s=new Salle(5);
		Monstre m = new Monstre(new Coordonnee(14,14),s);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		av.setSalle(s);
		av.setVie(100);
		s.getMonstrePresent().add(m);
		//Methode teste
		s.detecterCombat(av);
		//Test
		assertEquals("L'aventurier devrait ne pas avoir prit des dégats",100,av.getVie());
	}

	/**
	 * Test de la dectection des combats lorsqu'il y en a pas
	 */
	@Test
	public void testDetecterMort() {
		//Preparation des données
		Salle s=new Salle(5);
		Monstre m = new Monstre(new Coordonnee(14,14),s);
		Aventurier av = new Aventurier(new Coordonnee(12,12),s,null);
		m.setMort(true);
		av.setSalle(s);
		s.getMonstrePresent().add(m);
		//Methode teste
		boolean res = s.detecterLesMorts();
		//Test
		assertTrue("Des morts devrait être détecté",res);
	}

	@Test
	public void testplaceAleatoirItem_1() {
		//preparation
		Salle s=new Salle();
		Aleatoire aleaItem = new AleatoireFaux(100);
		//methode teste
		s.placeAleatoirItem(aleaItem);
		//Test
		assertTrue("La Taille de ItemPresent devrait etre supperieur a 0",s.getItemPresent().size()>0);
	}
	
	@Test
	public void testplaceAleatoirItem_2() {
		//preparation
		Salle s=new Salle();
		ArrayList<Item> i = new ArrayList<Item>();
		s.setItemPresent(i);
		Aleatoire aleaItem = new AleatoireFaux(0);
		//methode teste
		s.placeAleatoirItem(aleaItem);
		//Test
		assertFalse("La Taille de ItemPresent devrait etre egale a 0",s.getItemPresent().size()>0);
	}
	
	@Test
	public void testprendreItem() {
		//preparation
		Salle s = new Salle();
		Potion po = new Potion(s,12,13);
		s.getItemPresent().add(po);
		int taille = s.getItemPresent().size();
		Aventurier a = new Aventurier(new Coordonnee(12,12),s,null);
		
		a.deplacerAventurier(new Coordonnee(12,13));
		//methode testee
		s.prendreItem(a);
		//test
		assertTrue("La potion devrait ne plus exister",taille-1==s.getItemPresent().size());
	}






}
