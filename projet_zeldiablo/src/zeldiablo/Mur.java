package zeldiablo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Mur extends Case implements Serializable{

	
	
	/**
	 * Permet la cr�ation d'un mur
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
