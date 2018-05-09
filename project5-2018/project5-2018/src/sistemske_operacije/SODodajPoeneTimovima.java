package sistemske_operacije;

import java.util.LinkedList;

import domenske_klase.Tim;
import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;

public class SODodajPoeneTimovima {
	
	public static void izvrsi() throws Exception{
		LinkedList<Vozac> v = SistemskiKontroler.deserijalVozaceIzJson();
		LinkedList<Tim> t = SistemskiKontroler.deserijalTimoveIzJson();
		for (int i = 0; i < t.size(); i++) {
			t.get(i).setPoeni(0);
			t.get(i).setPobede(0);
		}
		SistemskiKontroler.serijalTimoveUJson(t);
		t = SistemskiKontroler.deserijalTimoveIzJson();
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < t.size(); j++) {
				if(v.get(i).getTim().equals(t.get(j).getNazivTima())) {
					int pobedeVozaca = v.get(i).getPobede();
					int pobedeTima = t.get(j).getPobede();
					int pobede = pobedeVozaca + pobedeTima;
					int poeniVozaca = v.get(i).getPoeni();
					int poeniTima = t.get(j).getPoeni();
					int poeni = poeniVozaca + poeniTima;
					t.get(j).setPoeni(poeni);
					t.get(j).setPobede(pobede);
				}
			}
		}		
		SistemskiKontroler.serijalTimoveUJson(t);
	}

}
