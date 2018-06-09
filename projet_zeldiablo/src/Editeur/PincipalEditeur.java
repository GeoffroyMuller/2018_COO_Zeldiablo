package Editeur;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class PincipalEditeur {

	public PincipalEditeur() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Editeur Zeldiablo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Niveau niv = new Niveau();
		PanneauChoix pc = new PanneauChoix(niv);
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(pc,BorderLayout.NORTH);
		f.setPreferredSize(new Dimension(700, 700));
		f.pack();
		f.setVisible(true);
		
	}

}
