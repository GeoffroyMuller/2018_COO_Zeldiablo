
public class Labyrinthe {
	
	private Case[][] grille;
	
	public Labyrinthe(){
		grille = new Case[50][50];
		grille[0][24] = new Entree();
		
		grille[49][24] = new Entree();
	}
	

}
