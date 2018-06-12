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
	etages = new ArrayList<Etage>();
	for (int i = 0; i < NUM_ETAGES; i++) {
		etages.add(new Etage(i));
	}
	
	for (int i = 0; i < NUM_ETAGES-1; i++) {
		Etage e = etages.get(i);
		Escalier es = new Escalier();
		es.setEtageSup(etages.get(i+1));
		es.setSalleEtageSup(etages.get(i+1).getSalles().get(0));
		e.getSalles().get((int)(e.NUM_SALLES)/2).setEscalier(es);
		e.getSalles().get((int)(e.NUM_SALLES)/2).getGrille()[12][12]=es;
	}
	
	for (int i = 0; i < NUM_ETAGES; i++) {
		for (int j = 0; j <Etage.NUM_SALLES; j++) {
			ArrayList<Monstre> lm = this.getEtages().get(i).getSalles().get(j).getMonstrePresent();
			for (int k = 0; k < lm.size(); k++) {
				lm.get(k).changerNiveau(new AleatoireVrai().genererNombreAleatoire(i, i+2));
			}
		}
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
