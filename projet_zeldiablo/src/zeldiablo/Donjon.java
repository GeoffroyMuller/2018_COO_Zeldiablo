package zeldiablo;

import java.io.Serializable;
import java.util.ArrayList;

public class Donjon{
	ArrayList<Etage> etages;
	private String nom;
	public final static int NUM_ETAGES=5;

public Donjon (String pnom) {
	this.nom = pnom;
	etages = new ArrayList<>();
	for (int i = 0; i < NUM_ETAGES; i++) {
		etages.add(new Etage(i));
	}
}

public ArrayList<Etage> getEtages() {
	return etages;
}

public String getNom() {
	return nom;
}

}
