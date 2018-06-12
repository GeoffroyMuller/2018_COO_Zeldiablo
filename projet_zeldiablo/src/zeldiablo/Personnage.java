package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Personnage {
	
	Stats stat;
	
	/**
	 * Les points de vie de l'aventurier
	 * @see Aventurier#getVie()
	 * @see Aventurier#modifierVie(int)
	 * @see Aventurier#setVie(int)
	 * @see Aventurier#soigner(int)
	 * @see Aventurier#subirDegats(int)
	 */
	private int vie;
	/**
	 * Les points d'attaque de l'aventurier
	 */
	private int degats;
	/**
	 * Permet de savoir si le joueur et vivant ou mort
	 * @see Aventurier#isMort()
	 * @see Aventurier#setMort(boolean)
	 */
	private boolean mort;
	/**
	 * Les coordonn�es de l'aventurier
	 * @see Aventurier#changerCoord(Coordonnee)
	 * @see Aventurier#deplacerAventurier(Coordonnee)
	 * @see Aventurier#getCoor()
	 * @see Aventurier#setCoor(Coordonnee)
	 * @see Aventurier#Aventurier(Coordonnee, Salle, Etage)
	 */
	private Coordonnee coor; //coordonnee de l'aventurier
	/**
	 * La salle o� se trouve l'aventurier
	 * @see Aventurier#changementSalle(Salle, Case)
	 * @see Aventurier#getSalle()
	 * @see Aventurier#setSalle(Salle)
	 * @see Aventurier#Aventurier(Coordonnee, Salle, Etage)
	 */
	private Salle salle;
	/**
	 * L'�tage o� se trouve l'aventurier
	 * @see Aventurier#getEtage()
	 * @see Aventurier#setEtage(Etage)
	 * @see Aventurier#Aventurier(Coordonnee, Salle, Etage)
	 */
	private Etage etage;
	/**
	 * La texture de l'aventurier, correspond a une image .png de 30*30pixel
	 * @see Aventurier#getTexture()
	 * @see Aventurier#setTexture(Image)
	 */
	private Image texture;

	/**
	 * Permet de retourner la texture de l'aventurier
	 * @return La texture de l'aventurier
	 * @see Aventurier#texture
	 */
	public Image getTexture() {
		return texture;
	}

	/**
	 * Permet de d�finir la texture de l'aventurier
	 * @param texture
	 * @see Aventurier#texture
	 */
	public void setTexture(Image texture) {
		this.texture = texture;
	}

	/**
	 * Permet la cr�ation d'un aventurier
	 */
	public Personnage(){
		stat = new Stats(1);
		vie = 100 + stat.getResistance();
		mort = false;
		degats = 25+stat.getForce();
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	/**
	 * Permet la cr�ation d'un Aventurier
	 * @param c
	 * 		Les coordonn�es de l'aventurier
	 * @param l
	 * 		La salle de l'aventurier
	 * @param et
	 * 		L'�tage de l'aventurier
	 * @see Aventurier#coor
	 * @see Aventurier#etage
	 * @see Aventurier#salle
	 * @see Aventurier#texture
	 */
	public Personnage(Coordonnee c, Salle l, Etage et){
		vie = 100;
		mort = false;
		coor = c;
		salle = l;
		this.etage = et;
	}
	
	public Personnage(Coordonnee c, Salle l){
		vie = 100;
		mort = false;
		coor = c;
		this.salle = l;
	}
	/**
	 * Permet de modifier la salle de l'aventurier
	 * @param salle
	 * 		La salle de l'aventurier
	 * @see Aventurier#salle
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * Permet de modifier l'�tage de l'aventurier
	 * @param etage
	 * 	L'�tage de l'aventurier
	 * @see Aventurier#etage
	 */
	public void setEtage(Etage etage) {
		this.etage = etage;
	}

	/**
	 * Permet de retourner la Salle de l'aventurier
	 * @return La salle de l'aventurier
	 * @see Aventurier#salle
	 */
	public Salle getSalle() {
		return salle;
	}

	/**
	 * Permet de retourner l'�tage de l'aventurier
	 * 
	 * @return L'�tage de l'aventurier
	 * @see Aventurier#etage
	 */
	public Etage getEtage() {
		return etage;
	}

	/**
	 * Permet de soigner l'aventurier
	 * @param pv
	 * 		Le nombre de point de vie � ajouter
	 * @see Aventurier#vie
	 */
	public void soigner(int pv) {
		if(pv > 0) {
			if(this.vie + pv > 100) {
				this.vie = 100;
			}else {
				modifierVie(pv);
			}
		}
	}

	/**
	 * Permet de modifier la vie de l'aventurier
	 * @param pv
	 * 		Les nouveaux points de vie de l'aventurier
	 * @see Aventurier#vie
	 */
	public void modifierVie(int pv) {
		this.vie+=pv;
	}

	/**
	 * Permet � l'aventurier de subir des d�gats
	 * @param pv
	 * 		Les points de vie � enlever (Doit �tre positif)
	 * @see Aventurier#vie
	 */
	public void subirDegats(int pv) {
		if(pv > 0) {
			if(this.vie-pv < 0) {
				this.vie = 0;
				setMort(true);
			}
			else {
				modifierVie(-pv);
			}
		}
	}


	/**
	 * Permet le changement des coordonn�es de l'aventurier
	 * @param c
	 * 		Les nouvelles coordonn�es
	 * @see Aventurier#coor
	 */
	public void changerCoord(Coordonnee c) {
		this.coor = c;
	}

	/**
	 * Permet de savoir si l'aventurier est en vie
	 * @return booleen indiquant si l'aventurier est en vie
	 * @see Aventurier#mort
	 */
	public boolean enVie() {
		return isMort();
	}

	/**
	 * Permet de retourner la vie de l'aventurier
	 * @return les points de vie de l'aventurier
	 * @see Aventurier#vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * Permet de remplacer les points de vie de l'aventurier
	 * @param vie
	 * 		Le nombre d epoints de vie
	 * @see Aventurier#vie
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isMort() {
		return mort;
	}

	/**
	 * Permet de d�finir l'aventurier comme mort
	 * @param mort
	 * 		Booleen indiquant si l'aventurier est mort
	 * @see Aventurier#mort
	 */
	public void setMort(boolean mort) {
		this.mort = mort;
	}
	/**
	 * Permet de retourner les coordonn�e de l'aventurier
	 * @return les coordonn�es de l'aventurier
	 * @see Aventurier#coor
	 */
	public Coordonnee getCoor() {
		return coor;
	}
	/**
	 * Permet de remplacer les coordonn�es de l'aventurier
	 * @param coor
	 * 	Les nouvelles coordonn�es de l'aventurier
	 * @see Aventurier#coor
	 */
	public void setCoor(Coordonnee coor) {
		this.coor = coor;
	}

	/**
	 * Permet de retourner la case actuel de l'aventurier
	 * @return la case de l'aventurier
	 * 
	 */
	public Case getCase() {
		return (this.salle.getGrille()[this.coor.getX()][this.coor.getY()]);
	}


}


