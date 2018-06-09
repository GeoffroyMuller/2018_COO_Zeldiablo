package zeldiablo;

public class Labyrinthe {
	
	private Case[][] grille;
	
	public Labyrinthe(){
		grille = new Case[50][50];
		grille[0][24] = new Entree();
		
		grille[49][24] = new Sortie();
		
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if(grille[i][j]==null){
					if(i==0 || i==49 || j==0 || j==49){
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


