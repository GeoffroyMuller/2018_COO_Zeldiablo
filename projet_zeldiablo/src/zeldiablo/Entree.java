package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Entree extends Case implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5551888599501718393L;
	/**
	 * La salle pr�c�dente
	 * @see Entree#Entree(Salle)
	 */
	private Salle sallePrecedente;
	
	/**
	 * Permet la cr�ation d'une case de type entr�e
	 */
	public Entree(){
		super();
		this.setEstTraversable(true);
		this.setTextureMotCle("portail_entree");
	}
	
	/**
	 * Permet la cr�ation d'une entr�e en sp�cifiant la salle pr�c�dente
	 * @param s
	 * 		La salle pr�c�dente
	 */
	public Entree(Salle s) {
		super();
		this.setEstTraversable(true);
		sallePrecedente =s;
		this.setTextureMotCle("portail_entree");

	}

	

	/**
	 * Permet de connaitre la salle pr�c�dente
	 * @return la salle pr�cedente
	 */
	public Salle getSallePrecedente() {
		return sallePrecedente;
	}
	/**
	 * Permet de modifier la salle pr�c�dente
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
