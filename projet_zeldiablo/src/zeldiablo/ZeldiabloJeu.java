package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import moteur.Commande;
import moteur.Jeu;


/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class ZeldiabloJeu implements Jeu {
	/**
	 * Attribut "av" de type Aventurier, correspond au joueur
	 */
	private Aventurier av;
	/**
	 * Attribut "dj" de type Donjon correspond à l'ensemble des étage que le joueur est amené a parcourir
	 */
	private Donjon dj;
	
	private Image spriteVictoire;
	private Image spriteDefaite;
	
	private boolean victoire;

	private int compteur;

	/**
	 * Constructeur vide ZeldiabloJeu, construit un jeu en construisant un Donjon et un Aventurier
	 */
	public ZeldiabloJeu() {
		dj= new Donjon("ElTesto");
		victoire =false;
		try {
		spriteVictoire = ImageIO.read(new File("..\\\\texture\\You_Win.png"));
		spriteDefaite = ImageIO.read(new File("..\\\\texture\\GameOver.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		this.av = new Aventurier(new Coordonnee(12,12),this.dj.getEtages().get(0).getSalles().get(0), this.dj.getEtages().get(0));
	}

	/**
	 * Fait evoluer le jeu en fonction de la commande du joueur.
	 * 
	 * @param commandeUser
	 * 		Commande effectuer par le joueur
	 * 
	 * @see moteur.Jeu#evoluer(moteur.Commande)
	 */
	@Override
	public void evoluer(Commande commandeUser) {
		Coordonnee posAv = new Coordonnee(0,0);

		posAv.dupliquerCoordonnee(this.av.getCoor());
		if(commandeUser.gauche) {
			posAv.decrementerX();
		}else if(commandeUser.droite) {
			posAv.incrementerX();
		}else if(commandeUser.bas) {
			posAv.incrementerY();
		}else if(commandeUser.haut) {
			posAv.decrementerY();
		}
		else if(commandeUser.attaque) {
			this.av.attaque();
			this.av.setTextureMotCle("aventurierAtt");
		}
		if(this.av.deplacerAventurier(posAv)) {

			if(this.av.getSalle().getGrille()[this.av.getCoor().getX()][this.av.getCoor().getY()].getType().contains("escalier")) {
				changementEtage();	
			}
		}
		Aleatoire randomV=new AleatoireVrai();
		if(compteur == 7) {
			for(int i =0; i< this.av.getSalle().getMonstrePresent().size();i++) {
				this.av.getSalle().getMonstrePresent().get(i).deplacement(randomV);

			}
			this.av.getSalle().detecterCombat(av);
			compteur=0;
		}
		compteur++;

		this.av.getSalle().prendreItem(av);
		this.av.getSalle().detecterLesMorts();
		if(av.getSalle()==dj.getEtages().get(Donjon.NUM_ETAGES-1).getSalles().get((int)(Etage.NUM_SALLES/2))) {
			int xa =this.av.getCoor().getX();
			int ya = this.av.getCoor().getY();
			
			int xs= av.getSalle().getPortailFin().getCoord().getX();
			int ys= av.getSalle().getPortailFin().getCoord().getY();
			if(xa==xs && ya==ys) {
				victoire=true;
			}
					
		}
;

	}

	public boolean isVictoire() {
		return victoire;
	}
	/**
	 * Permet le changement d'étage de l'Aventurier
	 */
	public void changementEtage() {
		Etage nouveauEtage = this.dj.getEtages().get(this.dj.getEtages().indexOf(this.av.getEtage())+1);
		Salle nouvelleSalle = nouveauEtage.getSalles().get(0);
		this.av.setEtage(nouveauEtage);
		this.av.setSalle(nouvelleSalle);
		this.av.changementSalle(nouvelleSalle, nouvelleSalle.getEntree());
	}

	/**
	 * Permet de savoir si le jeu est fini ou non
	 * 
	 * @return booleen indiquant si le jeu est fini
	 * 
	 * @see moteur.Jeu#etreFini()
	 */
	@Override
	public boolean etreFini() {
		boolean res = false;
		if(this.av.isMort()) {
			res=true;
		}
		else {
			if(victoire) {
				res=true;
			}
		}
		return res;
	}
	/**
	 * @return l'Aventurier controllé par le joueur
	 * 
	 * @see ZeldiabloJeu#av
	 */
	public Aventurier getAv() {
		return av;
	}
	/**
	 * @return Le donjon dans lequel le joueur évolue
	 * 
	 * @see ZeldiabloJeu#dj
	 */
	public Donjon getDj() {
		return dj;
	}
	
	public Image getSpriteVictoire() {
		return spriteVictoire;
	}
	public Image getSpriteDefaite() {
		return spriteDefaite;
	}


}
