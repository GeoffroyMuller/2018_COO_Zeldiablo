package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public abstract class Case implements Serializable{
	
	 /**
	 * La texture de la case, correspond a une image .png de 30*30pixel
	 * @see Case#getTexture()
	 * @see Case#setTexture(Image)
	 */
	protected Image texture;


	/**
	 * Permet de retourner la texture de la case
	 * @return La texture de la case
	 */
	public Image getTexture() {
		return texture;
	}

	/**
	 * Permet d'appliquer une texture sur une case
	 * @param texture
	 * 		La texture à appliquer
	 */
	public void setTexture(Image texture) {
		this.texture = texture;
	}

	/**
	 * Constructeur vide pour créer une case
	 */
	public Case(){

	}
	
	/**
	 * Permet de savoir si une case est traversable ou non
	 * @return Vrai si la case est traversable et faux le cas écheant
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
	
	
}
