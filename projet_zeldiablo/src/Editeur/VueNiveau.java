package Editeur;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import zeldiablo.Case;
import zeldiablo.Coordonnee;
import zeldiablo.ZeldiabloDessin;

public class VueNiveau  extends JPanel implements Observer{

	private static final int MARGE_TAILLECASE_X = 10;
	private static final int MARGE_TAILLECASE_Y = 10;

	public static final int ADD_ML = 100;
	public static final int ADD_MML = 101;
	public static final int ADD_ML_MML = 102;

	public static final int SUP_ALL = 202;

	private int x=0;
	private int y=0;
	private int taillecase=ZeldiabloDessin.TAILLE;
	private ControleurCase cc;

	private Niveau niv;
	private ArrayList<Rectangle> tab_rec; //tableau de rectangle correnspondant a des cases

	public VueNiveau(Niveau nive) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(180,180,180));

		tab_rec = new ArrayList<Rectangle>();

		niv = nive;
		niv.addObserver(this);

		cc = new ControleurCase(this,niv);

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		x=MARGE_TAILLECASE_X;
		y=MARGE_TAILLECASE_Y;
		g.setColor(Color.black);
		if(niv.getTab_case()!=null) {
			g.setColor(Color.BLACK);
			for(int i=0;i<niv.getTaille();i++) {
				for(int j=0;j<niv.getTaille();j++) {
					ajouterRectangle(x, y);
					g.setColor(Color.white);
					if(niv.getTypeCase(j, i)=="mur") {
						g.setColor(Color.BLACK);
					}
					if(niv.getTypeCase(j, i)=="entree") {
						g.setColor(Color.MAGENTA);
					}
					if(niv.getTypeCase(j, i)=="sortie") {
						g.setColor(Color.BLUE);
					}
					if(niv.getTypeCase(j, i)=="vide") {
						g.setColor(Color.GRAY);
					}


					g.fillRect(x, y, taillecase, taillecase);
					x+=taillecase+2;
				}
				y+=taillecase+2;
				x=MARGE_TAILLECASE_X;
			}
		}
	}
	public void ajouterRectangle(int xe,int ye) {
		if(((niv.getTaille())*(niv.getTaille()))>tab_rec.size()) {
			tab_rec.add(new Rectangle(xe, ye, taillecase, taillecase));
		}
	}

	public Coordonnee estDedans(int xe,int ye) {
		if(tab_rec.size()==((niv.getTaille())*(niv.getTaille()))) {
			for(int i=0;i<tab_rec.size();i++) {
				if(tab_rec.get(i).contains(xe, ye)) {
					System.out.println("estDedand retourn Rectangle num:"+i);
					int x,y;
					int div =10;
					if(tab_rec.size()==625) {
						div=25;

					}
					x = i%div;
					y = (int)i/div;

					Coordonnee c = new Coordonnee(x, y);
					Case ct = niv.getTab_case()[x][y];
					System.out.println(" case "+" : x :"+x+" y : "+y);
					System.out.println(" de type : "+ct.getType());
					return c;

				}
			}
		}
		return null;
	}
	
	public void supprimerToutVN(){
		tab_rec = new ArrayList<Rectangle>();
		x = 0;
		y = 0;
		System.out.println("Supprimer Tout VueNiveau");
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		niv = (Niveau) arg0;
		int cas = (int) arg1;

		switch(cas) {
		case ADD_ML :
			addMouseListener(cc.getMl());
			System.out.println("ajout listner ml");
			break;
		case ADD_MML :
			addMouseMotionListener(cc.getMml());
			System.out.println("ajout listner mml");
			break;
		case ADD_ML_MML :
			addMouseListener(cc.getMl());
			addMouseMotionListener(cc.getMml());
			System.out.println("ajout listner ml & mml");
			break;
		case SUP_ALL :
			removeMouseListener(cc.getMl());
			removeMouseMotionListener(cc.getMml());
			System.out.println("remove listner ml & mml");
			supprimerToutVN();
			break;
		default :
			break;
		}

		repaint();
	}

}
