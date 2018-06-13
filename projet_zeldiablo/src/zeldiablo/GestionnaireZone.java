package zeldiablo;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Creation de la classe GestionnaireZone
 */
public class GestionnaireZone {
	/**
	 * attribut ArrayList de Zone qui contiendra toutes les zones
	 */
	private ArrayList<Zone> lz;
	/**
	 * attribut ArrayList de fichier qui contiendra tous les fichiers de zones
	 */
	private ArrayList<File> lf;

	/**
	 * Constructeur de GestionnaireZone qui initialise les attributs
	 */
	public GestionnaireZone(){
		lz = new ArrayList<Zone>();
		lf = new ArrayList<File>();

		File folder = new File("..\\Zones\\");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				if(file.getName().endsWith(".niv")){
					lf.add(file);
					System.out.println("");
				}


			}
		}
		try{
			for (int i = 0; i < lf.size(); i++) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(lf.get(i)));
				Zone z = ((Zone)ois.readObject());
				ois.close();
				lz.add(z);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * methode getter qui va chercher la liste de fichier 
	 * @return la liste de fichier
	 */
	public ArrayList<File> getLf() {
		return lf;
	}
	/**
	 * methode qui permet de donner une zone pour constituer un bout de la salle
	 * @param rdm, parametre permettant de donner un nombre aleatoire
	 * @return la zone avec le numero donne par l'aleatoire
	 */
	public Zone donnerUneZone(Aleatoire rdm){
		int rd = rdm.genererNombreAleatoire(0, this.lz.size()); 
		Zone z =  lz.get(rd);
		return z;

	}

	/**
	 * methode getter qui va chercher la liste des zones
	 * @return la liste des zones 
	 */
	public ArrayList<Zone> getLz() {
		return lz;
	}



}
