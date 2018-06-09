package Editeur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import zeldiablo.*;

public class ControleurCase {
	private VueNiveau vn;
	private Niveau nv;
	private MouseListener ml;
	
	public ControleurCase(VueNiveau pvn,Niveau pnv) {
		// TODO Auto-generated constructor stub
		vn = pvn;
		nv=pnv;
		ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Clics");
				Coordonnee c=vn.estDedans(e.getX(), e.getY());
				nv.changerCase(c);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	public MouseListener getMl() {
		return ml;
	}
	

}
