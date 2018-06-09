package zeldiablo;

public class Sortie extends Case{
	private Salle salleSuivante;
	
	public void setSalleSuivante(Salle salleSuivante) {
		this.salleSuivante = salleSuivante;
	}
	
	public Sortie() {
		super();
		this.cheminTexture = "..\\texture\\Portail_Sortie.png";
	}
	public Sortie(Salle s) {
		super();
		this.salleSuivante = s;
		this.cheminTexture = "..\\texture\\Portail_Sortie.png";
	}
	
	public Salle getSalleSuivante() {
		return salleSuivante;
	}
	@Override
	public boolean estTraversable() {
		return true;
	}

	@Override
	public String getType() {
		return "sortie";
	}

}
