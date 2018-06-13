package zeldiablo;
/**
 * Creation de la classe PortailFin
 */
public class PortailFin extends Case{
	/**
	 * attribut Coordonnee qui contiendra la coordonnee du portail de fin 
	 */
	private Coordonnee coord;
	
	/**
	 * Constructeur de PortailFin
	 */
	public PortailFin() {
		super();
		setEstTraversable(true);
	}
	/**
	 * methode getter qui va chercher le type du portail
	 */
	@Override
	public String getType() {
		
		return "Portailfin";
	}
	/**
	 * methode getter qui va chercher le mot cle de la texture du portail
	 */
	public String getTextureMotCle() {
		return "portail_fin";
	}
	/**
	 * methode getter qui va chercher la coordonnee du portail
	 * @return la coordonnee du portail
	 */
	public Coordonnee getCoord() {
		return coord;
	}
	/**
	 * methode setter qui initialise la coordonnee du portail avec celle passee en parametre
	 * @param coord, coordonnee du portail
	 */
	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}
}
