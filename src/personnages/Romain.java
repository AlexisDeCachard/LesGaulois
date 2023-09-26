package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements=new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>.");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceInitial = force;
		force -= forceCoup;
		assert force < forceInitial;
		if (force>0) {
			parler("Aie !");
		} else {
			parler("J'abandonne...");
		}		
	}
	public void entrerDansEquipements(Equipement equip,String nomEquip) {
		equipements[nbEquipement]=equip;
		System.out.println("Le soldat " + nom + " s'équipe d'un " + nomEquip +".");
		nbEquipement++;
	}
	
	public void sEquiper(Equipement equip) {
		String nomEquip = equip.getNom();
		switch(nbEquipement) {
			case 0:
				entrerDansEquipements(equip,nomEquip);
				break;
			case 1:
				if (nomEquip == equipements[0].getNom()) {
					System.out.println("Le soldat " + nom + " possède déjà un " + nomEquip + "!");
				}
				else {
					entrerDansEquipements(equip,nomEquip);
				}
				break;
			default:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
		}
	}
	
	public static void main(String[] args) {
		Romain minus=new Romain("Minus",6);
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour !");
		minus.recevoirCoup(4);
		minus.recevoirCoup(2);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
