package sistemske_operacije;

import java.util.LinkedList;

import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja dodelu timova vozacima na trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SODodeliVozacimaTimove {
	/**
	 * Dodela timova za koje vozaci voze iz interne baze vozacima 
	 * @throws Exception onemoguceno povezivanje sa fajlovima
	 */
	public static void izvrsi() throws Exception {
		LinkedList<Vozac> v = SistemskiKontroler.deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			switch (v.get(i).getPrezime()) {
			case ("Alonso"):
				v.get(i).setTim("McLaren");
				break;
			case ("Vandoorne"):
				v.get(i).setTim("McLaren");
				break;
			case ("Bottas"):
				v.get(i).setTim("Mercedes");
				break;
			case ("Ericsson"):
				v.get(i).setTim("Sauber");
				break;
			case ("Gasly"):
				v.get(i).setTim("Toro Rosso");
				break;
			case ("Grosjean"):
				v.get(i).setTim("Haas F1 Team");
				break;
			case ("Hamilton"):
				v.get(i).setTim("Mercedes");
				break;
			case ("Hartley"):
				v.get(i).setTim("Toro Rosso");
				break;
			case ("HÃ¼lkenberg"):
				v.get(i).setTim("Renault");
				break;
			case ("Leclerc"):
				v.get(i).setTim("Sauber");
				break;
			case ("Magnussen"):
				v.get(i).setTim("Haas F1 Team");
				break;
			case ("Ocon"):
				v.get(i).setTim("Force India");
				break;
			case ("PÃ©rez"):
				v.get(i).setTim("Force India");
				break;
			case ("RÃ¤ikkÃ¶nen"):
				v.get(i).setTim("Ferrari");
				break;
			case ("Ricciardo"):
				v.get(i).setTim("Red Bull");
				break;
			case ("Sainz"):
				v.get(i).setTim("Renault");
				break;
			case ("Sirotkin"):
				v.get(i).setTim("Williams");
				break;
			case ("Stroll"):
				v.get(i).setTim("Williams");
				break;
			case ("Verstappen"):
				v.get(i).setTim("Red Bull");
				break;
			case ("Vettel"):
				v.get(i).setTim("Ferrari");
				break;
			default:
				v.get(i).setTim("Error");
				break;
			}
		}
		SistemskiKontroler.serijalVozaceUJson(v);
	}
}
