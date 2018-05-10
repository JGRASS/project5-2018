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
 * Klasa koja predstavlja rangiranje timova.
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SORangListaTimova {
	/**
	 * Rangiranje timova po ukupnim poenima i pobedama.
	 * @return tSort listu timova
	 * @throws Exception onemoguceno povezivanje sa fajlom
	 */
	public static LinkedList<Tim> izvrsi() throws Exception {
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
		return tSort;
	}
}
