package sistemske_operacije;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Rezultat;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja prestavlja rezultate jednog vozaca. 
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SORezultatiPoVozacu {
	/**
	 * Ukupni rezultati vozaca na svim trkama na kojima je vozio.
	 * @return rez listu rezultata vozaca
	 * @throws Exception onemoguceno povezivanje sa fajlom
	 */
	public static LinkedList<String> izvrsi(String prezime) throws IOException {
		LinkedList<String> rez = new LinkedList<>();

		FileReader reader = new FileReader("data/rezultati.json");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// ucitani svi rezultati
		JsonArray sviRezultati = gson.fromJson(reader, JsonArray.class);

		JsonArray rezZaTrku = new JsonArray();

		for (int i = 0; i < sviRezultati.size(); i++) {
			String r = "";
			JsonObject trka = sviRezultati.get(i).getAsJsonObject();
			r += trka.get("nazivTrke").getAsString();
			r += " :\t";
			rezZaTrku = trka.get("Rezultat").getAsJsonArray();
			for (int j = 0; j < rezZaTrku.size(); j++) {
				JsonObject rezJson = rezZaTrku.get(j).getAsJsonObject();
				if (rezJson.get("vozac").getAsJsonObject().get("prezime").getAsString().equals(prezime)) {
					String vreme = rezJson.get("vreme").getAsString();
					String mesto = rezJson.get("mesto").getAsString();
					r += vreme + "\t" + mesto;
					break;
				}
			}
			rez.add(r);
		}
		reader.close();
		return rez;
	}
	
}