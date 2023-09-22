package personnages;

import java.lang.reflect.Method;
import java.security.PublicKey;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;		
	}

		
	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>.");
	}
	
	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain, Druide druide) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force/3)* druide.getForcePotion());
	}
	
	public void boirePotion(int forcePotion) {
		parler("Merci Druide, je sens que ma force est "+ forcePotion + " fois décuplée.");
	}
		
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix.toString());
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour !");
		Romain minus=new Romain("Minus",3);
		Druide pano = new Druide("Panoramix", 5, 10);
		pano.preparerPotion();
		asterix.boirePotion(pano.getForcePotion());
		asterix.frapper(minus,pano);
		asterix.frapper(minus,pano);
	}

	
}