package trka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class PullAPIData {
	public static final String DRIVERS_API_URL = "http://ergast.com/api/f1/2018/drivers.json";
	public static final String CONSTRUCTORS_API_URL = "http://ergast.com/api/f1/2018/constructors.json";
	public static final String RACES_API_URL = "http://ergast.com/api/f1/2018.json";

	public static void main(String[] args) {
		try {
			PullAPIData.dodeliVozacimaTimove();
			PullAPIData.dodeliTimovimaVozace();
			//PullAPIData.deserijalRezultateAPI();
			LinkedList<Rezultat> r = new LinkedList<>();
			r = PullAPIData.deserijalizacijaRezultataIzJson("Chinese Grand Prix");
			for (int i = 0; i < r.size(); i++) {
				System.out.println(r.get(i));
			}

			// PullAPIData.serijalTrkeUJson(PullAPIData.deserijalTrkeAPI());
			LinkedList<Trka> t = new LinkedList<>();
			t = PullAPIData.deserijalTrkeIzJson();
			for (int i = 0; i < t.size(); i++) {
				System.out.println(t.get(i));
			}
			// PullAPIData.serijalVozaceUJson(PullAPIData.deserijalVozaciAPI());
			LinkedList<Vozac> v = new LinkedList<>();
			v = PullAPIData.deserijalVozaceIzJson();
			
			for (int i = 0; i < v.size(); i++) {
				System.out.println(v.get(i));
			}

			// PullAPIData.serijalTimoveUJson(PullAPIData.deserijalTimoviAPI());
			LinkedList<Tim> tim = new LinkedList<>();
			tim = PullAPIData.deserijalTimoveIzJson();

			for (int i = 0; i < tim.size(); i++) {
				System.out.println(tim.get(i));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getContent(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		boolean endReading = false;
		String response = "";

		while (!endReading) {
			String s = in.readLine();

			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();

		return response.toString();
	}

	public static LinkedList<Vozac> deserijalVozaciAPI() throws Exception {
		LinkedList<Vozac> v = new LinkedList<Vozac>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject o = gson.fromJson(getContent(DRIVERS_API_URL), JsonObject.class);
		JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("DriverTable")).get("Drivers").getAsJsonArray();
		// System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			Vozac v1 = new Vozac();
			JsonObject jo = a.get(i).getAsJsonObject();
			v1 = gson.fromJson(jo, Vozac.class);
			v.add(v1);
		}
		return v;
	}

	public static void serijalVozaceUJson(LinkedList<Vozac> v) throws Exception {
		FileWriter writer = new FileWriter("data/vozaci.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		for (int i = 0; i < v.size(); i++) {
			String s = gson.toJson(v.get(i));
			JsonObject o = gson.fromJson(s, JsonObject.class);
			a.add(o);
		}
		writer.write(gson.toJson(a));
		writer.close();
	}

	public static LinkedList<Vozac> deserijalVozaceIzJson() throws Exception {
		FileReader reader = new FileReader("data/vozaci.json");
		LinkedList<Vozac> v = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		for (int i = 0; i < a.size(); i++) {
			v.add(gson.fromJson(a.get(i), Vozac.class));
		}
		return v;
	}

	public static LinkedList<Tim> deserijalTimoviAPI() throws Exception {
		LinkedList<Tim> t = new LinkedList<Tim>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject o = gson.fromJson(getContent(CONSTRUCTORS_API_URL), JsonObject.class);
		JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("ConstructorTable")).get("Constructors")
				.getAsJsonArray();
		// System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			Tim t1 = new Tim();
			JsonObject jo = a.get(i).getAsJsonObject();
			t1 = gson.fromJson(jo, Tim.class);
			t.add(t1);
		}
		return t;
	}

	public static void serijalTimoveUJson(LinkedList<Tim> t) throws Exception {
		FileWriter writer = new FileWriter("data/timovi.json");
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

	public static LinkedList<Tim> deserijalTimoveIzJson() throws Exception {
		FileReader reader = new FileReader("data/timovi.json");
		LinkedList<Tim> t = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		for (int i = 0; i < a.size(); i++) {
			t.add(gson.fromJson(a.get(i), Tim.class));
		}
		return t;
	}

	public static LinkedList<Trka> deserijalTrkeAPI() throws Exception {
		LinkedList<Trka> t = new LinkedList<Trka>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject o = gson.fromJson(getContent(RACES_API_URL), JsonObject.class);
		JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("RaceTable")).get("Races").getAsJsonArray();
		// System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			Trka t1 = new Trka();
			JsonObject jo = (a.get(i).getAsJsonObject());
			t1.setNazivTrke(jo.get("raceName").getAsString());
			t1.setRunda(jo.get("round").getAsInt());

			JsonObject oo = (((JsonObject) jo.get("Circuit")).get("Location")).getAsJsonObject();
			t1.setDrzava(oo.get("country").getAsString());
			t1.setDatum(jo.get("date").getAsString());
			t.add(t1);

		}

		return t;
	}

	public static void serijalTrkeUJson(LinkedList<Trka> t) throws IOException {
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

	public static LinkedList<Trka> deserijalTrkeIzJson() throws Exception {
		FileReader reader = new FileReader("data/trke.json");
		LinkedList<Trka> t = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		for (int i = 0; i < a.size(); i++) {
			t.add(gson.fromJson(a.get(i), Trka.class));

		}
		return t;
	}

	public static void dodeliVozacimaTimove() throws Exception {
		LinkedList<Vozac> v = PullAPIData.deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			switch (v.get(i).getPrezime()) {
			case ("Alonso"):
				v.get(i).setTim("McLaren");
				break;
			case ("Vandoorne"):
				v.get(i).setTim("McLaren");
				break;
			case ("Bottas"):
				v.get(i).setTim("Mercedes");
				break;
			case ("Ericsson"):
				v.get(i).setTim("Sauber");
				break;
			case ("Gasly"):
				v.get(i).setTim("Toro Rosso");
				break;
			case ("Grosjean"):
				v.get(i).setTim("Haas F1 Team");
				break;
			case ("Hamilton"):
				v.get(i).setTim("Mercedes");
				break;
			case ("Hartley"):
				v.get(i).setTim("Toro Rosso");
				break;
			case ("Hülkenberg"):
				v.get(i).setTim("Renault");
				break;
			case ("Leclerc"):
				v.get(i).setTim("Sauber");
				break;
			case ("Magnussen"):
				v.get(i).setTim("Haas F1 Team");
				break;
			case ("Ocon"):
				v.get(i).setTim("Force India");
				break;
			case ("Pérez"):
				v.get(i).setTim("Force India");
				break;
			case ("Räikkönen"):
				v.get(i).setTim("Ferrari");
				break;
			case ("Ricciardo"):
				v.get(i).setTim("Red Bull");
				break;
			case ("Sainz"):
				v.get(i).setTim("Renault");
				break;
			case ("Sirotkin"):
				v.get(i).setTim("Williams");
				break;
			case ("Stroll"):
				v.get(i).setTim("Williams");
				break;
			case ("Verstappen"):
				v.get(i).setTim("Red Bull");
				break;
			case ("Vettel"):
				v.get(i).setTim("Ferrari");
				break;
			default:
				v.get(i).setTim("Error");
				break;
			}
		}
		PullAPIData.serijalVozaceUJson(v);
	}

	public static void dodeliTimovimaVozace() throws Exception {
		LinkedList<Tim> t = PullAPIData.deserijalTimoveIzJson();
		LinkedList<Vozac> v = PullAPIData.deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < t.size(); j++) {
				if (v.get(i).getTim().equals(t.get(j).getNazivTima()))
					t.get(j).setVozaci(v.get(i));
			}
		}
		PullAPIData.serijalTimoveUJson(t);
	}

	public static void deserijalRezultateAPI() throws Exception {
		
		/////////////////////////////////////////////////////////////////////////////////////////
		LinkedList<Trka> t = deserijalTrkeAPI();
		int k = daLiJeSerijalizovana();
		System.out.println(t.size());
		for (int i = 0; i < t.size() ; i++) {
			//Provera da li je trka vec unesena
			if(k>i)
				continue;
			String RESULTS_API_URL = "https://ergast.com/api/f1/2018/" + (int)(i+1) + "/results.json";
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			LinkedList<Rezultat> r = new LinkedList<>();
			JsonObject o = gson.fromJson(getContent(RESULTS_API_URL), JsonObject.class);
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

					JsonObject objTime = ((JsonObject) (ja.get(i1))).get("Time").getAsJsonObject();
					r1.setVreme(objTime.get("time").getAsString());
				} else {
					r1.setVreme("DNF");
				}
				r.add(r1);
			}
			serijalizacijaRezultataUJson(r,i+1,t.get(i).getNazivTrke());
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
	
	}

	public static void serijalizacijaRezultataUJson(LinkedList<Rezultat> r, int runda,String nazivTrke) throws Exception {
		JsonArray c = new JsonArray();
		/*
		  Pre otvaranja fajla za serijalizaciju pokupi ono sto je do sada serijalizovano
		 */
		c = deserijalCeoRezultat();
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

	public static JsonArray deserijalCeoRezultat() throws Exception {
		FileReader reader = new FileReader("data/rezultati.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		return a;
	}
	public static LinkedList<Rezultat> deserijalizacijaRezultataIzJson(String nazivTrke) throws Exception {
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
	public static int daLiJeSerijalizovana() throws Exception {
		FileReader reader = new FileReader("data/rezultati.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		a = gson.fromJson(reader, JsonArray.class);
		if(a==null)
			return 0;
		return a.size();
	}
}
