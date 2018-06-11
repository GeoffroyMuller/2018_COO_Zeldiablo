package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zeldiablo.Case;
import zeldiablo.Salle;
import zeldiablo.Mur;
import zeldiablo.Vide;

public class TestLabyrinthe {
	/**
	 * test du constructeur vide de Salle
	 * @throws Exception
	 */
	@Test
	public void testConstructeurVide() throws Exception {
		// initialisation
		//Execution du test
		Salle laby = new Salle();
		Case[][] grille =laby.getGrille();
		
		
		//Assertion
		assertEquals("entree devrais etre en 0,24","entree", grille[0][24].getType());
		assertEquals("sortie devrais etre en 49,24","sortie", grille[49][24].getType());
		
	
		
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				if((i!=0 && j!=24)||(i!=49 && j!=24)){
					if(i==0 || i==49 || j==0 || j==49){
						assertEquals("entree devrais etre mur","mur", grille[i][j].getType());
					}
					else {
						assertEquals("entree devrais etre vide","vide", grille[i][j].getType());
					}
				}
			}
			
		}
	}

}
