package sistemske_operacije;

import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import domenske_klase.Trka;
/**
 * Klasa koja predstavlja deserijalizaciju timova koji ucestvuju na trci Formule 1
 * @author Monika Milenkovi�
 * @author Jelena Milev
 * @author Du�ko Milo�evi�
 * @version 1.0
 */
public class SODeserijalTrkeIzJson {
	/**
	 * Deserijalizuje trke iz json-a iz interne baze i vraca kao listu trka
	 * @return t lista trka
	 * @throws Exception onemoguceno povezivanje sa fajlom
	 */
	public static LinkedList<Trka> izvrsi() throws Exception {
		FileReader reader = new FileReader("data/trke.json");
		LinkedList<Trka> t = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		for (int i = 0; i < a.size(); i++) {
			t.add(gson.fromJson(a.get(i), Trka.class));

		}
		return t;
	}

}
