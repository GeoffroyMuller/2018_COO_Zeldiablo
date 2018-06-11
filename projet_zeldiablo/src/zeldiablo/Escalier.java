package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class Escalier extends Case implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 454796313750726250L;

	/**
	 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
	 *
	 */

	private Salle salleEtageSup;

	/**
	 * Permet la création d'une case de type entrée
	 */
	public Escalier(){
		super();
		this.setEstTraversable(true);
		this.setTextureMotCle("portail_escalier");
	}





	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "escalier";
	}





	public Salle getSalleEtageSup() {
		return salleEtageSup;
	}





	public void setSalleEtageSup(Salle salleEtageSup) {
		this.salleEtageSup = salleEtageSup;
	}

}


