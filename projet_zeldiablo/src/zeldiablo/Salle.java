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

	private Escalier escalier;

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

	public void setEscalier(Escalier escalier) {
		this.escalier = escalier;
	}

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

	private ArrayList<Item> itemPresent;
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
		itemPresent = new ArrayList<Item>();
		gz = new GestionnaireZone();
		this.monstrePresent = new ArrayList<Monstre>();
		grille = new Case[TAILLE_SALLES][TAILLE_SALLES];
		this.grilleMonstreSpawn = new String[TAILLE_SALLES][TAILLE_SALLES];
		AleatoireVrai randomV= new AleatoireVrai();
		Coordonnee ce = placerSurMurAlea(randomV);

		grille[ce.getX()][ce.getY()] = new Entree(new Coordonnee(ce.getX(),ce.getY()));

		this.entree=(Entree)grille[ce.getX()][ce.getY()];


		Coordonnee cs = placerSurMurAlea(randomV);
		while(cs.getX()==ce.getX() && cs.getY()==ce.getY()) {
			cs = placerSurMurAlea(randomV);
		}
		grille[cs.getX()][cs.getY()] = new Sortie(new Coordonnee(ce.getX(),ce.getY()));
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
		this.apparitionMonstre(randomV);
		placeAleatoirItem(randomV);

	}
	//Constructeur pour test
	public Salle(int o) {
		this.monstrePresent = new ArrayList<Monstre>();
		grille = new Case[TAILLE_SALLES][TAILLE_SALLES];
		this.grilleMonstreSpawn = new String[TAILLE_SALLES][TAILLE_SALLES];
		AleatoireVrai randomV= new AleatoireVrai();
		Coordonnee cs = placerSurMurAlea(randomV);

		grille[cs.getX()][cs.getY()] = new Sortie(new Coordonnee(cs.getX(),cs.getY()));
		this.Sortie = (Sortie)grille[cs.getX()][cs.getY()] ;


		if(o==9) {
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[0].length; j++) {
					if(grille[i][j]==null){
						if(i!=12 && j!=12) {
							grille[i][j]=new Mur();
						}else {
							grille[i][j]=new Vide();
						}

					}

				}
			}

		}else {
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[0].length; j++) {
					if(grille[i][j]==null){
						grille[i][j]=new Vide();
					}
				}

			}
		}

		this.creeGrilleMonstre();
		if(o!=5) {
			this.apparitionMonstre(randomV);
		}

	}

	public Escalier getEscalier() {
		return escalier;
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
	public Coordonnee placerSurMurAlea(Aleatoire random) {
		Coordonnee c = new Coordonnee(0, 0);
		int des = random.genererNombreAleatoire(1, 4);
		switch (des) {
		case 1:
			c.setY(0);
			c.setX(random.genererNombreAleatoire(1, Salle.TAILLE_SALLES-2));
			break;

		case 2:

			c.setY(Salle.TAILLE_SALLES-1);
			c.setX(random.genererNombreAleatoire(1, Salle.TAILLE_SALLES-2));
			break;

		case 3:

			c.setX(0);
			c.setY(random.genererNombreAleatoire(1, Salle.TAILLE_SALLES-2));
			break;

		case 4:
			c.setX(Salle.TAILLE_SALLES-1);
			c.setY(random.genererNombreAleatoire(1, Salle.TAILLE_SALLES-2));
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
		if(gz.getLz().size()>0){

			Aleatoire random = new AleatoireVrai();
			Zone z = gz.donnerUneZone(random);
			Case[][] tab_caseZone = z.getGrilleZone();

			int x = startPos.getX();
			int y = startPos.getY();
			System.out.println(x);
			System.out.println(y);

			for (int j = 0; j < Zone.TAILLE_ZONE; j++) {
				for (int j2 = 0; j2 < Zone.TAILLE_ZONE; j2++) {
					//System.out.println("x :"+x);
					//System.out.println("y : "+y);
					//System.out.println(" yzone :"+j);
					//System.out.println(" xzone :"+j2);
					this.grille[x][y]=(Case)tab_caseZone[j2][j];//peut etre probleme car passage d'adresse
					x++;
				}
				x= (int)startPos.getX();
				y++;
			}

		}


	}

	public String[][] getGrilleMonstreSpawn() {
		return grilleMonstreSpawn;
	}

	public void setGrilleMonstreSpawn(String[][] grilleMonstreSpawn) {
		this.grilleMonstreSpawn = grilleMonstreSpawn;
	}

	public void apparitionMonstre(Aleatoire alea) {
		int random = 0;
		for(int i =0; i<grille.length;i++) {
			for(int j = 0; j<grille.length;j++) {
				if((this.isSpawnPossible(i, j)) && ((i != 0) && (j != 0)
						&& i!=Salle.TAILLE_SALLES &&  j!=Salle.TAILLE_SALLES)) {
					random = alea.genererNombreAleatoire(0, 100);



					if(random <=6) {
						random = alea.genererNombreAleatoire(0, 100);
						if(random>=50) {
							MonstreRouge m = new MonstreRouge(new Coordonnee(i,j),this);
							this.grille[i][j].setEstTraversable(false);
							this.grille[i][j].setMonstrePresent(true);
							this.monstrePresent.add(m);
						}else {

							Monstre m = new Monstre(new Coordonnee(i,j),this);
							this.grille[i][j].setEstTraversable(false);
							this.grille[i][j].setMonstrePresent(true);
							this.monstrePresent.add(m);
						}

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
				|| (x==0 && y==0) || (x==Salle.TAILLE_SALLES || y==Salle.TAILLE_SALLES) || this.grille[x][y].getType().contains("entree") || this.grille[x][y].getType().contains("sortie") || this.grille[x][y].getType().contains("escalier")) {

			res = false;
		}
		return res;
	}

	public boolean isDeplacementPossible(int x, int y) {
		boolean res = true;
		if(((!this.grille[x][y].estTraversable()) || this.grille[x][y].getType().contains("entree") || this.grille[x][y].getType().contains("sortie"))) {
			res = false;
		}
		return res;
	}


	//=====Spawn Item=====//

	public ArrayList<Coordonnee> placeLibreItems(){
		ArrayList<Coordonnee> tab_coo = new ArrayList<Coordonnee>();
		for(int i=0;i<grille.length;i++){
			for(int j=0;j<grille[0].length;j++){
				if(grille[i][j].estTraversable()){
					tab_coo.add(new Coordonnee(i, j));
				}
			}
		}

		return tab_coo;
	}

	public void placeAleatoirItem(Aleatoire aleaItem) {
		ArrayList<Coordonnee> tab_libre = placeLibreItems();
		int nbalea = 0;
		int xitem = 0;
		int yitem = 0;
		for(int i=0;i<tab_libre.size();i++) {
			nbalea = aleaItem.genererNombreAleatoire(0, 100);
			if(nbalea>=99) {
				xitem = tab_libre.get(i).getX();
				yitem = tab_libre.get(i).getY();
				itemPresent.add(new Potion(this,xitem,yitem));
			}
		}
	}

	public boolean prendreItem(Aventurier av){
		for(int i=0;i<itemPresent.size();i++) {
			if(av.getCoor().getX()==itemPresent.get(i).getCoo().getX()) {
				if(av.getCoor().getY()==itemPresent.get(i).getCoo().getY()) {
					itemPresent.get(i).effetItem(av);
					itemPresent.remove(i);
					System.out.println("item_pris");
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<Item> getItemPresent() {
		return itemPresent;
	}


	public void detecterCombat(Aventurier a) {
		Monstre monstre = new Monstre(null,null);
		for(int i = 0;i < this.monstrePresent.size();i++) {
			monstre = this.monstrePresent.get(i);
			if((monstre.getCoor().getX()+1 == a.getCoor().getX() && monstre.getCoor().getY() == a.getCoor().getY()) ||
					(monstre.getCoor().getX()-1 == a.getCoor().getX() && monstre.getCoor().getY() == a.getCoor().getY()) || 
					(monstre.getCoor().getX() == a.getCoor().getX() && monstre.getCoor().getY()+1 == a.getCoor().getY()) || 
					(monstre.getCoor().getX() == a.getCoor().getX() && monstre.getCoor().getY()-1 == a.getCoor().getY())) {
				a.subirDegats(monstre.getDegats());
				monstre.setDeplacementPossible(false);
				System.out.println(a.getVie()+"");
			}else {
				monstre.setDeplacementPossible(true);
			}
		}
	}

	public boolean detecterLesMorts() {
		boolean res = false;
		for(int i = 0; i < this.getMonstrePresent().size(); i++) {
			if(this.getMonstrePresent().get(i).isMort() && this.getMonstrePresent().get(i).isLootable()) {
				MonstreMort mM = new MonstreMort(new Coordonnee(this.getMonstrePresent().get(i).getCoor().getX(),this.getMonstrePresent().get(i).getCoor().getY()),this);
				this.getMonstrePresent().remove(this.getMonstrePresent().indexOf(this.getMonstrePresent().get(i)));
				this.getMonstrePresent().add(mM);
				this.getGrille()[mM.getCoor().getX()][mM.getCoor().getY()].setEstTraversable(true);
				res = true;
			}
		}
		return res;
	}

}


