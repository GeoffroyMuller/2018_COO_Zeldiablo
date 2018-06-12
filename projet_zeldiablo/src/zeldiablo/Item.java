package zeldiablo;

import java.awt.Graphics;
/**
 * Creation de la classe Item 
 */
public abstract class Item implements ObjetTexturer {
	/**
	 * attribut String qui contiendra le type d'item
	 */
	String type;
	/**
	 * attribut Salle contiendra la salle ou sera l'item
	 */
	Salle salle;
	/**
	 * attribut Coordonnee qui contiendra la coordonnee de l'item
	 */
	Coordonnee coo;
	/**
	 * attribut String qui contiendra le mot cle pour la texture
	 */
	String motCle;
	/**
	 * Constructeur de Item qui initialise les attributs
	 * @param rtype, type de l'item
	 * @param se, salle ou est l'item
	 * @param xe, coordonnee x de l'item
	 * @param ye, coordonnee y de l'item
	 */
	public Item(String rtype,Salle se,int xe,int ye) {
		// TODO Auto-generated constructor stub
		type = rtype;
		salle = se;
		coo = new Coordonnee(xe,ye);
	}
	/**
	 * methode abstraite qui permet d'appliquer l'effet d'un item sur un aventurier
	 * @param av, aventurier sur qui appliquer l'effet
	 */
	public abstract void effetItem(Aventurier av);
	/**
	 * methode getter qui va chercher le type de l'item
	 * @return le type de l'item
	 */
	public String getType() {
		return type;
	}
	/**
	 * methode getter qui va chercher la coordonnee de l'item
	 * @return la coordonee de l'item
	 */
	public Coordonnee getCoo() {
		return coo;
	}
	/**
	 * methode getter qui va chercher la salle dans laquelle est l'item
	 * @return
	 */
	public Salle getSalle() {
		return salle;
	}


}
