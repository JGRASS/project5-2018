package sistemske_operacije;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Trka;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja deserijalizaciju timova koji ucestvuju na trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SODeserijalTrkeAPI {
	/**
	 * Deserijalizuje trke iz json-a sa prosledjenog linka.
	 * @param RACES_API_URL link
	 * @return t listu trka
	 * @throws Exception ako nije omoguceno povezivanje
	 */
	public static LinkedList<Trka> izvrsi(String RACES_API_URL) throws Exception {
		LinkedList<Trka> t = new LinkedList<Trka>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject o = gson.fromJson(SistemskiKontroler.getContent(RACES_API_URL), JsonObject.class);
		JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("RaceTable")).get("Races").getAsJsonArray();
		// System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			Trka t1 = new Trka();
			JsonObject jo = (a.get(i).getAsJsonObject());
			t1.setNazivTrke(jo.get("raceName").getAsString());
			t1.setRunda(jo.get("round").getAsInt());

			JsonObject oo = (((JsonObject) jo.get("Circuit")).get("Location")).getAsJsonObject();
			t1.setDrzava(oo.get("country").getAsString());
			t1.setDatum(jo.get("date").getAsString());
			t.add(t1);

		}

		return t;
	}
}
