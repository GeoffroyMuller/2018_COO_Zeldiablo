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
public abstract class Case implements Serializable, ObjetTexturer{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3638565670666757172L;

	/**
	 * La texture de la case, correspond a une image .png de 30*30pixel
	 * @see Case#getTexture()
	 * @see Case#setTexture(Image)
	 */
	private String textureMotCle;
	
	private boolean estTraversable;
	private boolean monstrePresent;
	private boolean objetPresent;


	public boolean isMonstrePresent() {
		return monstrePresent;
	}

	public void setMonstrePresent(boolean monstrePresent) {
		this.monstrePresent = monstrePresent;
	}

	public boolean isObjetPresent() {
		return objetPresent;
	}

	public void setObjetPresent(boolean objetPresent) {
		this.objetPresent = objetPresent;
	}

	public void setEstTraversable(boolean estTraversable) {
		this.estTraversable = estTraversable;
	}

	/**
	 * Constructeur vide pour créer une case
	 */
	public Case(){
		this.monstrePresent = false;
		this.objetPresent = false;
	}
	
	/**
	 * Permet de savoir si une case est traversable ou non
	 * @return Vrai si la case est traversable et faux le cas écheant
	 */
	public boolean estTraversable() {
		return this.estTraversable;
	}
	
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
