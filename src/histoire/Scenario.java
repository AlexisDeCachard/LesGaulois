package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;


public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix=new Gaulois("Astérix",8);
		Romain minus=new Romain("Minus",6);
		Druide pano = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Obelix", 25);
		pano.parler("Je vais aller préparer une petite potion...");
		pano.preparerPotion();
		pano.booster(obelix);
		obelix.parler("Par Bélénos, c'est pas juste !");
		pano.booster(asterix);
		asterix.parler("Bonjour.");
		minus.parler("UN GAU...UN GAUGAU...");
		asterix.frapper(minus,pano);
	}
}
