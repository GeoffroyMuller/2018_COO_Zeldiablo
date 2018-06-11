package zeldiablo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import moteur.DessinJeu;

/**
 * @author Guezennec Lucas, Biancalana Th�o, Geoffroy Muller et Masson Loic
 *
 */
public class ZeldiabloDessin implements DessinJeu {
	
	private GestionnaireTexture  gt = new GestionnaireTexture();
	/**
	 * Le jeu Zeldiablo
	 * @see ZeldiabloDessin#ZeldiabloDessin(ZeldiabloJeu)
	 */
	private ZeldiabloJeu jeu;
	
	/**
	 * La taille d'un carr�, 30*30pixel
	 */
	public static int TAILLE = 30;

	/**
	 * Constructeur de ZeldiabloDessin
	 * @param j
	 * 		Jeu Zeldiablo
	 * @see ZeldiabloDessin#jeu
	 */
	public ZeldiabloDessin(ZeldiabloJeu j) {
		this.jeu = j;
	}

	/**
	 * Permet l'affichage du jeu
	 * @param image
	 * 			BufferedImage
	 * @see moteur.DessinJeu#dessiner(java.awt.image.BufferedImage)
	 */
	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		Salle salle = this.jeu.getAv().getSalle();
		g.setColor(Color.BLACK);
		for(int i = 0; i<salle.TAILLE_SALLES;i++) {
			for(int j = 0; j<salle.TAILLE_SALLES;j++) {
					//System.out.print(salle.getGrille()[i][j]);
					g.drawImage(gt.attribuerTexture(salle.getGrille()[i][j]), i*TAILLE, j*TAILLE,null);
					//System.out.println(gt.attribuerTexture(salle.getGrille()[i][j]));
					
				}
				//System.out.println("");
			}
		//System.out.println("============================================");
		g.drawImage(this.jeu.getAv().getTexture(), this.jeu.getAv().getCoor().getX()*TAILLE, this.jeu.getAv().getCoor().getY()*TAILLE,TAILLE,TAILLE,null);
		g.setColor(Color.GREEN);
		for(int i = 0; i < this.jeu.getAv().getSalle().getMonstrePresent().size();i++) {
			
			
			
			g.drawImage(this.jeu.getAv().getSalle().getMonstrePresent().get(i).getTexture(),this.jeu.getAv().getSalle().getMonstrePresent().get(i).getCoor().getX()*TAILLE, this.jeu.getAv().getSalle().getMonstrePresent().get(i).getCoor().getY()*TAILLE, TAILLE, TAILLE,null);
		}
		g.dispose();

	}

}
