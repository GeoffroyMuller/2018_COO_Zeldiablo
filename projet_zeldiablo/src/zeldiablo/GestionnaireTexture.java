package zeldiablo;

import java.awt.Image;
import java.util.ArrayList;
/**
 * Creation de la classe GestionnaireTexture
 */
public class GestionnaireTexture {
	/**
	 * attribut ArrayList de Texture qui contiendra les differentes textures a attribuer
	 */
	ArrayList<Texture> listeTexture = new ArrayList<Texture>();
	public GestionnaireTexture() {
		listeTexture.add(new Texture("sol_bois", "..\\texture\\wood.png" ));
		listeTexture.add(new Texture("wall_dark", "..\\texture\\wall_dark_stone.png" ));
		listeTexture.add(new Texture("portail_entree", "..\\texture\\Portail_Entree.png" ));
		listeTexture.add(new Texture("portail_sortie", "..\\texture\\Portail_Sortie.png" ));
		listeTexture.add(new Texture("portail_fin", "..\\texture\\Portail_Fin.png" ));
		listeTexture.add(new Texture("portail_escalier", "..\\texture\\Portail_Escalier.png" ));
		listeTexture.add(new Texture("potion", "..\\texture\\potion.png"));
		listeTexture.add(new Texture("aventurier", "..\\texture\\Aventurier_Final.png"));
		listeTexture.add(new Texture("aventurierAtt", "..\\texture\\aventurier_attaque.png"));
	}
	/**
	 * methode permettant d'attribuer une texture a une case
	 * @param c, case a laquelle attribuer une texture
	 * @return image de la case avec la texture
	 */
	public Image attribuerTexture(ObjetTexturer c) {
		Image t = null;
		for (int i = 0; i < listeTexture.size(); i++) {

			if(listeTexture.get(i).getNom().equals(c.getTextureMotCle())) {
				t=listeTexture.get(i).getImg();
			}
		}
		
		return t;
	}
	/**
	 * methode getter qui va chercher la liste des textures
	 * @return la liste des textures
	 */
	public ArrayList<Texture> getListeTexture() {
		return listeTexture;
	}
	/**
	 * methode setter qui initialise la liste des textures avec celle passee en parametre
	 * @param listeTexture, liste des textures
	 */
	public void setListeTexture(ArrayList<Texture> listeTexture) {
		this.listeTexture = listeTexture;
	}

}
