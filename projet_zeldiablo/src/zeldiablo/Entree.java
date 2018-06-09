package zeldiablo;

public class Entree extends Case{
	private Salle sallePrecedente;
	
	public Entree(){
		super();
		this.cheminTexture = "..\\texture\\Portail_Entree.png";
	}
	
	public Entree(Salle s) {
		super();
		sallePrecedente =s;
		this.cheminTexture = "..\\texture\\Portail_Entree.png";
	}
	@Override
	public boolean estTraversable() {
		return true;
	}
	
	

	public Salle getSallePrecedente() {
		return sallePrecedente;
	}
	public void setSallePrecedente(Salle sallePrecedente) {
		this.sallePrecedente = sallePrecedente;
	}
	@Override
	public String getType() {
		return "entree";
	}

}
