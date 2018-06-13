package principal;

import moteur.*;
import zeldiablo.*;
/**
 * Creation de la classe Principale qui lance le jeu
 *
 */
public class Principale {
	/**
	 * methode qui lance le jeu
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ZeldiabloJeu zJ = new ZeldiabloJeu();
		ZeldiabloDessin zD = new ZeldiabloDessin(zJ);
		
		MoteurGraphique moteur = new MoteurGraphique(zJ,zD);
		moteur.lancerJeu(750, 750+zD.TAILLE_BARRE*3);
	}

}
