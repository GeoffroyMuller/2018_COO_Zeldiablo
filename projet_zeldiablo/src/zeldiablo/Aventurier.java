package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Aventurier extends Personnage implements Serializable{

	/**
	 * Permet la création d'un aventurier
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
		super(c,l,et);
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\Aventurier_Final.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet le déplacement de l'aventurier
	 * @param c
	 * 		Les futurs coordonnées de l'aventurier
	 * @return un booleen indiquant si le déplacement est bien effectué
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

			}
		}
		else {
			res = false;
		}

		return res;
	}
	
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
	}
}
