package sistemske_operacije;

import java.util.LinkedList;

import domenske_klase.Rezultat;
import domenske_klase.Trka;
import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja dodelu poena vozacima koji ucestvuju na trci Formule 1
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Miloševic
 * @version 1.0
 */
public class SODodajPoeneVozacima {
	/**
	 * Dodela poena vozacima
	 * 
	 * @throws Exception onemoguceno povezivanje sa fajlovima
	 */
	public static void izvrsi() throws Exception {
		LinkedList<Trka> t = SistemskiKontroler.deserijalTrkeIzJson();
		LinkedList<Vozac> v = SistemskiKontroler.deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			v.get(i).setPoeni(0);
			v.get(i).setPobede(0);
		}
		SistemskiKontroler.serijalVozaceUJson(v);
		v = SistemskiKontroler.deserijalVozaceIzJson();
		try {
			for (int i = 0; i < t.size(); i++) {
				LinkedList<Rezultat> r = SistemskiKontroler.deserijalizacijaRezultataIzJson(t.get(i).getNazivTrke());
				for (int j = 0; j < 10; j++) {
					for (int j2 = 0;j2< v.size(); j2++) {
						if(v.get(j2).getPrezime().equals(r.get(j).getVozac().getPrezime())) {
							int poeni = v.get(j2).getPoeni();
							int pobede = v.get(j2).getPobede();
							switch(j) {
							case 0 : poeni += 25;
									v.get(j2).setPobede(pobede+1);
								break;
							case 1 : poeni += 18;
							break;
							case 2 : poeni += 15;
							break;
							case 3 : poeni += 12;
							break;
							case 4 : poeni += 10;
							break;
							case 5 : poeni += 8;
							break;
							case 6 : poeni += 6;
							break;
							case 7 : poeni += 4;
							break;
							case 8 : poeni += 2;
							break;
							case 9 : poeni += 1;
							break;
							}
							
							
							v.get(j2).setPoeni(poeni);
							
							
							
						}
					}
				}
			}
			//serijalVozaceUJson(v);
		} catch (Exception e) {
		
		}
		SistemskiKontroler.serijalVozaceUJson(v);
	}
}
