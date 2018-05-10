package sistemske_operacije;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Rezultat;
import domenske_klase.Trka;
import domenske_klase.Vozac;
import sistemski_kontroler.SistemskiKontroler;
/**
 * Klasa koja predstavlja deserijalizaciju/serijalizaciju rezultata na trci Formule 1
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SODeserijalRezultateAPI {
	/**
	 * Metoda koja vrsi serijalizaciju svih rezultata sa url-a koje nemamo u internoj bazi, i vreme poslednjeg azuriranja,
	 * @throws Exception ako nije moguca konekcija sa internetom, pristup fajlu...
	 */
	public static void izvrsi() throws Exception {
		/////////////////////////////////////////////////////////////////////////////////////////
		Date d = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String date = simple.format(d);
		FileWriter writer = new FileWriter("data/log.json");
		Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
		String zaSer = "{" + "\"datumVreme\"" + ":" + "\"" + date + "\"" +"}";
		JsonObject ob = gson1.fromJson(zaSer, JsonObject.class);
		writer.write(gson1.toJson(ob));
		writer.close();
		/////////////////////////////////////////////////////////////////////////////////////////
		LinkedList<Trka> t = SistemskiKontroler.deserijalTrkeAPI();
		int k = SistemskiKontroler.daLiJeSerijalizovana();
		//System.out.println(t.size());
		for (int i = 0; i < t.size() ; i++) {
			//Provera da li je trka vec unesena
			if(k>i)
				continue;
			String RESULTS_API_URL = "https://ergast.com/api/f1/2018/" + (int)(i+1) + "/results.json";
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			LinkedList<Rezultat> r = new LinkedList<>();
			JsonObject o = gson.fromJson(SistemskiKontroler.getContent(RESULTS_API_URL), JsonObject.class);
			JsonObject jo = new JsonObject();
			jo = o;
			int p = ((JsonObject) jo.get("MRData")).get("total").getAsInt();
			//Provera da li trka ima rezultate
			if(p == 0)
				continue;
			JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("RaceTable")).get("Races").getAsJsonArray();
			// System.out.println(a.size());
			JsonArray ja = a.get(0).getAsJsonObject().get("Results").getAsJsonArray();
			for (int i1 = 0; i1 < ja.size(); i1++) {
				Rezultat r1 = new Rezultat();
				JsonObject obj = ((JsonObject) ja.get(i1)).getAsJsonObject();
				JsonObject driver = obj.get("Driver").getAsJsonObject();
				r1.setVozac(gson.fromJson(driver, Vozac.class));
				r1.setMesto(obj.get("position").getAsInt());
				String status = obj.get("status").getAsString();
				// vreme trke "DNF" onima koji nisu zavrsili trku
				if (status.equals("Finished")) {
					System.out.println(status);
					JsonObject objTime = ((JsonObject) (ja.get(i1))).get("Time").getAsJsonObject();
					r1.setVreme(objTime.get("time").getAsString());
				} 
				else if(status.contains("Lap")){
					System.out.println(status);
					r1.setVreme(status);
					
				}else {
					System.out.println(status);
					r1.setVreme("DNF");
				}
				r.add(r1);
			}
			SistemskiKontroler.serijalizacijaRezultataUJson(r,i+1,t.get(i).getNazivTrke());
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
	
	}

}
