package sistemske_operacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Tim;
/**
 * Klasa koja predstavlja serijalizaciju timova.
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SOSerijalTimoveUJson {
	/**
	 * Serijalizacija timova u json fajl.
	 * @param t lista timova
	 * @throws Exception  onemoguceno povezivanje sa fajlom
	 */
	public static void izvrsi(LinkedList<Tim> t) throws Exception {
		FileWriter writer = new FileWriter("data/timovi.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		for (int i = 0; i < t.size(); i++) {
			String s = gson.toJson(t.get(i));
			JsonObject o = gson.fromJson(s, JsonObject.class);
			a.add(o);
		}
		writer.write(gson.toJson(a));
		writer.close();
	}
}
