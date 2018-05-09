package sistemske_operacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Rezultat;
import sistemski_kontroler.SistemskiKontroler;

public class SORangListaVozacaPoTrci {
	
	public static void izvrsi(String prezime, String nazivTrke) throws Exception {
		LinkedList<Rezultat> r = SistemskiKontroler.deserijalizacijaRezultataIzJson(nazivTrke);
		FileWriter writer = new FileWriter("data/rangListaVozacaPoTrci.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		for (int i = 0; i < r.size(); i++) {
			Rezultat r1 = r.get(i);
			// String s=gson.toJson(r1);
			String s = "{" + "\"Ime\"" + ":" + "\"" + r1.getVozac().getIme() + "\"" + "," + "\"Prezime\"" + ":" + "\""
					+ r1.getVozac().getPrezime() + "\"" + "," + "\"Vreme\"" + ":" + "\"" + r1.getVreme() + "\"" + "}";
			JsonObject o = gson.fromJson(s, JsonObject.class);
			a.add(o);

		}
		writer.write(gson.toJson(a));
		writer.close();

	}


}
