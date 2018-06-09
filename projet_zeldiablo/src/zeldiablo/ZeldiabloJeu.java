package zeldiablo;

import java.util.ArrayList;

import moteur.Commande;
import moteur.Jeu;


public class ZeldiabloJeu implements Jeu {
	private Aventurier av;
	private Donjon dj;

	public ZeldiabloJeu() {
		dj= new Donjon("ElTesto");

		this.av = new Aventurier(new Coordonnee(12,12),this.dj.getEtages().get(0).getSalles().get(0), this.dj.getEtages().get(0));
	}
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
		if(this.av.deplacerAventurier(posAv)) {

			if(this.av.getSalle().getGrille()[this.av.getCoor().getX()][this.av.getCoor().getY()].getType().contains("escalier")) {
				changementEtage();	
			}
		}
	}

	public void changementEtage() {
		Etage nouveauEtage = this.dj.getEtages().get(this.dj.getEtages().indexOf(this.av.getEtage())+1);
		Salle nouvelleSalle = nouveauEtage.getSalles().get(0);
		this.av.setEtage(nouveauEtage);
		this.av.setSalle(nouvelleSalle);
		this.av.changementSalle(nouvelleSalle, nouvelleSalle.getEntree());
	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}
	public Aventurier getAv() {
		return av;
	}
	public Donjon getDj() {
		return dj;
	}


}
