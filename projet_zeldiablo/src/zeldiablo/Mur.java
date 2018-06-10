package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Mur extends Case{

	/**
	 * @see zeldiablo.Case#estTraversable()
	 */
	@Override
	public boolean estTraversable() {
		return false;
	}
	
	
	/**
	 * Permet la création d'un mur
	 */
	public Mur() {
		super();
		try {
			this.texture = ImageIO.read(new File("..\\texture\\wall_stone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "mur";
	}




}
