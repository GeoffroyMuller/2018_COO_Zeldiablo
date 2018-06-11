package zeldiablo;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Salle implements Serializable{

	private GestionnaireZone gz;

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

	private ArrayList<Monstre> monstrePresent;
	/**
	 * Permet de retourner l'entrée d'une salle
	 * @return l'entrée de la salle
	 * @see Salle#entree
	 */
	public Entree getEntree() {
		return entree;
	}

	public ArrayList<Monstre> getMonstrePresent() {
		return monstrePresent;
	}

	public void setMonstrePresent(ArrayList<Monstre> monstrePresent) {
		this.monstrePresent = monstrePresent;
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
		 gz = new GestionnaireZone();
		this.monstrePresent = new ArrayList<Monstre>();
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
		for (int i = 0; i < 4; i++) {
			insererZone(i);
		}
		this.creeGrilleMonstre();
		this.apparitionMonstre();


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

	public void insererZone(int i){
		Coordonnee startPos;
		switch(i){
		case 0 :
			startPos = new Coordonnee(2, 2);
			break;

		case 1 :
			startPos = new Coordonnee((Salle.TAILLE_SALLES-2)-Zone.TAILLE_ZONE, 2);
			break;

		case 2 :
			startPos = new Coordonnee((Salle.TAILLE_SALLES-2)-Zone.TAILLE_ZONE, (Salle.TAILLE_SALLES-2)-Zone.TAILLE_ZONE);
			break;
		case 3 :
			startPos = new Coordonnee(2, (Salle.TAILLE_SALLES-2)-Zone.TAILLE_ZONE);
			break;
		default :
			startPos = new Coordonnee(2, 2);
			break;

		}

		Zone z = gz.donnerUneZone();
		Case[][] tab_caseZone = z.getGrilleZone();

		int x = startPos.getX();
		int y = startPos.getY();
		System.out.println(x);
		System.out.println(y);

		for (int j = 0; j < Zone.TAILLE_ZONE; j++) {
			for (int j2 = 0; j2 < Zone.TAILLE_ZONE; j2++) {
				System.out.println("x :"+x);
				System.out.println("y : "+y);
				System.out.println(" yzone :"+j);
				System.out.println(" xzone :"+j2);
				this.grille[x][y]=(Case)tab_caseZone[j2][j];//peut etre probleme car passage d'adresse
				x++;
			}
			x= (int)startPos.getX();
			y++;
		}


	}

	public String[][] getGrilleMonstreSpawn() {
		return grilleMonstreSpawn;
	}

	public void setGrilleMonstreSpawn(String[][] grilleMonstreSpawn) {
		this.grilleMonstreSpawn = grilleMonstreSpawn;
	}

	public void apparitionMonstre() {
		int random = 0;
		for(int i =0; i<grille.length;i++) {
			for(int j = 0; j<grille.length;j++) {
				if((this.isSpawnPossible(i, j)) && ((i != 0) && (j != 0)
						&& i!=Salle.TAILLE_SALLES &&  j!=Salle.TAILLE_SALLES)) {
					random =(int) (Math.random() * ( 100 - 0 ));

					if(random <=1) {
						Monstre m = new Monstre(new Coordonnee(i,j),this);
						this.grille[i][j].setEstTraversable(false);
						this.grille[i][j].setMonstrePresent(true);
						this.monstrePresent.add(m);
					}else {
						this.grille[i][j].setEstTraversable(true);
						this.grille[i][j].setMonstrePresent(false);

					}
				}
			}
		}
	}




	public boolean isSpawnPossible(int x, int y) {
		boolean res = true;
		if((this.grilleMonstreSpawn[x][y].contains("o"))
				|| ((!this.grille[x][y].estTraversable())||(this.grille[x][y].isMonstrePresent()))
				|| (x==0 && y==0) || (x==Salle.TAILLE_SALLES || y==Salle.TAILLE_SALLES) || this.grille[x][y].getType().contains("entree") || this.grille[x][y].getType().contains("sortie") ) {
			res = false;
		}
		return res;
	}
	
	
	//=====Spawn Item=====//
	
	public ArrayList<Coordonnee> placeLibreItems(){
		ArrayList<Coordonnee> tab_coo = new ArrayList<Coordonnee>();
		for(int i=0;i<grille[0].length;i++){
			for(int j=0;i<grille.length;j++){
				if(grille[i][j].estTraversable()){
					tab_coo.add(new Coordonnee(i, j));
				}
			}
		}
		return tab_coo;
	}
	
	/*public ArrayList<Coordonnee> placeAleatoirItems(){
		ArrayList<Coordonnee> tab_libre = placeLibreItems();
		int aleaItem = (int)Math.random() * (tab_libre.size() - 0);
		
		
	}*/
	



}


