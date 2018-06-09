package Editeur;

import zeldiablo.*;


public class Niveau {
	private Salle salle;
	private Zone zone;

	public Niveau() {
		// TODO Auto-generated constructor stub
		salle = null;
		zone = null;
	}
	
	public void creationSalle() {
		salle = new Salle();
		System.out.println("creation salle");
	}
	
	public void creationZone(String nom) {
		zone = new Zone(nom);
		System.out.println("creation zone : "+ nom);
	}

}
