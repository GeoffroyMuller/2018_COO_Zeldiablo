package zeldiablo;

public class Aventurier {
	private int vie;
	private boolean mort;
	private Case pos; // case sur laquelle se trouve l'aventurier
	
	public Aventurier(){
		vie = 100;
		mort = false;
	}
	public Aventurier(Case c){
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
	
	public boolean deplacerAventurier(Aventurier a, Case c) {
		boolean res = false;
		c.estTraversable();
		c.getType();
		if (c.estTraversable() == true && c.getType() == "vide") {
			res = true;
		}
		else {
			res = false;
		}
		return res;
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
}
