package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Aventurier {
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
	public Aventurier(){
		vie = 100;
		mort = false;
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Aventurier_Final.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public Aventurier(Coordonnee c, Salle l, Etage et){
		vie = 100;
		mort = false;
		coor = c;
		salle = l;
		this.etage = et;
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Aventurier_Final.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * Permet le déplacement de l'aventurier
	 * @param c
	 * 		Les futurs coordonnées de l'aventurier
	 * @return un booleen indiquant si le déplacement est bien effectué
	 */
	public boolean deplacerAventurier(Coordonnee c) {
		boolean res = true;

		if ((c.getX() < salle.getGrille().length && c.getX() >= 0) &&
				(c.getY() < salle.getGrille()[0].length && c.getY() >= 0)) {
			if(salle.getGrille()[c.getX()][c.getY()].estTraversable()) {
				this.changerCoord(c);

				if(salle.getGrille()[coor.getX()][coor.getY()]==salle.getEntree()) {
					this.salle=salle.getEntree().getSallePrecedente();
					changementSalle(this.salle,salle.getSortie());
					System.out.println("entree");
				}
				else {
					if(salle.getGrille()[coor.getX()][coor.getY()]==salle.getSortie()) {
						this.salle=salle.getSortie().getSalleSuivante();
						changementSalle(this.salle, salle.getEntree());
						System.out.println("sortie");
					}
				}

			}
			else {
				res = false;
			}
		}
		else {
			res = false;
		}

		return res;
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
	 * Permet à l'aventurier de changer de salle
	 * @param s
	 * 		La futur salle de l'aventurier
	 * @param c
	 * 		La future case de l'aventurier
	 * @see Aventurier#salle
	 * @see Case
	 */
	public void changementSalle(Salle s, Case c) {
		Case [][] grille = s.getGrille();
		int x=12,y=12;

		for (int i = 0; i < salle.TAILLE_SALLES; i++) {
			for (int j = 0; j < salle.TAILLE_SALLES; j++) {
				if(grille[i][j]==c) {
					x=i;
					y=j;
				}
			}
		}
		Coordonnee co = new Coordonnee(x, y);
		co.decrementerX();
		if(deplacerAventurier(co)) {
			System.out.println("1");

		}
		else {
			co.incrementerY();
			co.incrementerX();
			if(deplacerAventurier(co)) {
				System.out.println("2");
			}
			else {
				co.decrementerY();
				co.incrementerX();
				if(deplacerAventurier(co)) {
				}
				else {
					co.decrementerX();
					co.decrementerY();
					if(deplacerAventurier(co)) {
					}
					else {
						System.out.println("erreur de deplacement");
					}


				}
			}
		}

	}




}
