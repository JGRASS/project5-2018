package sistemske_operacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Tim;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja deserijalizaciju vremena poslednjeg preuzimanja podataka sa interneta o trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SORangListaTimova {

	public static void izvrsi() throws Exception {
		LinkedList<Tim> t = SistemskiKontroler.deserijalTimoveIzJson();
		LinkedList<Tim> tSort = new LinkedList<>();
		Tim max = t.getFirst();
		int j = 0;

		for (int i = 0; i < t.size(); i++) {
			max = new Tim();
			max.setPoeni(0);
			for (j = 0; j < t.size(); j++) {
				if (!tSort.contains(t.get(j)) && max.getPoeni() <= t.get(j).getPoeni()) {
					if (max.getPoeni() == t.get(j).getPoeni()) {
						if (max.getPobede() > t.get(j).getPobede())
							continue;
					} else
						max = t.get(j);

				}
			}
			tSort.addLast(max);
		}
		FileWriter writer = new FileWriter("data/rangListaTimova.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		for (int i = 0; i < tSort.size(); i++) {
			Tim t1 = tSort.get(i);
			// String s=gson.toJson(t1);
			String s = "{" + "\"nazivTima\"" + ":" + "\"" + t1.getNazivTima() + "\"" + "," + "\"Poeni\"" + ":"
					+ t1.getPoeni() + "," + "\"Pobede\"" + ":" + t1.getPobede() + "}";
			JsonObject o = gson.fromJson(s, JsonObject.class);
			a.add(o);

		}
		writer.write(gson.toJson(a));
		writer.close();

	}
}
