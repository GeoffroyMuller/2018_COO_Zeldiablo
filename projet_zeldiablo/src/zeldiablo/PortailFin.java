package zeldiablo;

public class PortailFin extends Case{
	
	private Coordonnee coord;
	
	
	public PortailFin() {
		super();
		setEstTraversable(true);
	}
	@Override
	public String getType() {
		
		return "Portailfin";
	}
	
	public String getTextureMotCle() {
		return "portail_fin";
	}
	public Coordonnee getCoord() {
		return coord;
	}
	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}
}
