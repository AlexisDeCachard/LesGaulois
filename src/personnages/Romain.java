package personnages;

public class Romain {
	private String nom;
	private int force;
	
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
	public static void main(String[] args) {
		Romain minus=new Romain("Minus",6);
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour !");
		minus.recevoirCoup(7);
		minus.recevoirCoup(0);
	}
}
