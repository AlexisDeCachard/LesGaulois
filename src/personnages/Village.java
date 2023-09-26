package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village (String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois != villageois.length) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int referenceVillageois) {
		return villageois[referenceVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < villageois.length;i++) {
			if (villageois[i] != null) {
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}
	
	public static void main(String[] args) {
		Village irreduc = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = irreduc.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
//		at personnages.Village.trouverHabitant(Village.java:30)
//		at personnages.Village.main(Village.java:35)
//		Le tableau va de l'indice 0 à l'indice 29, donc il ne peut pas y avoir de valeur à l'indice 30 dans ce tableau.
		Chef abra = new Chef("Abraracourcix",6,irreduc);
		irreduc.setChef(abra);
		Gaulois asterix=new Gaulois("Asterix",8);
		irreduc.ajouterHabitant(asterix);
//		Gaulois gaulois = irreduc.trouverHabitant(1);
//		System.out.println(gaulois);
//		null
//		Pour l'instant, il n'y a qu'un seul gaulois, Asterix, qui se situe à l'indice 0. Donc la valeur à l'indice 1 n'a pas encore été ajoutée, mais a été initialisée. Donc on obtient une valeur nulle.
		Gaulois obelix = new Gaulois("Obelix",25);
		irreduc.ajouterHabitant(obelix);
		irreduc.afficherVillageois();
	}
}
