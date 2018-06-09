package zeldiablo;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sortie extends Case{
	private Salle salleSuivante;
	
	public void setSalleSuivante(Salle salleSuivante) {
		this.salleSuivante = salleSuivante;
	}
	
	public Sortie() {
		super();
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Sortie.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Sortie(Salle s) {
		super();
		this.salleSuivante = s;
		try {
			this.texture = ImageIO.read(new File("..\\texture\\Portail_Sortie.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Salle getSalleSuivante() {
		return salleSuivante;
	}
	@Override
	public boolean estTraversable() {
		return true;
	}

	@Override
	public String getType() {
		return "sortie";
	}

}
