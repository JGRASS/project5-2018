package sistemske_operacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Rezultat;
import sistemski_kontroler.SistemskiKontroler;

public class SOSerijalizacijaRezultataUJson {
	
	public static void izvrsi(LinkedList<Rezultat> r, int runda,String nazivTrke) throws Exception {
		JsonArray c = new JsonArray();
		/*
		  Pre otvaranja fajla za serijalizaciju pokupi ono sto je do sada serijalizovano
		 */
		c = SistemskiKontroler.deserijalCeoRezultat();
		FileWriter writer = new FileWriter("data/rezultati.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		for (int i = 0; i < r.size(); i++) {
			String s = gson.toJson(r.get(i));
			JsonObject o = gson.fromJson(s, JsonObject.class);
			a.add(o);

		}
		String rezZaSer = gson.toJson(a);
		
		System.out.println(rezZaSer);
		String zaSer = "{" + "\"nazivTrke\"" + ":" + "\"" + nazivTrke + "\"" + "," + "\"runda\"" + ":" + runda
				 + "," + "\"serijal\"" + ":"  + true + ","+ "\"Rezultat\""+":" + rezZaSer + "}";
		JsonObject jo = gson.fromJson(zaSer, JsonObject.class);
		if(c==null) {//Ako je fajl bio prazan
		JsonArray b = new JsonArray();
		b.add(jo);
		writer.write(gson.toJson(b));
		writer.close();
		}else {//Ako je u fajlu nesto postojalo
			c.add(jo);
			writer.write(gson.toJson(c));
			writer.close();
		}

	}
}
