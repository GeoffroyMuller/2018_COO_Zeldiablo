package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Creation de la classe MonstreRouge 
 */
public class MonstreRouge extends Monstre {
	/**
	 * Constructeur de MonstreRouge
	 * @param c, coordonnee du monstre
	 * @param s, salle ou se trouve le monstre
	 */
	public MonstreRouge(Coordonnee c, Salle s) {
		super(c, s);
		baseDegat=6;
		baseVie=80;
		majStat();
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\monstre_rouge_2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDegats(6+this.stat.getForce()/10);
	}
	/**
	 * methode setter qui initialise les degats avec ceux donnes en parametre
	 */
	public void setDegats(int degats) {
		super.setDegats(degats);
	}
}


