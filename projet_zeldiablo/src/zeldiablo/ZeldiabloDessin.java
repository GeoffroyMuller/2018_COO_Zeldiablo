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
 * @author Guezennec Lucas, Biancalana Théo, Geoffroy Muller et Masson Loic
 *
 */
public class ZeldiabloDessin implements DessinJeu {
	int vie = 100;

	private GestionnaireTexture  gt = new GestionnaireTexture();
	/**
	 * Le jeu Zeldiablo
	 * @see ZeldiabloDessin#ZeldiabloDessin(ZeldiabloJeu)
	 */
	private ZeldiabloJeu jeu;

	/**
	 * La taille d'un carré, 30*30pixel
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
		afficherBarreVieAventurier(g);
		afficherBarreXpAventurier(g);
		
		g.setColor(Color.GREEN);
		for(int i=0;i<this.jeu.getAv().getSalle().getItemPresent().size();i++) {
			Item it = this.jeu.getAv().getSalle().getItemPresent().get(i);
			g.drawImage(gt.attribuerTexture(it),this.jeu.getAv().getSalle().getItemPresent().get(i).getCoo().getX()*TAILLE, this.jeu.getAv().getSalle().getItemPresent().get(i).getCoo().getY()*TAILLE,TAILLE,TAILLE,null);
		}
		for(int i = 0; i < this.jeu.getAv().getSalle().getMonstrePresent().size();i++) {
			g.drawImage(this.jeu.getAv().getSalle().getMonstrePresent().get(i).getTexture(),this.jeu.getAv().getSalle().getMonstrePresent().get(i).getCoor().getX()*TAILLE, this.jeu.getAv().getSalle().getMonstrePresent().get(i).getCoor().getY()*TAILLE, TAILLE, TAILLE,null);
			afficherBarreVieMonstre(i, g);
		}

		
		g.drawImage(this.jeu.getAv().getTexture(), this.jeu.getAv().getCoor().getX()*TAILLE, this.jeu.getAv().getCoor().getY()*TAILLE,TAILLE,TAILLE,null);
		g.dispose();

	}
	
	public void afficherBarreVieMonstre(int i,Graphics2D g) {
		int xmonstre = this.jeu.getAv().getSalle().getMonstrePresent().get(i).getCoor().getX();
		int ymonstre = this.jeu.getAv().getSalle().getMonstrePresent().get(i).getCoor().getY();
		g.setColor(Color.red);
		g.fillRect(xmonstre*30, ymonstre*30, 30, 2);
		g.setColor(Color.green);
		g.fillRect(xmonstre*30, ymonstre*30, (int)(30*(((double)(this.jeu.getAv().getSalle().getMonstrePresent().get(i).getVie()))/((double)(this.vie+this.jeu.getAv().getSalle().getMonstrePresent().get(i).getStat().getForce())))), 2);
		g.setColor(Color.BLACK);
	}
	public void afficherBarreVieAventurier(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(0, Salle.TAILLE_SALLES*30, Salle.TAILLE_SALLES*30, 10);
		g.setColor(Color.green);
		g.fillRect(0, Salle.TAILLE_SALLES*30, (int)((Salle.TAILLE_SALLES*30)*((double)(this.jeu.getAv().getVie())/(double)(this.vie+this.jeu.getAv().getStat().getForce()))), 10);
		g.setColor(Color.green);
		g.drawString("Vie : "+this.jeu.getAv().getVie(), 10, 10);
		g.setColor(Color.BLACK);
	}
	public void afficherBarreXpAventurier(Graphics2D g) {
		g.setColor(Color.gray);
		g.fillRect(0, Salle.TAILLE_SALLES*30+10, Salle.TAILLE_SALLES*30, 10);
		g.setColor(Color.blue);
		g.fillRect(0, Salle.TAILLE_SALLES*30+10, (int)((Salle.TAILLE_SALLES*30)*((double)(this.jeu.getAv().getStat().getExp())/(double)(this.vie+this.jeu.getAv().getStat().getExpPourPasser()))), 10);
		g.setColor(Color.green);
		g.drawString("Exp : "+this.jeu.getAv().getStat().getExp(), 10, 20);
		g.setColor(Color.BLACK);
	}

}
