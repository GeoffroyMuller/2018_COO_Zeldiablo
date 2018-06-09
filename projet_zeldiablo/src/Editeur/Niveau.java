package Editeur;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import zeldiablo.*;
import java.util.Observable;

public class Niveau extends Observable{
	private Salle salle;
	private Zone zone;
	
	private Case[][] tab_case;
	private int taille;
	
	private boolean estsalle,estzone;

	
	public Niveau() {
		// TODO Auto-generated constructor stub
		salle = null;
		zone = null;
		estsalle = false;
		estzone = false;
		tab_case = null;
		taille = 0;
		
	}
	
	public void creationSalle() {
		salle = new Salle();
		estsalle = true;
		tab_case = salle.getGrille();
		taille = Salle.TAILLE_SALLES;
		System.out.println("creation salle");
		setChanged();
		notifyObservers(VueNiveau.ADD_ML);
	}
	
	public void creationZone(String nom) {
		zone = new Zone(nom);
		estzone = true;
		tab_case = zone.getGrilleZone();
		taille = Zone.TAILLE_ZONE;
		System.out.println("creation zone :"+nom);
		setChanged();
		notifyObservers(VueNiveau.ADD_ML);
	}

	public boolean isEstsalle() {
		return estsalle;
	}

	public boolean isEstzone() {
		return estzone;
	}

	public Case[][] getTab_case() {
		return tab_case;
	}

	public int getTaille() {
		return taille;
	}



	
	
	
}
