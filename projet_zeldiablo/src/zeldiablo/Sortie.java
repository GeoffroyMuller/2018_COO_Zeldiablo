package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
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
	 * Permet la cr�ation d'une case de type Sortie
	 */
	public Sortie(Coordonnee c) {
		super();
		this.setEstTraversable(true);
		this.setTextureMotCle("portail_sortie");
		this.coord = c;
	}
	/**
	 * Permet la cr�ation d'une case de type Sortie en sp�cifiant la salle suivante
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

	public Coordonnee getCoord() {
		return this.coord;
	}

	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}

}
