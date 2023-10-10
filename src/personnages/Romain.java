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
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>.");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forceInitial = force;
//		force -= forceCoup;
//		assert force < forceInitial;
//		if (force>0) {
//			parler("Aie !");
//		} else {
//			parler("J'abandonne...");
//		}		
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
//		switch (force) {
//		case 0:
//			parler("A�e");
//			break;
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		if (force>0) {
			parler("Aie");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					System.out.println("Equipement bouclier");
					resistanceEquipement += 8;
				} 
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <1) {
			forceCoup=1;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void entrerDansEquipements(Equipement equip,String nomEquip) {
		equipements[nbEquipement]=equip;
		String soldat = "Le soldat ";
		System.out.println( soldat + nom + " s'�quipe d'un " + nomEquip +".");
		nbEquipement++;
	}
	
	public void sEquiper(Equipement equip) {
		String nomEquip = equip.getNom();
		String soldat="Le soldat ";
		switch(nbEquipement) {
			case 0:
				entrerDansEquipements(equip,nomEquip);
				break;
			case 1:
				if (nomEquip.equals(equipements[0].getNom())) {
					System.out.println(soldat + nom + " poss�de d�j� un " + nomEquip + "!");
				}
				else {
					entrerDansEquipements(equip,nomEquip);
				}
				break;
			default:
				System.out.println(soldat + nom + " est d�j� bien prot�g� !");
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
