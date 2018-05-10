package sistemske_operacije;

import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import domenske_klase.Vozac;
/**
 * Klasa koja predstavlja deserijalizaciju timova koji ucestvuju na trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SODeserijalVozaceIzJson {
	/**
	 * Deserijalizuje vozace iz json-a iz interne baze i vraca kao listu trka
	 * @return v lista vozaca
	 * @throws Exception onemoguceno povezivanje sa fajlom
	 */
	public static LinkedList<Vozac> izvrsi() throws Exception {
		FileReader reader = new FileReader("data/vozaci.json");
		LinkedList<Vozac> v = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		for (int i = 0; i < a.size(); i++) {
			v.add(gson.fromJson(a.get(i), Vozac.class));
		}
		return v;
	}
}
