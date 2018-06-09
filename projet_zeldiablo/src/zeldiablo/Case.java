package zeldiablo;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Case {
	
	 protected Image texture;


	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

	public Case(){

	}
	
	public abstract boolean estTraversable();
	
	public abstract String getType();
	
	
	public String toString() {
		String s = this.getType();
		return s;
	}
	
	
}
