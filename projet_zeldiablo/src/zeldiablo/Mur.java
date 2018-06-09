package zeldiablo;

public class Mur extends Case{

	@Override
	public boolean estTraversable() {
		return false;
	}
	
	
	public Mur() {
		super();
		cheminTexture = "..\\texture\\wall_stone.png";
	}
	
	@Override
	public String getType() {
		return "mur";
	}




}
