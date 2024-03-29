package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour ! Je suis le druide " + nom + " et ma potion peut aller d'une force de " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	
	public int getForcePotion() {
		return forcePotion;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>.");
	}
	
	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obelix")) {
			parler("Non Obelix !... Tu n'auras pas de potion magique !" );
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public void preparerPotion() {
		Random potion = new Random();
//		forcePotion = potion.nextInt(effetPotionMax);
		forcePotion= potion.nextInt(effetPotionMax-effetPotionMin + 1)+effetPotionMin;
		if (forcePotion>7) {
			parler("J'ai pr�par� une super potion de force " + forcePotion + ".");
		} else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotion + ".");
		}
	}
	
	public static void main(String[] args) {
		Druide pano = new Druide("Panoramix", 5, 10);
		pano.preparerPotion();
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 25);
		pano.booster(asterix);
		pano.booster(obelix);
	}
}
