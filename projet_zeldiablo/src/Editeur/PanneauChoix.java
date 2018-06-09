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
	
	private JComboBox jcbcase = new JComboBox(new String[]{"Mur","Vide","Autre"});
	private JButton jbsave = new JButton("Save");
	private JButton jbouvrir = new JButton("Ouvrir");
	
	private JPanel rb = new JPanel();
	private JPanel op = new JPanel();
	
	private Niveau niv;

	public PanneauChoix(Niveau nive) {
		// TODO Auto-generated constructor stub
		niv = nive;
		setLayout(new BorderLayout());
		
		rbzone.setSelected(true);
		
		bg.add(rbzone);
		bg.add(rbsalle);
		
		op.add(jbsave);
		op.add(jcbcase);
		op.add(jbouvrir);
		op.setBackground(new Color(60,60,60));
		
		rb.add(rbzone);
		rb.add(rbsalle);
		rb.add(jtfnom);
		rb.add(jbcreer);
		rb.setBackground(new Color(70,70,70));

		add(rb, BorderLayout.NORTH);
		add(op, BorderLayout.CENTER);
		
		jcbcase.setEnabled(false);
		jbsave.setEnabled(false);
		jbouvrir.setEnabled(false);
		
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
			}

		};
		jbcreer.addActionListener(acl);
		rbsalle.addActionListener(aclrb);
		rbzone.addActionListener(aclrb);
	}

}
