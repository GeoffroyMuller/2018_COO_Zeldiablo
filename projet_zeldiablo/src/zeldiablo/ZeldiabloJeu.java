package zeldiablo;

import java.util.ArrayList;

import moteur.Commande;
import moteur.Jeu;


public class ZeldiabloJeu implements Jeu {
	private Aventurier av;
	private Donjon dj;

	public ZeldiabloJeu() {
		dj= new Donjon("ElTesto");

		this.av = new Aventurier(new Coordonnee(3,1),this.dj.getEtages().get(0).getSalles().get(0));
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
		this.av.deplacerAventurier(posAv);

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
