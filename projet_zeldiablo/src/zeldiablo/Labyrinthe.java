package zeldiablo;

public class Labyrinthe {
	
	public static final int TAILLE_LAB=25;
	
	private Case[][] grille;
	
	public Labyrinthe(){
		grille = new Case[TAILLE_LAB][TAILLE_LAB];
		grille[0][(int)TAILLE_LAB/2] = new Entree();
		
		grille[TAILLE_LAB-1][TAILLE_LAB-1] = new Sortie();
		
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if(grille[i][j]==null){
					if(i==0 || i==TAILLE_LAB-1 || j==0 || j==TAILLE_LAB-1){
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


