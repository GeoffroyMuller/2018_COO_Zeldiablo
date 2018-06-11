package zeldiablo;

public abstract class Item {
	String type;
	Salle salle;
	Coordonnee coo;
	public Item(String rtype,Salle se,int xe,int ye) {
		// TODO Auto-generated constructor stub
		type = rtype;
		salle = se;
		coo.setX(xe);
		coo.setY(ye);
	}
	public String getType() {
		return type;
	}
	public Coordonnee getCoo() {
		return coo;
	}
	
	

}
