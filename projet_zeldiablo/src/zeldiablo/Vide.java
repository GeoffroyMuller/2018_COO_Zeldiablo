package zeldiablo;

public class Vide extends Case{

	@Override
	public boolean estTraversable() {
		return true;
	}
	
	public Vide(){
		this.cheminTexture = "..\\texture\\wood.png";
	}

	@Override
	public String getType() {
		return "vide";
	}
	
}
