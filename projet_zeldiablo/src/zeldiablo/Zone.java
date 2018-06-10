package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Zone implements Serializable{
	/**
	 * Taille d'une zone
	 */
	public static final int TAILLE_ZONE = (int)(Salle.TAILLE_SALLES-5)/2;
	
	/**
	 * Ensemble de case formant la zone
	 */
	private Case[][] grilleZone;
	/**
	 * Nom de la zone
	 */
	private String nomZone;
	
	/**
	 * Constructeur permettant la création de la zone
	 * @param pNom
	 * 	nom de la zone
	 */
	public Zone(String pnom) {
		nomZone=pnom;
		grilleZone = new Case[TAILLE_ZONE][TAILLE_ZONE];
		for (int i = 0; i < TAILLE_ZONE; i++) {
			for (int j = 0; j < TAILLE_ZONE; j++) {
				grilleZone[i][j]= new Vide();
			}
			
		}
	}

	/**
	 * Permet de retourner l'ensemble de case de la zone
	 * @return l'ensemble de case de la zone
	 */
	public Case[][] getGrilleZone() {
		return grilleZone;
	}

	/**
	 * Permet de définir l'ensemble de case de la zone
	 * @param grilleZone
	 * 	L'ensemble de case de la zone
	 */
	public void setGrilleZone(Case[][] grilleZone) {
		this.grilleZone = grilleZone;
	}
	
}
