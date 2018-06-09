package zeldiablo;

import java.io.Serializable;

public class Salle implements Serializable{
	
	public static final int TAILLE_SALLES=25;
	private Entree entree;
	private Sortie Sortie;
	
	private Case[][] grille;
	
	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public Sortie getSortie() {
		return Sortie;
	}

	public void setSortie(Sortie sortie) {
		Sortie = sortie;
	}


	
	public Salle(){
		grille = new Case[TAILLE_SALLES][TAILLE_SALLES];
		
		
		Coordonnee ce = placerSurMurAlea();
		grille[ce.getX()][ce.getY()] = new Entree();
		this.entree=(Entree)grille[ce.getX()][ce.getY()];
		
		
		Coordonnee cs = placerSurMurAlea();
		while(cs.getX()==ce.getX() && cs.getY()==ce.getY()) {
			cs = placerSurMurAlea();
		}
		grille[cs.getX()][cs.getY()] = new Sortie();
		this.Sortie = (Sortie)grille[cs.getX()][cs.getY()] ;
		
		
		
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if(grille[i][j]==null){
					if(i==0 || i==TAILLE_SALLES-1 || j==0 || j==TAILLE_SALLES-1){
						grille[i][j]=new Mur();
					}
					else {
						grille[i][j]=new Vide();
					}
				}
			}
			
		}
	}
	
	public String toString(){
		String res="";
		for (int i = 0; i < grille.length; i++) {
			res+="\n";
			for (int j = 0; j < grille.length; j++) {
				res += " | "+i+":"+j+" "+grille[i][j]+" | ";
			}
		}
		return res;
	}

	public Case[][] getGrille() {
		return grille;
	}
	
	public Coordonnee placerSurMurAlea() {
		Coordonnee c = new Coordonnee(0, 0);
		int des = (int)(Math.random()*4+1);
		switch (des) {
		case 1:
			c.setY(0);
			c.setX(((int)(Math.random()*(Salle.TAILLE_SALLES-2)+1)));
		break;
		
		case 2:
			
			c.setY(Salle.TAILLE_SALLES-1);
			c.setX(((int)(Math.random()*(Salle.TAILLE_SALLES-2)+1)));
		break;
		
		case 3:
			
			c.setX(0);
			c.setY(((int)(Math.random()*(Salle.TAILLE_SALLES-2)+1)));
		break;
		
		case 4:
			c.setX(Salle.TAILLE_SALLES-1);
			c.setY(((int)(Math.random()*(Salle.TAILLE_SALLES-2)+1)));
		break;
		
		
		default:
			System.out.println("erreur sur le random de 4");
			break;
		}
		
		System.out.println("coordonné generer alea  : "+c);
		return c;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

}


