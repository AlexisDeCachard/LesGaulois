package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;		
	}

		
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>.");
	}
	
//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force/3) * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheescombat = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheescombat != null && i < tropheescombat.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheescombat[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est "+ effetPotion + " fois d�cupl�e.");
	}
	
	public void faireUneDonation(Musee musee) {
		Gaulois gaulois=new Gaulois(this.nom,this.force);
		parler("Je donne au musee tous mes trophees:");
		while (nbTrophees!=0) {
				musee.donnerTrophees(gaulois, trophees[nbTrophees-1]);;
				System.out.println("- " + trophees[nbTrophees-1]);
				trophees[nbTrophees-1]=null;
				nbTrophees --;
		}
	}
	
		
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix.toString());
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour !");
		Romain minus=new Romain("Minus",1);
		Druide pano = new Druide("Panoramix", 5, 10);
		pano.preparerPotion();
		asterix.boirePotion(pano.getForcePotion());
		Musee musee=new Musee();
		asterix.faireUneDonation(musee);
		minus.sEquiper(Equipement.BOUCLIER);
		asterix.frapper(minus);
		asterix.faireUneDonation(musee);
		System.out.println(musee.extraireInstructionsOcaml());
	}

	
}