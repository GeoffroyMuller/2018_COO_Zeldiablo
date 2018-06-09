package zeldiablo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import moteur.DessinJeu;

public class ZeldiabloDessin implements DessinJeu {
	private ZeldiabloJeu jeu;

	public static int TAILLE = 30;

	public ZeldiabloDessin(ZeldiabloJeu j) {
		this.jeu = j;
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();

		File aventurierTexture = new File("..\\texture\\Aventurier_Final.png");
		File wallStone = new File("..\\texture\\wall_stone.png");
		Image im=null;
		try {
			im = ImageIO.read(aventurierTexture);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(im, this.jeu.getAv().getCoor().getX()*TAILLE, this.jeu.getAv().getCoor().getY()*TAILLE,TAILLE,TAILLE,null);
		
		try {
			im = ImageIO.read(wallStone);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Salle salle = this.jeu.getAv().getSalle();
		g.setColor(Color.BLACK);
		for(int i = 0; i<salle.TAILLE_SALLES;i++) {
			for(int j = 0; j<salle.TAILLE_SALLES;j++) {
				if(salle.getGrille()[i][j].getType().contains("mur")) {

					g.drawImage(im, i*30, j*30,null);
				}
			}
		}
		g.dispose();

	}

}
