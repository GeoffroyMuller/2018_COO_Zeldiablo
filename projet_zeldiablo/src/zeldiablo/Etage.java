package zeldiablo;

import java.util.ArrayList;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Etage {
	/**
	 * Numéro de l'étage
	 * @see Etage#getNumetage()
	 * @see Etage#Etage(int)
	 */
	private int numetage;
	/**
	 * Ensemble de salle de l'étage
	 */
	ArrayList<Salle> salles;
	/**
	 * Nombre de salle de l'étage
	 */
	public final static int NUM_SALLES=10;



	/**
	 * Constructuer, permettant la création de l'étage
	 * @param pnum
	 * 		numero de l'étage
	 */
	public Etage(int pnum) {
		this.numetage = pnum;
		salles = new ArrayList<Salle>();
		for (int i = 0; i < NUM_SALLES; i++) {
			this.salles.add(new Salle());
		}
		for (int i = 0; i < NUM_SALLES; i++) {
			if(i==0) {
				salles.get(i).getSortie().setSalleSuivante(salles.get(i+1));
				salles.get(i).getEntree().setSallePrecedente(salles.get(NUM_SALLES-1));

			}
			else if(i==NUM_SALLES-1) {
				salles.get(i).getSortie().setSalleSuivante(salles.get(0));
				salles.get(i).getEntree().setSallePrecedente(salles.get(i-1));
			}
			else{
				salles.get(i).getSortie().setSalleSuivante(salles.get(i+1));
				salles.get(i).getEntree().setSallePrecedente(salles.get(i-1));
			}
		}
	}




	/**
	 * Permet de retourner la numéro de l'étage
	 * @return le numero de l'étage
	 * @see Etage#numetage
	 */
	public int getNumetage() {
		return numetage;
	}

	/**
	 * Permet de retourner l'ensemble des salle
	 * @return l'ensemble des salle
	 * @see Etage#salles
	 */
	public ArrayList<Salle> getSalles() {
		return this.salles;
	}


	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}
}
