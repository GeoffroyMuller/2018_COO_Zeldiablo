package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Vide extends Case implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7264174760504718360L;

	/**
	 * Permet la création d'une case vide
	 */
	public Vide(){
		this.setEstTraversable(true);
		this.setTextureMotCle("sol_bois");
	}

	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "vide";
	}
	
}
