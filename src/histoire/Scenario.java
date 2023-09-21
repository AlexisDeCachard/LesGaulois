package histoire;

import java.util.Iterator;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix=new Gaulois("Astérix",8);
		Romain minus=new Romain("Minus",6);
		asterix.parler("Bonour à tous !");
		minus.parler("UN GAU...UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
