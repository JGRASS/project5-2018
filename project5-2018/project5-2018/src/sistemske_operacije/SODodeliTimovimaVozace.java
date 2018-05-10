package sistemske_operacije;

import java.util.LinkedList;

import domenske_klase.Tim;
import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja dodelu vozaca timovima na trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SODodeliTimovimaVozace {
	/**
	 * Dodela vozaca iz interne baze timovima za koje voze
	 * @throws Exception onemoguceno povezivanje sa fajlovima
	 */
	public static void izvrsi() throws Exception {
		LinkedList<Tim> t = SistemskiKontroler.deserijalTimoveIzJson();
		LinkedList<Vozac> v = SistemskiKontroler.deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < t.size(); j++) {
				if (v.get(i).getTim().equals(t.get(j).getNazivTima())) {
					boolean flag = false;
					for (int j2 = 0; j2 < t.get(j).getVozaci().size(); j2++) {
						if(t.get(j).getVozaci().get(j2).getPrezime().equals(v.get(i).getPrezime())) {
							flag = true;
							break;
						}
					}
					if(flag)
						continue;
					t.get(j).setVozaci(v.get(i));
					
				}
			}
		}
		SistemskiKontroler.serijalTimoveUJson(t);
	}


}
