package Editeur;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class VueNiveau  extends JPanel implements Observer{
	
	private Niveau niv;
	public VueNiveau(Niveau nive) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(180,180,180));
		niv = nive;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(10, 10, 10, 10);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
