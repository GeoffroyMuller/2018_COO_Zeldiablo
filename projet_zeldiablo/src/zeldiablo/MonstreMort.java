package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Creation de la classe MonstreMort
 */
public class MonstreMort extends Monstre {
	/**
	 * Constructeur de MonstreMort qui initialise les attributs
	 * @param c, coordonnee du monstre mort
	 * @param s, salle ou se trouve le monstre mort
	 */
	public MonstreMort(Coordonnee c, Salle s) {
		super(c, s);
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\monstre_skelette_4.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setMort(false);
		this.setDeplacementPossible(false);
		this.setDegats(0);
		this.setVie(0);
		this.setLootable(false);
		
	}
	/**
	 * methode setter qui initialise le deplacement du monstre a faux tout le temps
	 */
	@Override
	public void setDeplacementPossible(boolean deplacementPossible) {
		super.setDeplacementPossible(false);
	}

}
