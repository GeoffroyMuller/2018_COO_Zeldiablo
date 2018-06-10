package Editeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Delayed;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import zeldiablo.*;

public class PanneauChoix extends JPanel{
	private JRadioButton rbzone = new JRadioButton("Zone");
	private JRadioButton rbsalle = new JRadioButton("Salle");
	private ButtonGroup bg = new ButtonGroup();
	private JTextField jtfnom = new JTextField("nom", 15);
	private JButton jbcreer = new JButton("Creer");
	
	private JComboBox jcbcase = new JComboBox(new String[]{"Mur","Vide","Entree","Sortie"});
	private JButton jbsave = new JButton("Save");
	private JButton jbouvrir = new JButton("Ouvrir");
	private JButton jbsuppr = new JButton("Supprimer");
	
	private JButton jbOuisuppr = new JButton("Oui");
	private JButton jbNonsuppr = new JButton("Non");
	
	private JPanel rb = new JPanel();
	private JPanel op = new JPanel();
	JPanel bas=new JPanel();

	
	private Niveau niv;

	public PanneauChoix(Niveau nive) {
		// TODO Auto-generated constructor stub
		niv = nive;
		setLayout(new BorderLayout());
		
		rbsalle.setSelected(true);
		
		bg.add(rbzone);
		bg.add(rbsalle);
		
		op.add(jbsave);
		op.add(jcbcase);
		op.add(jbouvrir);
		op.add(jbsuppr);
		op.setBackground(new Color(60,60,60));
		
		rb.add(rbzone);
		rb.add(rbsalle);
		rb.add(jtfnom);
		rb.add(jbcreer);
		rb.setBackground(new Color(70,70,70));
		
		bas.add(jbOuisuppr);
		bas.add(jbNonsuppr);
		bas.setBackground(new Color(60,60,60));
		
		add(rb, BorderLayout.NORTH);
		add(op, BorderLayout.CENTER);
		
		PositionPanneaux1();
		
		ActionListener aclsuppr = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jbOuisuppr.setVisible(true);
				jbNonsuppr.setVisible(true);
				PosiationPanneauxallclose();
				if(e.getActionCommand().equals("Oui")) {
					niv.supprimerTout();
					PositionPanneaux1();
				}else if(e.getActionCommand().equals("Non")){
					PositionPanneaux2();
				}
				
			}
		};
		jbOuisuppr.addActionListener(aclsuppr);
		jbNonsuppr.addActionListener(aclsuppr);
		jbsuppr.addActionListener(aclsuppr);
		
		ActionListener aclrb = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rbsalle.isSelected()) {
					jtfnom.setEnabled(false);
				}
				if(rbzone.isSelected()) {
					jtfnom.setEnabled(true);
				}
			}
		};
		rbsalle.addActionListener(aclrb);
		rbzone.addActionListener(aclrb);
		
		ActionListener acl = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(rbsalle.isSelected()) {
					niv.creationSalle();
				}
				if(rbzone.isSelected()) {
					niv.creationZone(jtfnom.getText());
				}
				
				jbcreer.setEnabled(false);
				rbsalle.setEnabled(false);
				rbzone.setEnabled(false);
				jtfnom.setEnabled(false);
				
				jcbcase.setEnabled(true);
				jbsave.setEnabled(true);
				jbouvrir.setEnabled(true);
				jbsuppr.setEnabled(true);
			}

		};
		jbcreer.addActionListener(acl);

		
		ActionListener aljcb = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				typeFigureSelec();
				
			}
		};
		
		jcbcase.addActionListener(aljcb);
	}
	public void PositionPanneaux1() {
		jbOuisuppr.setVisible(false);
		jbNonsuppr.setVisible(false);
		jcbcase.setEnabled(false);
		jbsave.setEnabled(false);
		jbouvrir.setEnabled(false);
		jbsuppr.setEnabled(false);
		jbcreer.setEnabled(true);
		rbsalle.setEnabled(true);
		rbzone.setEnabled(true);
		jtfnom.setEnabled(true);
	}
	public void PositionPanneaux2() {
		jbOuisuppr.setVisible(false);
		jbNonsuppr.setVisible(false);
		jcbcase.setEnabled(true);
		jbsave.setEnabled(true);
		jbouvrir.setEnabled(true);
		jbsuppr.setEnabled(true);
		jbcreer.setEnabled(false);
		rbsalle.setEnabled(false);
		rbzone.setEnabled(false);
		jtfnom.setEnabled(false);
	}
	public void PosiationPanneauxallclose() {
		jcbcase.setEnabled(false);
		jbsave.setEnabled(false);
		jbouvrir.setEnabled(false);
		jbsuppr.setEnabled(false);
		jbcreer.setEnabled(false);
		rbsalle.setEnabled(false);
		rbzone.setEnabled(false);
		jtfnom.setEnabled(false);
	}
	
	public void typeFigureSelec() {
		niv.selectedIndex(jcbcase.getSelectedIndex());
	}

	public JPanel getBas() {
		return bas;
	}
	
	

}
