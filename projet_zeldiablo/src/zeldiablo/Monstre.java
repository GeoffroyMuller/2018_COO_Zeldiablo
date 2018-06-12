package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Creation de la classe Monstre
 */
public class Monstre extends Personnage {
	/**
	 * attribut booleen qui regardera si le deplacement du monstre est possible
	 */
	private boolean deplacementPossible;
	/**
	 * attribut boolean qui regardera si un monstre est lootable ou non
	 */
	private boolean lootable;
	/**
	 * methode qui regarde si le monstre est lootable ou non
	 * @return vrai si le monstre est lootable, faux s'il ne l'est pas 
	 */
	public boolean isLootable() {
		return lootable;
	}
	/**
	 * methode setter qui initialise le booleen avec celui passe en parametre
	 * @param lootable, boolean pour savoir si le monstre est lootable ou non
	 */
	public void setLootable(boolean lootable) {
		this.lootable = lootable;
	}
	/**
	 * Constructeur de Monstre qui initialise les attributs
	 * @param c, coordonnee du monstre
	 * @param s, salle ou se trouve le monstre
	 */
	public Monstre(Coordonnee c,Salle s) {
		super(c,s);
		baseDegat=3;
		baseVie=100;
		majStat();
		this.deplacementPossible = true;
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\monstre_violet_3.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDeplacementPossible(true);
		this.setDegats(2+this.stat.getForce()/10);
		this.getStat().ajoutExp(100);
		this.setLootable(true);
	}
	/**
	 * methode setter qui initialise les degats du monstre avec ceux passes en parametre
	 */
	public void setDegats(int degats) {
		super.setDegats(degats);
	}
	/**
	 * methode qui permet de savoir si le deplacement du monstre est possible
	 * @return vrai si le deplacement est possible, faux s'il est impossible
	 */
	public boolean isDeplacementPossible() {
		return deplacementPossible;
	}
	/**
	 * methode setter qui initialise le deplacement du monstre avec le boolean passe en parametre
	 * @param deplacementPossible, boolean pour savoir si le deplacment du monstre est possible ou non
	 */
	public void setDeplacementPossible(boolean deplacementPossible) {
		this.deplacementPossible = deplacementPossible;
	}
	/**
	 * methode qui permet de faire se deplacer le monstre 
	 * @param nbrAleatoire, nombre aleatoire
	 * @return vrai si le deplacement a ete effectue, faux s'il ne l'a pas ete 
	 */
	public boolean deplacement(Aleatoire nbrAleatoire) {
		boolean res = false;
		int x = this.getCoor().getX();
		int y = this.getCoor().getY();
		int random = nbrAleatoire.genererNombreAleatoire(0, 4);


		if(((x != 0) && (x!= Salle.TAILLE_SALLES-1) &&
				(y!= 0) && (y!= Salle.TAILLE_SALLES-1)) && this.deplacementPossible && !this.isMort()) {
			switch(random) {
			case 0:
				if((this.getSalle().isDeplacementPossible(x+1, y))) {
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setMonstrePresent(false);
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setEstTraversable(true);
					this.changerCoord(new Coordonnee(x+1,y));
					this.getSalle().getGrille()[x+1][y].setMonstrePresent(true);
					this.getSalle().getGrille()[x+1][y].setEstTraversable(false);
				}else {
					random+=1;
				}
				break;
			case 1:
				if(this.getSalle().isDeplacementPossible(x-1, y)) {
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setMonstrePresent(false);
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setEstTraversable(true);
					this.changerCoord(new Coordonnee(x-1,y));
					this.getSalle().getGrille()[x-1][y].setMonstrePresent(true);
					this.getSalle().getGrille()[x-1][y].setEstTraversable(false);
				}else {
					random+=1;
				}
				break;
			case 2:
				if(this.getSalle().isDeplacementPossible(x, y+1)) {
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setMonstrePresent(false);
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setEstTraversable(true);
					this.changerCoord(new Coordonnee(x,y+1));
					this.getSalle().getGrille()[x][y+1].setMonstrePresent(true);
					this.getSalle().getGrille()[x][y+1].setEstTraversable(false);
				}else {
					random+=1;
				}
				break;
			case 3:
				if(this.getSalle().isDeplacementPossible(x, y-1)) {
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setMonstrePresent(false);
					this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()].setEstTraversable(true);
					this.changerCoord(new Coordonnee(x,y-1));
					this.getSalle().getGrille()[x][y-1].setMonstrePresent(true);
					this.getSalle().getGrille()[x][y-1].setEstTraversable(false);
				}	
				break;
			}
		}



		return res;
	}

	/**
	 * methode qui permet de changer le niveau d'un monstre
	 * @param niv, niveau du monstre
	 */
	public void changerNiveau(int niv) {
		stat.modifierNiveau(niv);
		majStat();
	}

}

