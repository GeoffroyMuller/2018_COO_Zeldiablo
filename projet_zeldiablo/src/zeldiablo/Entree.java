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
	 * La salle précédente
	 * @see Entree#Entree(Salle)
	 */
	private Salle sallePrecedente;
	
	/**
	 * Permet la création d'une case de type entrée
	 */
	public Entree(){
		super();
		this.setTextureMotCle("portail_entree");
	}
	
	/**
	 * Permet la création d'une entrée en spécifiant la salle précédente
	 * @param s
	 * 		La salle précédente
	 */
	public Entree(Salle s) {
		super();
		sallePrecedente =s;
		this.setTextureMotCle("portail_entree");

	}
	/**
	 * @see zeldiablo.Case#estTraversable()
	 */
	@Override
	public boolean estTraversable() {
		return true;
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

}
