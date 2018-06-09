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
		Salle salle = this.jeu.getAv().getSalle();
		g.setColor(Color.BLACK);
		for(int i = 0; i<salle.TAILLE_SALLES;i++) {
			for(int j = 0; j<salle.TAILLE_SALLES;j++) {
					g.drawImage(salle.getGrille()[i][j].getTexture(), i*TAILLE, j*TAILLE,null);
				}
			}
		g.drawImage(this.jeu.getAv().getTexture(), this.jeu.getAv().getCoor().getX()*TAILLE, this.jeu.getAv().getCoor().getY()*TAILLE,TAILLE,TAILLE,null);
		g.dispose();

	}

}
