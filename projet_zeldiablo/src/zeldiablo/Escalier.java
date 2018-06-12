package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Escalier extends Case implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 454796313750726250L;

	/**
	 * attribut Salle qui contiendra la salle a l'etage superieur 
	 *
	 */

	private Salle salleEtageSup;
	/**
	 * attribut Etage qui contiendra l'etage superieur 
	 */
	private Etage EtageSup;
	/**
	 * methode getter qui va chercher l'etage superieur 
	 * @return l'etage superieur 
	 */
	public Etage getEtageSup() {
		return EtageSup;
	}
	/**
	 * methode setter qui initialise l'etage superieur avec celui passe en parametre
	 * @param etageSup, etage superieur 
	 */
	public void setEtageSup(Etage etageSup) {
		EtageSup = etageSup;
	}
	/**
	 * Permet la création d'une case de type entrée
	 */
	public Escalier(){
		super();
		this.setEstTraversable(true);
		this.setTextureMotCle("portail_escalier");
	}
	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "escalier";
	}
	/**
	 * methode getter qui va chercher la salle de l'etage superieur
	 * @return
	 */
	public Salle getSalleEtageSup() {
		return salleEtageSup;
	}
	/**
	 * methode setter qui initialise la salle de l'etage superieur avec celui passe en parametre
	 * @param salleEtageSup, salle de l'etage superieur 
	 */
	public void setSalleEtageSup(Salle salleEtageSup) {
		this.salleEtageSup = salleEtageSup;
	}

}


