package zeldiablo;
/**
 * Creation de la classe Stats
 */
public class Stats{
	/**
	 * attribut entier qui contiendra la force du personnage
	 */
	private int force;
	/**
	 * attribut entier qui contiendra la resistance du personnage 
	 */
	private int resistance;
	/**
	 * attribut entier qui contiendra l'experience du personnage
	 */
	private int exp;
	/**
	 * attribut entier qui contiendra l'experience qu'il faut pour passer au niveau suivant
	 */
	private int expPourPasser;
	/**
	 * attribut entier qui contiendra le niveau du personnage
	 */
	private int niveau;
	/**
	 * methode getter qui va chercher la force du personnage
	 * @return la force du personnage
	 */
	public int getForce() {
		return force;
	}

	/**
	 * methode getter qui va chercher la resistance du personnage
	 * @return la resistance du personnage
	 */
	public int getResistance() {
		return resistance;
	}

	/**
	 * Constructeur de Stats
	 * @param niv, niveau du personnage
	 */
	public Stats(int niv) {

		niveau=0;
		
		force=0;
		resistance=0;
		exp=0;
		expPourPasser = 1000;
		for (int i = 0; i < niv; i++) {
			changementNiveau();
		}
		
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * methode qui permet d'ajouter de l'experience a un personnage
	 * @param aj, experience a ajouter
	 */
	public void ajoutExp(int aj) {
		exp+=aj;
		if(exp>=expPourPasser) {
			changementNiveau();
		}
	}
	/**
	 * methode qui permet de changer de niveau pour un personnage
	 */
	public void changementNiveau() {
		exp=0;
		niveau++;
		force+=10*niveau;
		resistance+=10*niveau;
		expPourPasser+=1000*niveau;
		//System.out.println("changement niveau ");
	}
	/**
	 * methode qui permet de modifier le niveau d'un personnage
	 * @param niv, niveau du personnage
	 */
	public void modifierNiveau(int niv){
		for (int i = 0; i < niv; i++) {
			changementNiveau();
		}
	}

	/**
	 * methode getter qui va chercher l'experience d'un personnage
	 * @return l'experience d'un personnage
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * methode getter qui va chercher l'experience pour passer au niveau suivant
	 * @return l'experience pour passer au niveau suivant
	 */
	public int getExpPourPasser() {
		return expPourPasser;
	}

	/**
	 * methode getter qui va chercher le niveau d'un personnage
	 * @return le niveau d'un personnage
	 */
	public int getNiveau() {
		return niveau;
	}
}
