package zeldiablo;

public class AleatoireFaux implements Aleatoire {

	@Override
	public int genererNombreAleatoire(int borneInf, int borneSup) {
		return borneInf;
	}

}
