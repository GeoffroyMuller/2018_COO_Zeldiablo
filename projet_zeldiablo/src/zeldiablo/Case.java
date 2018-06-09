package zeldiablo;

public abstract class Case {
	
	 String cheminTexture;


	public Case(){
		
	}
	
	public abstract boolean estTraversable();
	
	public abstract String getType();
	
	
	public String toString() {
		String s = this.getType();
		return s;
	}
	
	
	public String getCheminTexture() {
		return cheminTexture;
	}

	public void setCheminTexture(String cheminTexture) {
		this.cheminTexture = cheminTexture;
	}
}
