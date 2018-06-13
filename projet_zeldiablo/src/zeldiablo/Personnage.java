package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Personnage {
	int baseDegat;
	Stats stat;
	int baseVie;
	
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
	 * Les coordonnées de l'aventurier
	 * @see Aventurier#changerCoord(Coordonnee)
	 * @see Aventurier#deplacerAventurier(Coordonnee)
	 * @see Aventurier#getCoor()
	 * @see Aventurier#setCoor(Coordonnee)
	 * @see Aventurier#Aventurier(Coordonnee, Salle, Etage)
	 */
	private Coordonnee coor; //coordonnee de l'aventurier
	/**
	 * La salle où se trouve l'aventurier
	 * @see Aventurier#changementSalle(Salle, Case)
	 * @see Aventurier#getSalle()
	 * @see Aventurier#setSalle(Salle)
	 * @see Aventurier#Aventurier(Coordonnee, Salle, Etage)
	 */
	private Salle salle;
	/**
	 * L'étage où se trouve l'aventurier
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
	 * attribut String qui contiendra le mot cle de la texture
	 */
	private String textureMotCle;
	/**
	 * methode getter qui va chercher le mot cle de la texture
	 * @return le mot cle de la texture
	 */
	public String getTextureMotCle() {
		return textureMotCle;
	}
	/**
	 * methode setter qui initialise le mot cle de la texture
	 * @param textureMotCle, mot cle de la texture
	 */
	public void setTextureMotCle(String textureMotCle) {
		this.textureMotCle = textureMotCle;
	}

	/**
	 * Permet de retourner la texture de l'aventurier
	 * @return La texture de l'aventurier
	 * @see Aventurier#texture
	 */
	public Image getTexture() {
		return texture;
	}

	/**
	 * Permet de définir la texture de l'aventurier
	 * @param texture
	 * @see Aventurier#texture
	 */
	public void setTexture(Image texture) {
		this.texture = texture;
	}

	/**
	 * Permet la création d'un aventurier
	 */
	public Personnage(){
		stat = new Stats(1);
		vie = baseVie + stat.getResistance();
		mort = false;
		degats = baseDegat+stat.getForce();
	}
	/**
	 * methode getter qui va chercher les degats d'un personnage
	 * @return les degats d'un personnage
	 */
	public int getDegats() {
		return degats;
	}
	/**
	 * methode setter qui initialise les degats du personnage avec ceux passes en parametre
	 * @param degats, degats du personnage 
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}

	/**
	 * Permet la création d'un Aventurier
	 * @param c
	 * 		Les coordonnées de l'aventurier
	 * @param l
	 * 		La salle de l'aventurier
	 * @param et
	 * 		L'étage de l'aventurier
	 * @see Aventurier#coor
	 * @see Aventurier#etage
	 * @see Aventurier#salle
	 * @see Aventurier#texture
	 */
	public Personnage(Coordonnee c, Salle l, Etage et){
		stat = new Stats(1);
		vie = baseVie + stat.getResistance();
		mort = false;
		degats = baseDegat+stat.getForce();
		coor = c;
		salle = l;
		this.etage = et;
	}
	/**
	 * Constructeur de Personnage
	 * @param c, coordonnee du personnage
	 * @param l, salle ou est situe le personnage 
	 */
	public Personnage(Coordonnee c, Salle l){
		stat = new Stats(1);
		vie = baseVie + stat.getResistance();
		mort = false;
		degats = baseDegat+stat.getForce();
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
	 * Permet de modifier l'étage de l'aventurier
	 * @param etage
	 * 	L'étage de l'aventurier
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
	 * Permet de retourner l'étage de l'aventurier
	 * 
	 * @return L'étage de l'aventurier
	 * @see Aventurier#etage
	 */
	public Etage getEtage() {
		return etage;
	}

	/**
	 * Permet de soigner l'aventurier
	 * @param pv
	 * 		Le nombre de point de vie à ajouter
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
	 * Permet à l'aventurier de subir des dégats
	 * @param pv
	 * 		Les points de vie à enlever (Doit être positif)
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
	 * Permet le changement des coordonnées de l'aventurier
	 * @param c
	 * 		Les nouvelles coordonnées
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
	 * methode getter qui va chercher les points de base de degats d'un personnage
	 * @return les points de base de degats du personnage
	 */
	public int getBaseDegat() {
		return baseDegat;
	}
	/**
	 * methode getter qui va chercher les points de base de vie du personnage
	 * @return les points de base de la vie du personnage
	 */
	public int getBaseVie() {
		return baseVie;
	}
	/**
	 * methode getter qui va chercher les stats d'un personnage
	 * @return les stats du perosnnage
	 */
	public Stats getStat() {
		return stat;
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
	 * methode qui regarde si le personnage est mort ou non
	 * @return vrai si le personnage est mort, faux s'il n'est pas mort
	 */
	public boolean isMort() {
		return mort;
	}

	/**
	 * Permet de définir l'aventurier comme mort
	 * @param mort
	 * 		Booleen indiquant si l'aventurier est mort
	 * @see Aventurier#mort
	 */
	public void setMort(boolean mort) {
		this.mort = mort;
	}
	/**
	 * Permet de retourner les coordonnée de l'aventurier
	 * @return les coordonnées de l'aventurier
	 * @see Aventurier#coor
	 */
	public Coordonnee getCoor() {
		return coor;
	}
	/**
	 * Permet de remplacer les coordonnées de l'aventurier
	 * @param coor
	 * 	Les nouvelles coordonnées de l'aventurier
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
	/**
	 * methode qui met a jour les stats du personnage
	 */
	public void majStat() {
		this.setVie( baseVie + stat.getResistance());
		this.setDegats(baseDegat+stat.getForce());
	}
}


