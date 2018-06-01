
public class Entree extends Case{
	
	public Entree(){
		super();
	}
	@Override
	public boolean estTraversable() {
		return true;
	}

	@Override
	public String getType() {
		return "entree";
	}

}
