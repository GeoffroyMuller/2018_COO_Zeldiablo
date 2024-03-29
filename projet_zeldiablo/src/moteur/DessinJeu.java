package moteur;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * une interface representant la maniere de dessiner sur un JPanel
 * 
 * @author vthomas
 */
public interface DessinJeu {

	/**
	 * methode dessiner a completer. Elle construit une image correspondant au
	 * jeu. Jeu est un attribut de l'afficheur
	 * 
	 * @param image
	 *            image sur laquelle dessiner
	 * 
	 */
	public abstract void dessiner(BufferedImage image);

}
