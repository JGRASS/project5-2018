package sistemske_operacije;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Trka;
/**
 * Klasa koja predstavlja serijalizaciju trka.
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SOSerijalTrkeUJson {
	/**
	 * Serijaziacija trka u interni json fajl.
	 * @param t lista trka
	 * @throws IOException neuspele ili prekinute I/O operacije
	 */
	public static void izvrsi(LinkedList<Trka> t) throws IOException {
		FileWriter writer = new FileWriter("data/trke.json");
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
