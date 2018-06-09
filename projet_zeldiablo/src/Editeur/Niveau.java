package Editeur;

import zeldiablo.*;


public class Niveau {
	private Salle salle;
	private Zone zone;
	private boolean sa,zo;

	public Niveau() {
		// TODO Auto-generated constructor stub
		salle = null;
		zone = null;
		sa = false;
		zo = false;
	}
	
	public void creationSalle() {
		salle = new Salle();
		sa = true;
		System.out.println("creation salle");
	}
	
	public void creationZone(String nom) {
		zone = new Zone(nom);
		zo = true;
		System.out.println("creation zone : "+ nom);
	}

	public boolean isSa() {
		return sa;
	}

	public boolean isZo() {
		return zo;
	}
	
	
}
