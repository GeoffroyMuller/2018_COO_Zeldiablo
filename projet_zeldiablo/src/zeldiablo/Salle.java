package zeldiablo;

import java.io.Serializable;

public class Salle implements Serializable{
	
	public static final int TAILLE_SALLES=25;
	
	private Case[][] grille;
	
	public Salle(){
		grille = new Case[TAILLE_SALLES][TAILLE_SALLES];
		grille[0][(int)TAILLE_SALLES/2] = new Entree();
		
		grille[TAILLE_SALLES-1][(int)TAILLE_SALLES/2] = new Sortie();
		
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
	

}

