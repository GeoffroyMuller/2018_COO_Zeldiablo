package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Sortie extends Case implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4220891365739441715L;
	/**
	 * La salle suivante
	 * @see Sortie#getSalleSuivante()
	 * @see Sortie#setSalleSuivante(Salle)
	 * @see Sortie#Sortie(Salle)
	 */
	private Salle salleSuivante;
	/**
	 * attribut Salle qui contiendra la salle suivante 
	 */
	private Coordonnee coord;
	
	/**
	 * Permet de modifier la salle suivante
	 * @param salleSuivante
	 * 		La salle suivante
	 */
	public void setSalleSuivante(Salle salleSuivante) {
		this.salleSuivante = salleSuivante;
	}
	
	/**
	 * Permet la création d'une case de type Sortie
	 */
	public Sortie(Coordonnee c) {
		super();
		this.setEstTraversable(true);
		this.setTextureMotCle("portail_sortie");
		this.coord = c;
	}
	/**
	 * Permet la création d'une case de type Sortie en spécifiant la salle suivante
	 * @param s
	 * 		La salle suivante
	 */
	public Sortie(Salle s, Coordonnee c) {
		super();
		this.setEstTraversable(true);
		this.salleSuivante = s;
		this.setTextureMotCle("portail_sortie");
		this.coord = c;
	}
	
	/**
	 * Permet de retourner la salle suivante
	 * @return La salle suivante
	 */
	public Salle getSalleSuivante() {
		return salleSuivante;
	}


	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "sortie";
	}
	/**
	 * methode getter qui va chercher la coordonnee de la sortie
	 * @return la coordonnee de la sortie 
	 */
	public Coordonnee getCoord() {
		return this.coord;
	}
	/**
	 * methode setter qui initialise la coordonnee de la sortie avec celle passee en parametre
	 * @param coord, coordonnee de la sortie 
	 */
	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}

}
