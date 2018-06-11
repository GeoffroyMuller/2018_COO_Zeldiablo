package zeldiablo;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class GestionnaireZone {
	
	private ArrayList<Zone> lz;
	private ArrayList<File> lf;
	
	
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
			Zone z = (Zone)(ois.readObject());
			ois.close();
			lz.add(z);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Zone donnerUneZone(){
		System.out.println("================="+lz.size());
		int rd = (int)(Math.random()*this.lz.size());
		System.out.println("==================="+rd);
		Zone z =  lz.get(rd);
		return z;
		
	}


	public ArrayList<Zone> getLz() {
		return lz;
	}
	
	

}
