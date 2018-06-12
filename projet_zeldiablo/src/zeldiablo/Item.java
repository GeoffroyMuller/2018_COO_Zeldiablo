package zeldiablo;

import java.awt.Graphics;

public abstract class Item implements ObjetTexturer {
	String type;
	Salle salle;
	Coordonnee coo;
	String motCle;
	public Item(String rtype,Salle se,int xe,int ye) {
		// TODO Auto-generated constructor stub
		type = rtype;
		salle = se;
		coo = new Coordonnee(xe,ye);
	}
	public abstract void effetItem(Aventurier av);
	
	public String getType() {
		return type;
	}
	public Coordonnee getCoo() {
		return coo;
	}

	public Salle getSalle() {
		return salle;
	}


}
