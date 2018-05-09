package sistemske_operacije;

import java.util.LinkedList;

import domenske_klase.Tim;
import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;

public class SODodeliTimovimaVozace {
	public static void izvrsi() throws Exception {
		LinkedList<Tim> t = SistemskiKontroler.deserijalTimoveIzJson();
		LinkedList<Vozac> v = SistemskiKontroler.deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < t.size(); j++) {
				if (v.get(i).getTim().equals(t.get(j).getNazivTima()))
					t.get(j).setVozaci(v.get(i));
			}
		}
		SistemskiKontroler.serijalTimoveUJson(t);
	}


}
