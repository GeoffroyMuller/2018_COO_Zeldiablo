package Editeur;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import zeldiablo.*;
import java.util.Observable;

public class Niveau extends Observable implements Serializable{
	private Salle salle;
	private Zone zone;

	private Case[][] tab_case;
	private ControleurCase cc;
	private int taille;
	private int selectedIndex;

	private boolean estsalle,estzone;


	public Niveau() {
		// TODO Auto-generated constructor stub
		salle = null;
		zone = null;
		estsalle = false;
		estzone = false;
		tab_case = null;
		taille = 0;
	}

	public void creationSalle() {
		salle = new Salle();
		estsalle = true;
		tab_case = salle.getGrille();
		taille = Salle.TAILLE_SALLES;
		System.out.println("creation salle");
		setChanged();
		notifyObservers(VueNiveau.ADD_ML);
	}

	public void creationZone(String nom) {
		zone = new Zone(nom);
		estzone = true;
		tab_case = zone.getGrilleZone();
		taille = Zone.TAILLE_ZONE;
		System.out.println("creation zone :"+nom);
		setChanged();
		notifyObservers(VueNiveau.ADD_ML);
	}

	public boolean isEstsalle() {
		return estsalle;
	}

	public boolean isEstzone() {
		return estzone;
	}

	public Case[][] getTab_case() {
		return tab_case;
	}

	public int getTaille() {
		return taille;
	}

	public String getTypeCase(int xe , int ye) {//peux procur des erreur 
		return tab_case[xe][ye].getType();
	}

	public void selectedIndex(int i) {
		this.selectedIndex=i;
	}

	public void changerCase(Coordonnee co) {
		System.out.println(selectedIndex);

		try {
			switch (selectedIndex) {
			case 0 :
				tab_case[co.getX()][co.getY()]=new Mur();
				break;


			case 1 :
				tab_case[co.getX()][co.getY()]= new Vide();
				break;

			case 2 :
				tab_case[co.getX()][co.getY()]= new Entree();
				break;

			case 3 :
				tab_case[co.getX()][co.getY()] = new Sortie();
				break;


			default :

				break;
			}
		}
		catch(NullPointerException npe) {
			System.out.println("clique entre deux case");
		}

		setChanged();
		notifyObservers(0);
	}

	public void supprimerTout() {
		System.out.println("Supprimer Tout");
		salle = null;
		zone = null;
		estsalle = false;
		estzone = false;
		tab_case = null;
		taille = 0;
		setChanged();
		notifyObservers(0);
	}
	public void sauvegarder(String nomSave) {
		try {

			if(estsalle) {
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("..\\Salles\\"+nomSave));
				oos.writeObject(salle);
				System.out.println("Salle Sauvegarder");
				oos.close();
			}
			if(estzone) {
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("..\\Zones\\"+nomSave));
				oos.writeObject(zone);
				System.out.println("Zone Sauvegarder");
				oos.close();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur Sauvegarde : IOException");
			e.printStackTrace();
		}
	}

	public void ouverture(File f) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			try {
				Salle s = (Salle)ois.readObject();
				creationSalle(s);
				
			}
			catch(Exception e) {
				System.out.println("pas une salle");
			}
			try {
				Zone z = (Zone)ois.readObject();
				creationZone(z);
			}
			catch(Exception e) {
				System.out.println("pas une zone");
			}
			
			ois.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void creationSalle(Salle s) {
		salle=s;
		System.out.println(salle);
		tab_case=s.getGrille();
		System.out.println(tab_case);
		System.out.println("ouverture  salle");
		setChanged();
		notifyObservers(VueNiveau.ADD_ML);
	}
	
	public void creationZone(Zone z) {
		zone =z;
		tab_case=z.getGrilleZone();
		taille = Zone.TAILLE_ZONE;
		System.out.println("ouverture zone ");
		setChanged();
		notifyObservers(VueNiveau.ADD_ML);
	}

}
