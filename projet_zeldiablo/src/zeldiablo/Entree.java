package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Entree extends Case{
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
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Entree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet la cr�ation d'une entr�e en sp�cifiant la salle pr�c�dente
	 * @param s
	 * 		La salle pr�c�dente
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
