package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MonstreMort extends Monstre {

	public MonstreMort(Coordonnee c, Salle s) {
		super(c, s);
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\monstre_skelette_4.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDeplacementPossible(false);
		this.setDegats(0);
	}
	
	@Override
	public void setDeplacementPossible(boolean deplacementPossible) {
		super.setDeplacementPossible(false);
	}

}
