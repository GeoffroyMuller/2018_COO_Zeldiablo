package Editeur;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import zeldiablo.ZeldiabloDessin;

public class VueNiveau  extends JPanel implements Observer{
	
	private int x=0;
	private int y=0;
	private int taillecase=ZeldiabloDessin.TAILLE;
	
	private Niveau niv;
	
	public VueNiveau(Niveau nive) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(180,180,180));
		niv = nive;
		niv.addObserver(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		x=10;
		y=10;
		g.setColor(Color.black);
		if(niv.getTab_case()!=null) {
			g.setColor(Color.BLACK);
			for(int i=0;i<niv.getTaille();i++) {
				for(int j=0;j<niv.getTaille();j++) {
					g.fillRect(x, y, taillecase, taillecase);
					x+=taillecase+2;
				}
				y+=taillecase+2;
				x=10;
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		repaint();
	}

}
