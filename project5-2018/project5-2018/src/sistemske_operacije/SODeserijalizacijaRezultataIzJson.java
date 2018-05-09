package sistemske_operacije;

import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Rezultat;

public class SODeserijalizacijaRezultataIzJson {
	
	public static LinkedList<Rezultat> izvrsi(String nazivTrke) throws Exception {
		FileReader reader = new FileReader("data/rezultati.json");
		LinkedList<Rezultat> r = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		JsonArray b = new JsonArray();
		for (int i = 0; i < a.size(); i++) {
			if((((JsonObject) a.get(i)).get("nazivTrke").getAsString()).equals(nazivTrke)) {
				b = ((JsonObject) a.get(i)).get("Rezultat").getAsJsonArray();
			}

		}
		for (int i = 0; i < b.size(); i++) {
			Rezultat r1 = new Rezultat();
			r1= gson.fromJson(b.get(i), Rezultat.class);
			r.add(r1);
		}
		return r;
	}

}
