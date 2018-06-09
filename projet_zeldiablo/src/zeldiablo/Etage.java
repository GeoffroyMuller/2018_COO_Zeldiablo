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
		for (int i = 0; i < NUM_SALLES; i++) {
			if(i==0) {
				salles.get(i).getSortie().setSalleSuivante(salles.get(i+1));
				salles.get(i).getEntree().setSallePrecedente(salles.get(NUM_SALLES-1));
				
			}
			else {
				if(i==NUM_SALLES-1) {
					salles.get(i).getSortie().setSalleSuivante(salles.get(0));
					salles.get(i).getEntree().setSallePrecedente(salles.get(i-1));
				}
				else{
					salles.get(i).getSortie().setSalleSuivante(salles.get(i+1));
					salles.get(i).getEntree().setSallePrecedente(salles.get(i-1));
				}
			}
		}

	}


	public int getNumetage() {
		return numetage;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}
}
