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
public class Aventurier extends Personnage implements Serializable, ObjetTexturer{
	
	
	
	/**
	 * Permet la création d'un aventurier
	 */
	public Aventurier(){
		super();
		baseDegat=15;
		baseVie=140;
		majStat();
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\Aventurier_Final.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDegats(5);
	}
	
	public void setDegats(int degats) {
		super.setDegats(degats);
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
		baseDegat=15;
		baseVie=140;
		majStat();
		this.setTextureMotCle("aventurier");
		
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
				
				this.getCase().setEstTraversable(true);
				this.changerCoord(c);
				this.getCase().setEstTraversable(false);
				res=true;

				if(this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()]==this.getSalle().getEntree()) {
					
					this.getSalle().getEntree().setEstTraversable(true);
					this.getSalle().getSortie().setEstTraversable(true);
					this.setSalle(this.getSalle().getEntree().getSallePrecedente());
					changementSalle(this.getSalle(),this.getSalle().getSortie());

				}

				else if(this.getSalle().getGrille()[this.getCoor().getX()][this.getCoor().getY()]==this.getSalle().getSortie()) {
					
					this.getSalle().getEntree().setEstTraversable(true);
					this.getSalle().getSortie().setEstTraversable(true);
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
	/**
	 * methode qui permet de faire le changement d'etage
	 * @param s, salle ou l'on va
	 * @param e, etage ou l'on va 
	 */
	public void changementEtage(Salle s, Etage e) {
		Coordonnee c = new Coordonnee(12, 12);
		this.setCoor(c);
		this.setEtage(e);
		this.setSalle(s);
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
	}

	/**
	 * methode qui permet d'attaquer pour les monstres et les aventuriers
	 */
	public void attaque() {
		Coordonnee monstre = new Coordonnee(0,1);
		for(int i = 0; i < this.getSalle().getMonstrePresent().size(); i++) {
			monstre = this.getSalle().getMonstrePresent().get(i).getCoor();
			if((monstre.getX() == this.getCoor().getX()+1 && monstre.getY() == this.getCoor().getY()) ||
					(monstre.getX() == this.getCoor().getX()-1 && monstre.getY() == this.getCoor().getY()) ||
					(monstre.getX() == this.getCoor().getX() && monstre.getY() == this.getCoor().getY()+1) ||
					(monstre.getX() == this.getCoor().getX() && monstre.getY() == this.getCoor().getY()-1)) {
				this.getSalle().getMonstrePresent().get(i).subirDegats(this.getDegats());
				if( this.getSalle().detecterLesMorts()) {
					this.stat.ajoutExp(this.getSalle().getMonstrePresent().get(i).getStat().getExp());
					if(this.stat.getExp()==0) {
						majStat();
					}
					System.out.println("ajout d'xp : "+this.getSalle().getMonstrePresent().get(i).getStat().getExp());
				}
				System.out.println("Aventurier fait "+this.getDegats());
				System.out.println("Vie monstre "+ this.getSalle().getMonstrePresent().get(i).getVie());
			}
					
		}
	}
	


	@Override
	public String getTextureMotCle() {
		return super.getTextureMotCle();
	}
}
