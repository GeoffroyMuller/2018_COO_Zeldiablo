package zeldiablo;

import java.util.ArrayList;

public class Etage {
	private int numetage;
	ArrayList<Salle> salles;
	public final static int NUM_SALLES=10;
	


	public Etage(int pnum) {
		this.numetage = pnum;
		salles = new ArrayList<Salle>();
		for (int i = 0; i < NUM_SALLES; i++) {
			salles.add(new Salle());
		}
	}
	
	
	public int getNumetage() {
		return numetage;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}
}
