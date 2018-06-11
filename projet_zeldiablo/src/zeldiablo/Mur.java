package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Mur extends Case implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1340784360211029367L;

	/**
	 * Permet la création d'un mur
	 */
	public Mur() {
		super();
		this.setEstTraversable(false);
		this.setTextureMotCle("wall_dark");
	}
	
	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "mur";
	}




}
