package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Aventurier extends Personnage implements Serializable{

	/**
	 * Permet la cr�ation d'un aventurier
	 */
	public Aventurier(){
		super();
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\Aventurier_Final.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public Aventurier(Coordonnee c, Salle l, Etage et){
		super(c,l,et);
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\Aventurier_Final.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet le d�placement de l'aventurier
	 * @param c
	 * 		Les futurs coordonn�es de l'aventurier
	 * @return un booleen indiquant si le d�placement est bien effectu�
	 */
	public boolean deplacerAventurier(Coordonnee c) {
		boolean res = false;

		if ((c.getX() < this.getSalle().getGrille().length && c.getX() >= 0) &&
				(c.getY() < this.getSalle().getGrille()[0].length && c.getY() >= 0)) {

			if(this.getSalle().getGrille()[c.getX()][c.getY()].estTraversable()) {

				this.changerCoord(c);
				res=true;

				if(this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()]==this.getSalle().getEntree()) {

					this.setSalle(this.getSalle().getEntree().getSallePrecedente());
					changementSalle(this.getSalle(),this.getSalle().getSortie());

				}

				else if(this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()]==this.getSalle().getSortie()) {

					this.setSalle(this.getSalle().getSortie().getSalleSuivante());
					changementSalle(this.getSalle(), this.getSalle().getEntree());
					System.out.println("sortie");
				}
				else if(this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()]==this.getSalle().getEscalier()){
					changementEtage(this.getSalle().getEscalier().getSalleEtageSup(), this.getSalle().getEscalier().getEtageSup());
				}

			}
		}
		else {
			res = false;
		}

		return res;
	}
	
<<<<<<< HEAD
	public void changementEtage(Salle s, Etage e) {
		Coordonnee c = new Coordonnee(12, 12);
		this.setCoor(c);
		this.setEtage(e);
		this.setSalle(s);
	}
	
	
	/**
	 * Permet � l'aventurier de changer de salle
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

		for (int i = 0; i < Salle.TAILLE_SALLES; i++) {
			for (int j = 0; j < Salle.TAILLE_SALLES; j++) {
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

	
=======
	public void attaque(int att) {
		Coordonnee monstre = new Coordonnee(0,1);
		for(int i = 0; i < this.getSalle().getMonstrePresent().size(); i++) {
			monstre = this.getSalle().getMonstrePresent().get(i).getCoor();
			if((monstre.getX() == this.getCoor().getX()+1 && monstre.getY() == this.getCoor().getY()) ||
					(monstre.getX() == this.getCoor().getX()-1 && monstre.getY() == this.getCoor().getY()) ||
					(monstre.getX() == this.getCoor().getX() && monstre.getY() == this.getCoor().getY()+1) ||
					(monstre.getX() == this.getCoor().getX()+1 && monstre.getY() == this.getCoor().getY()-1)) {
				this.getSalle().getMonstrePresent().get(i).subirDegats(att);
			}
					
		}
>>>>>>> 7b4ad94312017821497e9ba75a8407eac79d9ce6
	}
}
