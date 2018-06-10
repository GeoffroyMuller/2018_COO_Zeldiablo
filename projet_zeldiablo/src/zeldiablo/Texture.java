package zeldiablo;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Texture {
	private Image img;
	private String nom;

	public Texture(String n, String chemin) {
		nom = n;
		try {
			img = ImageIO.read(new File(chemin));
		}
		catch(Exception  e) {
			System.out.println("erreur dans le chargement de a  la texture : "+nom+" : "+nom);
		}
	}

	public Image getImg() {
		return img;
	}

	public String getNom() {
		return nom;
	}

}
