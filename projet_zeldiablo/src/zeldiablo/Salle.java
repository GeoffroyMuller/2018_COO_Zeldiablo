package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Salle implements Serializable{
	
	
	/**
	 * Taille d'une salle
	 */
	public static final int TAILLE_SALLES=25;
	/**
	 * Entree de la salle
	 * @see Salle#getEntree()
	 * @see Salle#setEntree(Entree)
	 */
	private Entree entree;
	/**
	 * Sortie de la salle
	 * @see Salle#getSortie()
	 * @see Salle#setSortie(Sortie)
	 */
	private Sortie Sortie;
	
	/**
	 * Les cases de la salle
	 * @see Salle#getGrille()
	 * @see Salle#setGrille(Case[][])
	 */
	private Case[][] grille;
	/**
	 * Les cases où les monstres peuvent apparaitre
	 */
	private String[][] grilleMonstreSpawn;
	/**
	 * Permet de retourner l'entrée d'une salle
	 * @return l'entrée de la salle
	 * @see Salle#entree
	 */
	public Entree getEntree() {
		return entree;
	}

	/**
	 * Permet de définir l'entrée d'une salle
	 * @param entree
	 * 		L'entrée de la salle
	 * @see Salle#entree
	 */
	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	/**
	 * Permet de retourner la sortie d'une salle
	 * @return la sortie de la salle
	 * @see Salle#Sortie
	 */
	public Sortie getSortie() {
		return Sortie;
	}

	/**
	 * Permet de définir la sortie de la salle
	 * @param sortie
	 * 		La sortie de la salle
	 * @see Salle#Sortie
	 */
	public void setSortie(Sortie sortie) {
		Sortie = sortie;
	}


	
	/**
	 * Constructeur permettant la création d'une salle
	 */
	public Salle(){
		grille = new Case[TAILLE_SALLES][TAILLE_SALLES];
		this.grilleMonstreSpawn = new String[TAILLE_SALLES][TAILLE_SALLES];
		
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
		
		this.creeGrilleMonstre();
		
	}
	
	public void creeGrilleMonstre() {
		for(int i =0; i < grille.length;i++) {
			for(int j = 0; j < grille[0].length;j++) {
				if( (i>1 && i!=Zone.TAILLE_ZONE+2) && (i!=(Zone.TAILLE_ZONE*2)+3) && (j!=Zone.TAILLE_ZONE+2) && (j>1) && (j!=(Zone.TAILLE_ZONE*2)+3)
						&& (j!=(Zone.TAILLE_ZONE*2)+4)) {
					this.grilleMonstreSpawn[i][j]="x";
					
				}else {
					this.grilleMonstreSpawn[i][j]="o";
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

	/**
	 * Permet de retourner la grille de case de la salle
	 * @return la grille de case de la salle
	 * @see Salle#grille
	 */
	public Case[][] getGrille() {
		return grille;
	}
	
	/**
	 * Permet 
	 * @return
	 */
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

	/**
	 * Permet de définir la grille de case
	 * @param grille
	 * 		La grille de case
	 * @see Salle#grille
	 */
	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}
	
	
	public String[][] getGrilleMonstreSpawn() {
		return grilleMonstreSpawn;
	}

	public void setGrilleMonstreSpawn(String[][] grilleMonstreSpawn) {
		this.grilleMonstreSpawn = grilleMonstreSpawn;
	}
	
	public String toString2() {
		String res ="";
		for(int i = 0; i< this.grilleMonstreSpawn.length;i++) {
			for(int j=0; j < this.grilleMonstreSpawn[0].length;j++) {
				res+=this.grilleMonstreSpawn[i][j];
			}
			res+="\n";
		}
		
		return res;
	}


}


