package personnages;

public class Musee {
	private Trophee[] tableau = new Trophee[200];
	private int nbTrophees=0;
	
	public void donnerTrophees(Gaulois gaulois,Equipement equipement) {
		Trophee trophee = new Trophee(gaulois,equipement);
		if (nbTrophees<tableau.length-1) {
			tableau[nbTrophees]=trophee;
			nbTrophees++;
		}
	}
}
