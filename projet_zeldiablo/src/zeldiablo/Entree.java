package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Entree extends Case{
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
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Entree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet la création d'une entrée en spécifiant la salle précédente
	 * @param s
	 * 		La salle précédente
	 */
	public Entree(Salle s) {
		super();
		sallePrecedente =s;
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Entree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
