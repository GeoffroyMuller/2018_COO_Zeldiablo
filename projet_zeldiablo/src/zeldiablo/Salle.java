package zeldiablo;

import java.io.Serializable;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Salle implements Serializable{
	
	private GestionnaireZone gz = new GestionnaireZone();
	
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
		
		for (int i = 0; i < 4; i++) {
			insererZone(i);
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
	
	public void insererZone(int i){
		Coordonnee startPos;
		switch(i){
		case 0 :
			startPos = new Coordonnee(2, 2);
			break;
			
		case 1 :
			startPos = new Coordonnee(Salle.TAILLE_SALLES-3-Zone.TAILLE_ZONE, 2);
			break;
			
		case 2 :
			startPos = new Coordonnee(Salle.TAILLE_SALLES-3-Zone.TAILLE_ZONE, Salle.TAILLE_SALLES-3-Zone.TAILLE_ZONE);
			break;
		case 3 :
			startPos = new Coordonnee(2, Salle.TAILLE_SALLES-3-Zone.TAILLE_ZONE);
		break;
			default :
				startPos = new Coordonnee(2, 2);
			break;
		
		}
		
		Zone z = gz.donnerUneZone();
		Case[][] tab_caseZone = z.getGrilleZone();
		
		int x = startPos.getX();
		int y = startPos.getY();
		
		
		for (int j = 0; j < Zone.TAILLE_ZONE; j++) {
			for (int j2 = 0; j2 < Zone.TAILLE_ZONE; j2++) {
				this.grille[x][y]=tab_caseZone[j2][j];//peut etre probleme car passage d'adresse
				x++;
			}
			y++;
		}
		
		
	}
}


