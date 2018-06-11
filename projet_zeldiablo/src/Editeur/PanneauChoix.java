package Editeur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Delayed;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import zeldiablo.*;

public class PanneauChoix extends JPanel{
	private JRadioButton rbzone = new JRadioButton("Zone");
	private JRadioButton rbsalle = new JRadioButton("Salle");
	private ButtonGroup bg = new ButtonGroup();
	private JTextField jtfnom = new JTextField("nom", 15);
	private JButton jbcreer = new JButton("Nouveau Projet");

	private JComboBox jcbcase = new JComboBox(new String[]{"Mur","Vide","Entree","Sortie"});
	private JButton jbsave = new JButton("Save");
	private JButton jbouvrir = new JButton("Ouvrir");
	private JButton jbsuppr = new JButton("Supprimer");
	private JButton jbefface = new JButton("Effacer");

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

		rbzone.setSelected(true);

		bg.add(rbzone);
		bg.add(rbsalle);

		op.add(jbsave);
		op.add(jcbcase);
		op.add(jbouvrir);
		op.add(jbsuppr);
		op.add(jbefface);
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




		ActionListener aclsave = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				niv.sauvegarder(jtfnom.getText());
			}
		};
		jbsave.addActionListener(aclsave);


		ActionListener aclouvrir= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".niv Niveau custom", "niv");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("Choisir le fichier a ouvrir : " +
							chooser.getSelectedFile().getName());
					jtfnom.setText(chooser.getSelectedFile().getName());
					niv.ouverture(chooser.getSelectedFile());
					System.out.println("apres niv ouvert");
					//jbcreer.doClick();
					//System.out.println("doclick");
					PositionPanneaux2();
				}
				

			}
		};
		jbouvrir.addActionListener(aclouvrir);

		ActionListener aclsuppr = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Supprimer")){
					System.out.println("suppretion ?");
					jbOuisuppr.setVisible(true);
					jbNonsuppr.setVisible(true);
					PosiationPanneauxallclose();
				}else if(e.getActionCommand().equals("Effacer")){
					niv.supprimerTout();
					if(rbsalle.isSelected()) {
						niv.creationSalle();
					}
					if(rbzone.isSelected()) {
						niv.creationZone(jtfnom.getText());
					}
					PositionPanneaux2();
				}
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
		jbefface.addActionListener(aclsuppr);



		ActionListener aclrb = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rbsalle.isSelected()) {
					jtfnom.setEnabled(true);
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

				PositionPanneaux2();
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
		jbouvrir.setEnabled(true);
		jbsuppr.setEnabled(false);
		jbcreer.setEnabled(true);
		rbsalle.setEnabled(true);
		rbzone.setEnabled(true);
		jtfnom.setEnabled(true);
		jbefface.setEnabled(false);
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
		jtfnom.setEnabled(true);
		jbefface.setEnabled(true);
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
		jbefface.setEnabled(false);
	}

	public void typeFigureSelec() {
		niv.selectedIndex(jcbcase.getSelectedIndex());
	}

	public JPanel getBas() {
		return bas;
	}



}
