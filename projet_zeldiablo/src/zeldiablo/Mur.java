package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mur extends Case{

	@Override
	public boolean estTraversable() {
		return false;
	}
	
	
	public Mur() {
		super();
		try {
			this.texture = ImageIO.read(new File("..\\texture\\wall_stone.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getType() {
		return "mur";
	}




}
