package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Creation de la classe MonstreFantome
 */
public class MonstreFantome extends Monstre {
	/**
	 * Constructeur de MonstreFantome qui initialise les attributs
	 * @param c, coordonnee du monstre
	 * @param s, salle ou est situe le monstre
	 */
	public MonstreFantome(Coordonnee c, Salle s) {
		super(c, s);
		baseDegat=8;
		baseVie=40;
		majStat();
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\fantome.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
