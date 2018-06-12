package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MonstreFantome extends Monstre {

	public MonstreFantome(Coordonnee c, Salle s) {
		super(c, s);
		baseDegat=8;
		baseVie=40;
		majStat();
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\fantome.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
