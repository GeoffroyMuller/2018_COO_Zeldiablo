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
	public static int TAILLE = 40;
	
	public ZeldiabloDessin(ZeldiabloJeu j) {
		this.jeu = j;
	}
	
	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		
		File aventurier = new File("..\\texture\\Aventurier_Final.png");
		Image im=null;
		try {
			im = ImageIO.read(aventurier);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(im, this.jeu.getAv().getCoor().getX()*30, this.jeu.getAv().getCoor().getY()*30,30,30,null);
		
		Labyrinthe lab = this.jeu.getListLab().get(0);
		g.setColor(Color.BLACK);
		for(int i = 0; i<lab.getGrille().length;i++) {
			for(int j = 0; j<lab.getGrille()[0].length;j++) {
				if(lab.getGrille()[i][j].getType().contains("mur")) {
					g.fillRect(i*30, j*30, 30, 30);
				}
			}
		}
		g.dispose();
		
	}

}
