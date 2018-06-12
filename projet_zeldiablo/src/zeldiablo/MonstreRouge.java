package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MonstreRouge extends Monstre {

	public MonstreRouge(Coordonnee c, Salle s) {
		super(c, s);
		try {
			this.setTexture(ImageIO.read(new File("..\\texture\\monstre_rouge_2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDegats(10);
	}
	
	public void setDegats(int degats) {
		super.setDegats(degats);
	}

}
