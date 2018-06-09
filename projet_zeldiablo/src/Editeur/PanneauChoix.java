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

	public PanneauChoix() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		JPanel rb = new JPanel();
		JPanel op = new JPanel();
		
		rbzone.setSelected(true);
		
		bg.add(rbzone);
		bg.add(rbsalle);
		
		op.add(jcbcase);
		rb.add(rbzone);
		rb.add(rbsalle);
		rb.add(jtfnom);
		rb.add(jbcreer);
		rb.setBackground(new Color(70,70,70));
		op.setBackground(new Color(60,60,60));
		
		add(rb, BorderLayout.NORTH);
		add(op, BorderLayout.CENTER);
		
		jcbcase.setEnabled(false);
		
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
					Salle sl = new Salle();
					System.out.println("creation salle");
				}
				if(rbzone.isSelected()) {
					Zone sl = new Zone(jtfnom.getText());
					System.out.println("creation zone : "+ jtfnom.getText());
				}
				jbcreer.setEnabled(false);
				rbsalle.setEnabled(false);
				rbzone.setEnabled(false);
				jtfnom.setEnabled(false);
				jcbcase.setEnabled(true);
			}

		};
		jbcreer.addActionListener(acl);
		rbsalle.addActionListener(aclrb);
		rbzone.addActionListener(aclrb);
	}

}
