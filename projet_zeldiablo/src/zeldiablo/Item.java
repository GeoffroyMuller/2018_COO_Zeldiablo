package zeldiablo;

import java.awt.Graphics;

public abstract class Item {
	String type;
	Salle salle;
	Coordonnee coo;
	public Item(String rtype,Salle se,int xe,int ye) {
		// TODO Auto-generated constructor stub
		type = rtype;
		salle = se;
		coo = new Coordonnee(xe,ye);
	}
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
