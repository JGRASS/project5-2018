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

public class SORezultatiPoVozacu {

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
	
	public static void main(String[] args) {
		try {
			LinkedList<String> s=izvrsi("Hamilton");
			Object[] niz=s.toArray();
			for (int i = 0; i < niz.length; i++) {
				System.out.println(niz[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}