package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entree extends Case{
	private Salle sallePrecedente;
	
	public Entree(){
		super();
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Entree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Entree(Salle s) {
		super();
		sallePrecedente =s;
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Entree.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean estTraversable() {
		return true;
	}
	
	

	public Salle getSallePrecedente() {
		return sallePrecedente;
	}
	public void setSallePrecedente(Salle sallePrecedente) {
		this.sallePrecedente = sallePrecedente;
	}
	@Override
	public String getType() {
		return "entree";
	}

}
