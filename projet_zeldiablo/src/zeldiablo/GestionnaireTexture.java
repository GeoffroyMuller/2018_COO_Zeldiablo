package zeldiablo;

import java.awt.Image;
import java.util.ArrayList;

public class GestionnaireTexture {
	ArrayList<Texture> listeTexture = new ArrayList<Texture>();
	public GestionnaireTexture() {
		listeTexture.add(new Texture("sol_bois", "..\\texture\\wood.png" ));
		listeTexture.add(new Texture("wall_dark", "..\\texture\\wall_dark_stone.png" ));
		listeTexture.add(new Texture("portail_entree", "..\\texture\\Portail_Entree.png" ));
		listeTexture.add(new Texture("portail_sortie", "..\\texture\\Portail_Sortie.png" ));
		listeTexture.add(new Texture("portail_escalier", "..\\texture\\Portail_Escalier.png" ));
	}
	
	public Image attribuerTexture(Case c) {
		Image t = null;
		for (int i = 0; i < listeTexture.size(); i++) {

			if(listeTexture.get(i).getNom().equals(c.getTextureMotCle())) {
				t=listeTexture.get(i).getImg();
			}
		}
		
		return t;
	}

}
