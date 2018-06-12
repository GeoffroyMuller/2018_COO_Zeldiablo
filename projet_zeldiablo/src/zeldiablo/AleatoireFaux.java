package zeldiablo;
/**
 * Creation de la classe AleatoireFaux
 */
public class AleatoireFaux implements Aleatoire {
	/**
	 * attribut entier qui contiendra un nombre 
	 */
	private int nbr;
	/**
	 * Constructeur de AleatoireFaux
	 * @param i, nombre a attribuer
	 */
	public AleatoireFaux(int i) {
		this.nbr = i;
	}
	/**
	 * methode qui permet de generer un nombre aleatoire
	 * @param borneInf, borne inferieure de l'encadrement de l'aleatoire
	 * @param borneSup, borne superieure de l'encadrement de l'aleatoire
	 */
	@Override
	public int genererNombreAleatoire(int borneInf, int borneSup) {
		return this.nbr;
	}

}
