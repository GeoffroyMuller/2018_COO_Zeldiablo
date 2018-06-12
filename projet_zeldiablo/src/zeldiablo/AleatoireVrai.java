package zeldiablo;
/**
 * Creation de la classe AleatoireVrai
 */
public class AleatoireVrai implements Aleatoire {
	/**
	 * methode qui permet de generer un nombre aleatoire
	 * @param borneInf, plus petit nombre ou l'on veut commencer l'aleatoire
	 * @param borneSup, plus grand nombre a ne pas depasser pour faire l'aleatoire
	 */
	@Override
	public int genererNombreAleatoire(int borneInf, int borneSup) {
		int rdm = (int)(Math.random() * ( borneSup - borneInf ))+borneInf;
		return rdm;
	}

}
