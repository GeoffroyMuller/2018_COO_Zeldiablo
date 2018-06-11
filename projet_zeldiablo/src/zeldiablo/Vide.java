package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Vide extends Case implements Serializable{


	
	/**
	 * Permet la cr�ation d'une case vide
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
