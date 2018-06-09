package zeldiablo;

import java.util.ArrayList;

import moteur.Commande;
import moteur.Jeu;


public class ZeldiabloJeu implements Jeu {
	private Aventurier av;
	private ArrayList<Labyrinthe> listLab;
	
	public ZeldiabloJeu() {
		this.listLab= new ArrayList<Labyrinthe>();
		for (int i = 0; i < 10; i++) {
			listLab.add(new Labyrinthe());
		}
		this.av = new Aventurier(new Coordonnee(3,1),this.listLab.get(0));
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
	public ArrayList<Labyrinthe> getListLab() {
		return listLab;
	}
	

}
