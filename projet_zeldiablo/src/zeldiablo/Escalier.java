package zeldiablo;

import java.io.Serializable;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class Escalier extends Case implements Serializable {

	/**
	 * @see zeldiablo.Case#estTraversable()
	 */
	@Override
	public boolean estTraversable() {
		return true;
	}

	/**
	 * @see zeldiablo.Case#getType()
	 */
	@Override
	public String getType() {
		return "escalier";
	}

}
