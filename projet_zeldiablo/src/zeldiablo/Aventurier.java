package zeldiablo;

public class Aventurier {
	private int vie;
	private boolean mort;
	private Coordonnee coor; //coordonnee de l'aventurier
	private Salle salle;
	private Etage etage;

	public Aventurier(){
		vie = 100;
		mort = false;
	}

	public Aventurier(Coordonnee c, Salle l, Etage e){
		vie = 100;
		mort = false;
		coor = c;
		salle = l;
		this.etage = e;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public void setEtage(Etage etage) {
		this.etage = etage;
	}

	public Salle getSalle() {
		return salle;
	}

	public Etage getEtage() {
		return etage;
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

		if ((c.getX() < salle.getGrille().length && c.getX() >= 0) &&
				(c.getY() < salle.getGrille()[0].length && c.getY() >= 0)) {
			if(salle.getGrille()[c.getX()][c.getY()].estTraversable()) {
				this.changerCoord(c);
				
				if(salle.getGrille()[coor.getX()][coor.getY()]==salle.getEntree()) {
					this.salle=salle.getEntree().getSallePrecedente();
					changementSalle(this.salle,salle.getSortie());
					System.out.println("entree");
				}
				else {
					if(salle.getGrille()[coor.getX()][coor.getY()]==salle.getSortie()) {
						this.salle=salle.getSortie().getSalleSuivante();
						changementSalle(this.salle, salle.getEntree());
						System.out.println("sortie");
					}
				}

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
		return (this.salle.getGrille()[this.coor.getX()][this.coor.getY()]);
	}

	public void changementSalle(Salle s, Case c) {
		Case [][] grille = s.getGrille();
		int x=12,y=12;

		for (int i = 0; i < salle.TAILLE_SALLES; i++) {
			for (int j = 0; j < salle.TAILLE_SALLES; j++) {
				if(grille[i][j]==c) {
					x=i;
					y=j;
				}
			}
		}
		System.out.println("changement salle");
		Coordonnee co = new Coordonnee(x, y);
		System.out.println("x : "+x+" y : "+y);
		co.decrementerX();
		System.out.println(co);
		if(deplacerAventurier(co)) {
			System.out.println("1");

		}
		else {
			co.incrementerY();
			co.incrementerX();
			System.out.println(co);
			if(deplacerAventurier(co)) {
				System.out.println("2");
			}
			else {
				co.decrementerY();
				co.incrementerX();
				System.out.println(co);
				if(deplacerAventurier(co)) {
					System.out.println("3");
				}
				else {
					co.decrementerX();
					co.decrementerY();
					System.out.println(co);
					if(deplacerAventurier(co)) {
						System.out.println("4");
					}
					else {
						System.out.println("erreur de deplacement");
					}
					

				}
			}
		}

	}




}
