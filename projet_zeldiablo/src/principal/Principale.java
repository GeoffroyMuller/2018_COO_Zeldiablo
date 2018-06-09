package principal;

import moteur.*;
import zeldiablo.*;

public class Principale {

	public static void main(String[] args) throws InterruptedException {
		ZeldiabloJeu zJ = new ZeldiabloJeu();
		ZeldiabloDessin zD = new ZeldiabloDessin(zJ);
		
		MoteurGraphique moteur = new MoteurGraphique(zJ,zD);
		moteur.lancerJeu(750, 750);

	}

}
