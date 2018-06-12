package zeldiablo;
/**
 * Creatoin de l'interface Aleatoire
 */
public interface Aleatoire {
	/**
	 * methode qui permet de generer un nombre aleatoire
	 * @param borneInf, borne inferieure de l'encadrement de l'aleatoire
	 * @param borneSup, borne superieure de l'encadrement de l'aleatoire
	 * @return un nombre aleatoire
	 */
	public int genererNombreAleatoire(int borneInf, int borneSup);
}
