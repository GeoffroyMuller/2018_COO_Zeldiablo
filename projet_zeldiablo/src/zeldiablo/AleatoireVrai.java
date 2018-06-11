package zeldiablo;

public class AleatoireVrai implements Aleatoire {

	@Override
	public int genererNombreAleatoire(int borneInf, int borneSup) {
		int rdm = (int)(Math.random() * ( borneSup - borneInf ))+borneInf;
		return rdm;
	}

}
