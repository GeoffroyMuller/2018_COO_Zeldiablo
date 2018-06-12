package zeldiablo;
/**
 * Creation de la classe Potion 
 */
public class Potion extends Item implements ObjetTexturer{
	/**
	 * Constructeur de Potion qui initilise les attributs avec les parametres
	 * donnes
	 * @param se, salle ou se situe la potion
	 * @param xe, coordonnee x de la potion
	 * @param ye, coordonnee y de la potion
	 */
	public Potion(Salle se,int xe,int ye) {
		super("potion",se,xe,ye);
		System.out.println("potion_"+xe+"/"+ye);
		this.motCle = "potion";
	}

	public void effetItem(Aventurier av) {
		if(100+av.getStat().getResistance()<(av.getVie()+50)) {
			av.setVie(100+av.getStat().getResistance());
		}else {
			av.setVie(av.getVie()+50);
		}
	}

	@Override
	public String getTextureMotCle() {
		return "potion";
	}



}
