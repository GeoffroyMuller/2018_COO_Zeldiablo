package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monstre extends Personnage {

	private boolean deplacementPossible;
	private boolean lootable;
	
	public boolean isLootable() {
		return lootable;
	}

	public void setLootable(boolean lootable) {
		this.lootable = lootable;
	}

	public Monstre(Coordonnee c,Salle s) {
		super(c,s);
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
	
	public void setDegats(int degats) {
		super.setDegats(degats);
	}

	public boolean isDeplacementPossible() {
		return deplacementPossible;
	}

	public void setDeplacementPossible(boolean deplacementPossible) {
		this.deplacementPossible = deplacementPossible;
	}

	public boolean deplacement(Aleatoire nbrAleatoire) {
		boolean res = false;
		int x = this.getCoor().getX();
		int y = this.getCoor().getY();
		int random = nbrAleatoire.genererNombreAleatoire(0, 4);

				
		if((x != 0) && (x!= Salle.TAILLE_SALLES-1) &&
				(y!= 0) && (y!= Salle.TAILLE_SALLES-1) && this.deplacementPossible) {
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

}

