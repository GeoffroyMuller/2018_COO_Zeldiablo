package zeldiablo;
/**
 * Creation de la classe Potion 
 */
public class PotionDev extends Item implements ObjetTexturer{
	/**
	 * Constructeur de Potion qui initilise les attributs avec les parametres
	 * donnes
	 * @param se, salle ou se situe la potion
	 * @param xe, coordonnee x de la potion
	 * @param ye, coordonnee y de la potion
	 */
	public PotionDev(Salle se,int xe,int ye) {
		super("potion",se,xe,ye);
		System.out.println("potion_"+xe+"/"+ye);
		this.motCle = "potion";
	}

	public void effetItem(Aventurier av) {
		av.setVie(10000);
	}

	@Override
	public String getTextureMotCle() {
		return "potion";
	}



}