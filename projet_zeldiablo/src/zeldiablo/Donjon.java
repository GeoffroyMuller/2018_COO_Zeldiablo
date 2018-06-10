package zeldiablo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Donjon{
	/**
	 * Ensemble des �tages du donjon
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
	 * Nombre d'�tage du donjon
	 */
	public final static int NUM_ETAGES=5;

/**
 * Constructeur permettant la cr�ation du donjon
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
 * Permet de retourner l'ensemble des �tage du donjon
 * @return
 * 	l'ensemble des �tages du donjon
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
