package zeldiablo;

public class AleatoireFaux implements Aleatoire {
	private int nbr;
	public AleatoireFaux(int i) {
		this.nbr = i;
	}

	@Override
	public int genererNombreAleatoire(int borneInf, int borneSup) {
		return this.nbr;
	}

}
