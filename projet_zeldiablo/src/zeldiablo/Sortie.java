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
	 * La salle suivante
	 * @see Sortie#getSalleSuivante()
	 * @see Sortie#setSalleSuivante(Salle)
	 * @see Sortie#Sortie(Salle)
	 */
	private Salle salleSuivante;
	
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
	public Sortie() {
		super();
		this.setTextureMotCle("portail_sortie");
	}
	/**
	 * Permet la création d'une case de type Sortie en spécifiant la salle suivante
	 * @param s
	 * 		La salle suivante
	 */
	public Sortie(Salle s) {
		super();
		this.salleSuivante = s;
		this.setTextureMotCle("portail_sortie");
	}
	
	/**
	 * Permet de retourner la salle suivante
	 * @return La salle suivante
	 */
	public Salle getSalleSuivante() {
		return salleSuivante;
	}
	/**
	 * @see zeldiablo.Case#estTraversable()
	 */
	@Override
	public boolean estTraversable() {
		return true;
	}

	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "sortie";
	}

}
