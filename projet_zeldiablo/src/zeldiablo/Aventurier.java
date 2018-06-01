package zeldiablo;

public class Aventurier {
	private int vie;
	private boolean mort;
	private Coordonnee pos; // case sur laquelle se trouve l'aventurier
	private Labyrinthe l;
	
	public Aventurier(){
		vie = 100;
		mort = false;
	}
	public Aventurier(Coordonnee c){
		vie = 100;
		mort = false;
		pos = c;
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
			if(this.vie+pv < 0) {
				this.vie = 0;
				setMort(true);
			}
			else {
				modifierVie(pv);
			}
		}
	}
	
	public boolean deplacerAventurier(Coordonnee c) {
		boolean res = true;
		if (c.getX() < l.getGrille().length && c.getY() < l.getGrille()[0].length) {
			if(l.getGrille()[c.getX()][c.getY()].estTraversable()) {
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
		this.pos = c;
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
	
	public Coordonnee getPos() {
		return pos;
	}
	
	public void setPos(Coordonnee pos) {
		this.pos = pos;
	}
	
}
