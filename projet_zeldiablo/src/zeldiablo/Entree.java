package zeldiablo;

public class Entree extends Case{
	private Salle sallePrecedente;
	
	public Entree(){
		super();
	}
	
	public Entree(Salle s) {
		super();
		sallePrecedente =s;
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
