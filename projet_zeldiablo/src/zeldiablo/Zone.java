package zeldiablo;

import java.io.Serializable;

public class Zone implements Serializable{
	private Case[][] grille;
	
	public static final int TAILLE_ZONE = (int)(Salle.TAILLE_SALLES-5)/2;
	
	private Case[][] grilleZone;
	private String nomZone;
	
	public Zone(String pNom) {
		nomZone=pNom;
		grilleZone = new Case[TAILLE_ZONE][TAILLE_ZONE];
		for (int i = 0; i < TAILLE_ZONE; i++) {
			for (int j = 0; j < TAILLE_ZONE; j++) {
				grilleZone[i][j]= new Vide();
			}
			
		}
	}
}
