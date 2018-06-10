package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Coordonnee implements Serializable{
	/**
	 * x , coordonnée de l'axe des abscisses
	 * @see Coordonnee#decrementerX()
	 * @see Coordonnee#getX()
	 * @see Coordonnee#incrementerX()
	 * @see Coordonnee#Coordonnee(int, int)
	 */
	/**
	 * y , coordonnée de l'axe des ordonnées
	 * @see Coordonnee#decrementerY()
	 * @see Coordonnee#getY()
	 * @see Coordonnee#incrementerY()
	 * @see Coordonnee#Coordonnee(int, int)
	 */
	private int x,y;
	
	/**
	 * Permet la création d'une coordonnée
	 * @param cX
	 * 	La coordonnée X
	 * @param cY
	 * 	La coordonnée Y
	 * @see Coordonnee#x
	 * @see Coordonnee#y
	 */
	public Coordonnee(int cX, int cY) {
		this.x = cX;
		this.y = cY;
	}

	/**
	 * Permet de retourner X
	 * @return retourne la coordonnée X
	 * @see Coordonnee#x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Permet de définir X
	 * @param x
	 * 		La coordonnée X
	 * @see Coordonnee#x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Permet de retourner Y
	 * @return la coordonnée y
	 * @see Coordonnee#y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Permet de définir y
	 * @param y
	 * 		La coordonnée y
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
	 * Permet de décrémenter de 1 X
	 * @see Coordonnee#x
	 */
	public void decrementerX() {
		this.x-=1;
	}
	
	/**
	 * Permet de cécrémenter de 1 Y
	 * @see Coordonnee#y
	 */
	public void decrementerY() {
		this.y-=1;
	}

	/**
	 * Permet de dupliquer une coordonnée
	 * @param c
	 * 		La coordonnée à dupliquer
	 */
	public void dupliquerCoordonnee(Coordonnee c) {
		this.x = c.getX();
		this.y = c.getY();
	}
	
	public String toString() {
		return "Coord : "+this.getX()+" / "+this.getY();
	}
}
