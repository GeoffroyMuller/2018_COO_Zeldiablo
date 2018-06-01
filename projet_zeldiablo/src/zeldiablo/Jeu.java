package zeldiablo;

import java.util.ArrayList;


public class Jeu {
	private Aventurier av;
	private ArrayList<Labyrinthe> listLab;
	public Jeu() {
		av = new Aventurier();
		for (int i = 0; i < 10; i++) {
			listLab.add(new Labyrinthe());
		}
	}
	

}
