package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Coordonnee implements Serializable{
	/**
	 * x , coordonn�e de l'axe des abscisses
	 * @see Coordonnee#decrementerX()
	 * @see Coordonnee#getX()
	 * @see Coordonnee#incrementerX()
	 * @see Coordonnee#Coordonnee(int, int)
	 */
	/**
	 * y , coordonn�e de l'axe des ordonn�es
	 * @see Coordonnee#decrementerY()
	 * @see Coordonnee#getY()
	 * @see Coordonnee#incrementerY()
	 * @see Coordonnee#Coordonnee(int, int)
	 */
	private int x,y;
	
	/**
	 * Permet la cr�ation d'une coordonn�e
	 * @param cX
	 * 	La coordonn�e X
	 * @param cY
	 * 	La coordonn�e Y
	 * @see Coordonnee#x
	 * @see Coordonnee#y
	 */
	public Coordonnee(int cX, int cY) {
		this.x = cX;
		this.y = cY;
	}

	/**
	 * Permet de retourner X
	 * @return retourne la coordonn�e X
	 * @see Coordonnee#x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Permet de d�finir X
	 * @param x
	 * 		La coordonn�e X
	 * @see Coordonnee#x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Permet de retourner Y
	 * @return la coordonn�e y
	 * @see Coordonnee#y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Permet de d�finir y
	 * @param y
	 * 		La coordonn�e y
	 * @see Coordonnee#y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Permet d'incrementer de 1 x
	 * @see Coordonnee#x
	 */
	public void incrementerX() {
		this.x+=1;
	}
	
	/**
	 * Permet d'incrementer de 1 y
	 * @see Coordonnee#y
	 */
	public void incrementerY() {
		this.y+=1;
	}
	
	/**
	 * Permet de d�cr�menter de 1 X
	 * @see Coordonnee#x
	 */
	public void decrementerX() {
		this.x-=1;
	}
	
	/**
	 * Permet de c�cr�menter de 1 Y
	 * @see Coordonnee#y
	 */
	public void decrementerY() {
		this.y-=1;
	}

	/**
	 * Permet de dupliquer une coordonn�e
	 * @param c
	 * 		La coordonn�e � dupliquer
	 */
	public void dupliquerCoordonnee(Coordonnee c) {
		this.x = c.getX();
		this.y = c.getY();
	}
	
	public String toString() {
		return "Coord : "+this.getX()+" / "+this.getY();
	}
}
