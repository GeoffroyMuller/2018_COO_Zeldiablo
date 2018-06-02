package zeldiablo;

public abstract class Case {
	public Case(){
		
	}
	
	public abstract boolean estTraversable();
	
	public abstract String getType();
	
	public String toString() {
		String s = this.getType();
		return s;
	}
}
