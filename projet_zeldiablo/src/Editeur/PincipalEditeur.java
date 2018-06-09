package Editeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PincipalEditeur {

	public PincipalEditeur() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Editeur Zeldiablo");
		
		JPanel bas=new JPanel();
		bas.setBackground(new Color(60,60,60));
		
		JPanel droit=new JPanel();
		droit.setBackground(new Color(70,70,70));
		
		JPanel gauche=new JPanel();
		gauche.setBackground(new Color(70,70,70));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Niveau niv = new Niveau();
		PanneauChoix pc = new PanneauChoix(niv);
		VueNiveau vn = new VueNiveau(niv);
		
		f.getContentPane().setLayout(new BorderLayout());
		
		f.getContentPane().add(pc,BorderLayout.NORTH);
		f.getContentPane().add(vn,BorderLayout.CENTER);
		f.getContentPane().add(bas,BorderLayout.SOUTH);
		f.getContentPane().add(droit,BorderLayout.EAST);
		f.getContentPane().add(gauche,BorderLayout.WEST);
		
		f.setPreferredSize(new Dimension(700, 700));
		f.pack();
		f.setVisible(true);
		
	}

}
