package zeldiablo;

public class Potion extends Item{
	
	public Potion(Salle se,int xe,int ye) {
		super("potion",se,xe,ye);
		System.out.println("potion_"+xe+"/"+ye);
	}
	

}
