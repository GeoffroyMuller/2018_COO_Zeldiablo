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
	/**
	 * attribut booleen qui regardera si la case est traversable
	 */
	private boolean estTraversable;
	/**
	 * attribut booleen qui regarde si un monstre est present ou pas sur la case
	 */
	private boolean monstrePresent;
	/**
	 * attribut booleen qui regarde si un objet est present ou non sur la case
	 */
	private boolean objetPresent;

	/**
	 * methode qui permet de voir si un montre est present ou pas sur la case
	 * @return vrai si un monstre est present, faux s'il ne l'est pas 
	 */
	public boolean isMonstrePresent() {
		return monstrePresent;
	}
	/**
	 * methode setter qui initialise le boolean avec celui passe en parametre
	 * @param monstrePresent, boolean pour savoir si un monstre est présent
	 */
	public void setMonstrePresent(boolean monstrePresent) {
		this.monstrePresent = monstrePresent;
	}
	/**
	 * methode pour savoir si un objet est présent ou pas 
	 * @return vrai si un objet est present, faux s'il n'y en a pas 
	 */
	public boolean isObjetPresent() {
		return objetPresent;
	}
	/**
	 * methode setter qui initialise le booleen avec celui passe en parametre
	 * @param objetPresent, boolean pour savoir si un objet est present
	 */
	public void setObjetPresent(boolean objetPresent) {
		this.objetPresent = objetPresent;
	}
	/**
	 * methode setter qui initialise le boolean avec celui passe en parametre
	 * @param estTraversable, boolean pour savoir si la cas est traversable
	 */
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
	/**
	 * methode getter qui va chercher le mot cle de la texture
	 */
	public String getTextureMotCle() {
		return textureMotCle;
	}
	/**
	 * methode setter qui initialise le mot cle de la texture avec celui passe en parametre
	 * @param textureMotCle, mot cle de la texture
	 */
	public void setTextureMotCle(String textureMotCle) {
		this.textureMotCle = textureMotCle;
	}
	
	
}
