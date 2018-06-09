package Editeur;

import zeldiablo.*;


public class Niveau {
	private Salle salle;
	private Zone zone;
	private Case[][] tab_case;
	private boolean estsalle,estzone;

	public Niveau() {
		// TODO Auto-generated constructor stub
		salle = null;
		zone = null;
		estsalle = false;
		estzone = false;
	}
	
	public void creationSalle() {
		salle = new Salle();
		estsalle = true;
		tab_case = salle.getGrille();
		System.out.println("creation salle"+tab_case.length);
	}
	
	public void creationZone(String nom) {
		zone = new Zone(nom);
		estzone = true;
		tab_case = zone.getGrilleZone();
		System.out.println("creation zone"+ tab_case.length +" :"+nom);
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

	
	
	
}
