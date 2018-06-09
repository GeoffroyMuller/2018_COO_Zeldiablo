package Editeur;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class VueNiveau  extends JPanel implements Observer{
	
	private Niveau niv;
	public VueNiveau(Niveau nive) {
		// TODO Auto-generated constructor stub
		niv = nive;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
