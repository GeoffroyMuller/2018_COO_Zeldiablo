package Editeur;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import zeldiablo.Case;
import zeldiablo.ZeldiabloDessin;

public class VueNiveau  extends JPanel implements Observer{
	
	private static final int MARGE_TAILLECASE_X = 10;
	private static final int MARGE_TAILLECASE_Y = 10;
	
	public static final int ADD_ML = 100;
	
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
		
		cc = new ControleurCase(this);
		
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
					/*if(niv.getCase(i, j)=="mur") {
						g.setColor(Color.RED);
					}else {
						g.setColor(Color.blue);
					}*/
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
	
	public Case estDedans(int xe,int ye) {
		if(tab_rec.size()==((niv.getTaille())*(niv.getTaille()))) {
			for(int i=0;i<tab_rec.size();i++) {
				if(tab_rec.get(i).contains(xe, ye)) {
					System.out.println("estDedand retourn Rectangle num:"+i);
					int x,y;
					x = i%25;
					y = (int)i/25;
					System.out.println(" case : x :"+x+" y : "+y);
					Case c = niv.getTab_case()[x][y];
					return c;
					
				}
			}
		}
		return null;
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
		}

		repaint();
	}

}
