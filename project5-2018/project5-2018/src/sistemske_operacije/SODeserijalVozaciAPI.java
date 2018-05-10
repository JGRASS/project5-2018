package sistemske_operacije;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja vozaca na trci Formule 1
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SODeserijalVozaciAPI {
	/**
	 * Deserijalizuje vozace iz json-a sa prosledjenog linka.
	 * @param DRIVERS_API_URL link
	 * @return v listu vozaca
	 * @throws Exception ako nije omoguceno povezivanje
	 */
	public static LinkedList<Vozac> izvrsi(String DRIVERS_API_URL) throws Exception {
		LinkedList<Vozac> v = new LinkedList<Vozac>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject o = gson.fromJson(SistemskiKontroler.getContent(DRIVERS_API_URL), JsonObject.class);
		JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("DriverTable")).get("Drivers").getAsJsonArray();
		// System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			Vozac v1 = new Vozac();
			JsonObject jo = a.get(i).getAsJsonObject();
			v1 = gson.fromJson(jo, Vozac.class);
			v.add(v1);
		}
		return v;
	}
}
