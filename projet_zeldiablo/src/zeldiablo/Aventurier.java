package zeldiablo;

public class Aventurier {
	private int vie;
	private boolean mort;
	private Coordonnee coor; //coordonnee de l'aventurier
	private Labyrinthe lab;

	public Aventurier(){
		vie = 100;
		mort = false;
	}

	public Aventurier(Coordonnee c, Labyrinthe l){
		vie = 100;
		mort = false;
		coor = c;
		lab = l;
	}
	public void soigner(int pv) {
		if(pv > 0) {
			if(this.vie + pv > 100) {
				this.vie = 100;
			}else {
				modifierVie(pv);
			}
		}
	}

	public void modifierVie(int pv) {
		this.vie+=pv;
	}

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

	public boolean deplacerAventurier(Coordonnee c) {
		boolean res = true;
		
		if ((c.getX() < lab.getGrille().length && c.getX() >= 0) &&
				(c.getY() < lab.getGrille()[0].length && c.getY() >= 0)) {
			if(lab.getGrille()[c.getX()][c.getY()].estTraversable()) {
				this.changerCoord(c);
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

	public void changerCoord(Coordonnee c) {
		this.coor = c;
	}

	public boolean enVie() {
		return isMort();
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}
	public Coordonnee getCoor() {
		return coor;
	}
	public void setCoor(Coordonnee coor) {
		this.coor = coor;
	}

	public Case getCase() {
		return (this.lab.getGrille()[this.coor.getX()][this.coor.getY()]);
	}


}
