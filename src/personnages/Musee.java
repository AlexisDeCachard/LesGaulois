package personnages;

public class Musee {
	private Trophee[] tableau = new Trophee[200];
	private int nbTrophees=0;
	private int nbTropheesMax=200;


	public int getNbTropheesMax() {
		return nbTropheesMax;
	}



	public void donnerTrophees(Gaulois gaulois,Equipement equipement) {
		Trophee trophee = new Trophee(gaulois,equipement);
		if (nbTrophees<tableau.length-1) {
			tableau[nbTrophees]=trophee;
			nbTrophees++;
		}
	}
	
	public String extraireInstructionsOcaml() {
		StringBuilder chaine = new StringBuilder("let musee = [ ");
		for (int i = 0; i<nbTrophees;i++) {
			Gaulois gaulois = tableau[i].getGaulois();
			Equipement equip=tableau[i].getEquipement();
			chaine.append(gaulois.getNom() + ", " + equip.getNom() + "; ");
		}
		chaine.append(" ]");
		return chaine.toString();
	}
}
