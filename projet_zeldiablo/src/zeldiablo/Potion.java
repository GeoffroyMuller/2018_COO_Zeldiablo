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
		this.motCle = "potion";
	}
	/**
	 * methode qui permet que l'aventurier puisse ressentir l'effet d'un item
	 */
	public void effetItem(Aventurier av) {
		if(av.getBaseVie()+av.getStat().getResistance()<(av.getVie()+50)) {
			av.setVie(av.getBaseVie()+av.getStat().getResistance());
		}else {
			av.setVie(av.getVie()+50);
		}
	}
	/**
	 * methode qui va chercher le mot cle de la texture 
	 */
	@Override
	public String getTextureMotCle() {
		return "potion";
	}



}
