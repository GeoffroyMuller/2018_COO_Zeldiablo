package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public abstract class Case implements Serializable{
	
	 /**
	 * La texture de la case, correspond a une image .png de 30*30pixel
	 * @see Case#getTexture()
	 * @see Case#setTexture(Image)
	 */
	private String textureMotCle;


	/**
	 * Constructeur vide pour cr�er une case
	 */
	public Case(){

	}
	
	/**
	 * Permet de savoir si une case est traversable ou non
	 * @return Vrai si la case est traversable et faux le cas �cheant
	 */
	public abstract boolean estTraversable();
	
	/**
	 * Permet de savoir le type d'une case
	 * @return Le type d'une case
	 */
	public abstract String getType();
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = this.getType();
		return s;
	}

	public String getTextureMotCle() {
		return textureMotCle;
	}

	public void setTextureMotCle(String textureMotCle) {
		this.textureMotCle = textureMotCle;
	}
	
	
}
