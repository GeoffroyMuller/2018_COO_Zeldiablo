package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Vide extends Case{

	@Override
	public boolean estTraversable() {
		return true;
	}
	
	public Vide(){
		try {
			this.texture = ImageIO.read(new File("..\\texture\\wood.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getType() {
		return "vide";
	}
	
}
