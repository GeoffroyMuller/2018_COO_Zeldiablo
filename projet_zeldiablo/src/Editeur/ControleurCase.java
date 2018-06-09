package Editeur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurCase {
	private VueNiveau vn;
	private MouseListener ml;
	
	public ControleurCase(VueNiveau vne) {
		// TODO Auto-generated constructor stub
		vn = vne;
		ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Clics");
				vn.estDedans(e.getX(), e.getY());
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
