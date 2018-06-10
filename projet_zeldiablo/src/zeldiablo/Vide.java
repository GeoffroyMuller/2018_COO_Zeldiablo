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
	 * @see zeldiablo.Case#estTraversable()
	 */
	@Override
	public boolean estTraversable() {
		return true;
	}
	
	/**
	 * Permet la création d'une case vide
	 */
	public Vide(){
		try {
			this.texture = ImageIO.read(new File("..\\texture\\wood.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "vide";
	}
	
}
