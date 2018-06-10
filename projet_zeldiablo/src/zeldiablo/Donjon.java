package zeldiablo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Donjon{
	/**
	 * Ensemble des étages du donjon
	 * @see Donjon#getEtages()
	 * @see Donjon#getEtages()
	 */
	ArrayList<Etage> etages;
	/**
	 * Nom du donjon
	 * @see Donjon#Donjon(String)
	 * @see Donjon#getNom()
	 */
	private String nom;
	/**
	 * Nombre d'étage du donjon
	 */
	public final static int NUM_ETAGES=5;

/**
 * Constructeur permettant la création du donjon
 * @param pnom
 * 		nom du donjon
 * @see Donjon#nom
 */
public Donjon (String pnom) {
	this.nom = pnom;
	etages = new ArrayList<>();
	for (int i = 0; i < NUM_ETAGES; i++) {
		etages.add(new Etage(i));
	}
}

/**
 * Permet de retourner l'ensemble des étage du donjon
 * @return
 * 	l'ensemble des étages du donjon
 * @see Donjon#etages
 */
public ArrayList<Etage> getEtages() {
	return etages;
}

/**
 * Permet de retourner le nom du donjon
 * @return le nom du donjon
 */
public String getNom() {
	return nom;
}

}
