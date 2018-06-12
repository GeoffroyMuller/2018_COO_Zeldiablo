package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Entree extends Case implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5551888599501718393L;
	/**
	 * La salle précédente
	 * @see Entree#Entree(Salle)
	 */
	private Salle sallePrecedente;

	private Coordonnee coord;
	
	
	/**
	 * Permet la création d'une case de type entrée
	 */
	public Entree(Coordonnee c){
		super();
		this.setEstTraversable(true);
		this.setTextureMotCle("portail_entree");
		this.coord = c;
		
	}
	
	/**
	 * Permet la création d'une entrée en spécifiant la salle précédente
	 * @param s
	 * 		La salle précédente
	 */
	public Entree(Salle s,Coordonnee c) {
		super();
		this.setEstTraversable(true);
		sallePrecedente =s;
		this.setTextureMotCle("portail_entree");
		this.coord = c;

	}

	

	/**
	 * Permet de connaitre la salle précédente
	 * @return la salle précedente
	 */
	public Salle getSallePrecedente() {
		return sallePrecedente;
	}
	/**
	 * Permet de modifier la salle précédente
	 * @param sallePrecedente
	 */
	public void setSallePrecedente(Salle sallePrecedente) {
		this.sallePrecedente = sallePrecedente;
	}
	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "entree";
	}
	/**
	 * methode getter qui va chercher la coordonnee de l'entree
	 * @return la coordonnee de l'entree
	 */
	public Coordonnee getC() {
		return coord;
	}
}
