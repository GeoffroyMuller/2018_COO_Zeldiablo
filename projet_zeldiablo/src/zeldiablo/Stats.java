package zeldiablo;

public class Stats {
	private int force;
	private int resistance;
	private int exp;
	private int expPourPasser;
	private int niveau;
	
	public int getForce() {
		return force;
	}


	public int getResistance() {
		return resistance;
	}


	public Stats(int niv) {

		niveau=0;
		
		force=0;
		resistance=0;
		exp=0;
		expPourPasser = 1000;
		for (int i = 0; i < niv; i++) {
			changementNiveau();
		}
		
	}
	
	
	public void ajoutExp(int aj) {
		exp+=aj;
		if(exp>=expPourPasser) {
			changementNiveau();
		}
	}
	
	public void changementNiveau() {
		exp=0;
		niveau++;
		force+=10*niveau;
		resistance+=10*niveau;
		expPourPasser+=1000*niveau;
	}
	
	public void modifierNiveau(int niv){
		for (int i = 0; i < niv; i++) {
			changementNiveau();
		}
	}
}
