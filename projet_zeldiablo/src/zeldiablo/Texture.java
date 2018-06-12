package zeldiablo;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * Creation de la classe Texture
 *
 */
public class Texture {
	/**
	 * attribut Image qui contiendra l'image que l'on veut assigner
	 */
	private Image img;
	/**
	 * attribut String qui contiendra le nom de l'image
	 */
	private String nom;
	/**
	 * Constructeur de Texture qui initialise les attributs
	 * @param n, nom de l'image
	 * @param chemin, chemin d'acces a l'image
	 */
	public Texture(String n, String chemin) {
		nom = n;
		try {
			img = ImageIO.read(new File(chemin));
		}
		catch(Exception  e) {
			System.out.println("erreur dans le chargement de a  la texture : "+nom+" : "+nom);
		}
	}
	/**
	 * methode getter qui va cherhcer l'image 
	 * @return l'image voulue
	 */
	public Image getImg() {
		return img;
	}
	/**
	 * methode getter qui va chercher le nom de l'image
	 * @return le nom de l'image 
	 */
	public String getNom() {
		return nom;
	}

}
