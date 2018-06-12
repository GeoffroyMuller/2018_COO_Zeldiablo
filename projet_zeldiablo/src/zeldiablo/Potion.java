package zeldiablo;
/**
 * Creation de la classe Potion 
 */
public class Potion extends Item{
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
	}
	

}
