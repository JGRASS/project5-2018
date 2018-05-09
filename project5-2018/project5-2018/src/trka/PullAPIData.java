package trka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PullAPIData {
	public static final String DRIVERS_API_URL = "http://ergast.com/api/f1/2018/drivers.json";
	public static final String CONSTRUCTORS_API_URL = "http://ergast.com/api/f1/2018/constructors.json";
	public static final String RACES_API_URL = "http://ergast.com/api/f1/2018.json";

	public static void main(String[] args) {
		try {
			
			//PullAPIData.deserijalRezultateAPI();
			System.out.println(PullAPIData.poslednjeAzuriranje());
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

			//PullAPIData.serijalTimoveUJson(PullAPIData.deserijalTimoviAPI());
			LinkedList<Tim> tim = new LinkedList<>();
			tim = PullAPIData.deserijalTimoveIzJson();

			for (int i = 0; i < tim.size(); i++) {
				System.out.println(tim.get(i));
			}
			
			PullAPIData.dodajPoeneVozacima();
			PullAPIData.dodajPoeneTimovima();
			rangListaVozacaPoTrci("Vettel", "Australian Grand Prix");
			PullAPIData.rangListaVozaca();
//			PullAPIData.dodeliVozacimaTimove();
//			PullAPIData.dodeliTimovimaVozace();

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
		LinkedList<Trka> t = deserijalTrkeAPI();
		int k = daLiJeSerijalizovana();
		//System.out.println(t.size());
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
	public static void dodajPoeneVozacima() throws Exception {
		LinkedList<Trka> t = deserijalTrkeIzJson();
		LinkedList<Vozac> v = deserijalVozaceIzJson();
		for (int i = 0; i < v.size(); i++) {
			v.get(i).setPoeni(0);
			v.get(i).setPobede(0);
		}
		serijalVozaceUJson(v);
		v = deserijalVozaceIzJson();
		try {
			for (int i = 0; i < t.size(); i++) {
				LinkedList<Rezultat> r = deserijalizacijaRezultataIzJson(t.get(i).getNazivTrke());
				for (int j = 0; j < 10; j++) {
					for (int j2 = 0;j2< v.size(); j2++) {
						if(v.get(j2).getPrezime().equals(r.get(j).getVozac().getPrezime())) {
							int poeni = v.get(j2).getPoeni();
							int pobede = v.get(j2).getPobede();
							switch(j) {
							case 0 : poeni += 25;
									v.get(j2).setPobede(pobede+1);
								break;
							case 1 : poeni += 18;
							break;
							case 2 : poeni += 15;
							break;
							case 3 : poeni += 12;
							break;
							case 4 : poeni += 10;
							break;
							case 5 : poeni += 8;
							break;
							case 6 : poeni += 6;
							break;
							case 7 : poeni += 4;
							break;
							case 8 : poeni += 2;
							break;
							case 9 : poeni += 1;
							break;
							}
							
							
							v.get(j2).setPoeni(poeni);
							
							
							
						}
					}
				}
			}
			//serijalVozaceUJson(v);
		} catch (Exception e) {
		
		}
		serijalVozaceUJson(v);
	}
	public static void dodajPoeneTimovima() throws Exception{
		LinkedList<Vozac> v = deserijalVozaceIzJson();
		LinkedList<Tim> t = deserijalTimoveIzJson();
		for (int i = 0; i < t.size(); i++) {
			t.get(i).setPoeni(0);
			t.get(i).setPobede(0);
		}
		serijalTimoveUJson(t);
		t = deserijalTimoveIzJson();
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < t.size(); j++) {
				if(v.get(i).getTim().equals(t.get(j).getNazivTima())) {
					int pobedeVozaca = v.get(i).getPobede();
					int pobedeTima = t.get(j).getPobede();
					int pobede = pobedeVozaca + pobedeTima;
					int poeniVozaca = v.get(i).getPoeni();
					int poeniTima = t.get(j).getPoeni();
					int poeni = poeniVozaca + poeniTima;
					t.get(j).setPoeni(poeni);
					t.get(j).setPobede(pobede);
				}
			}
		}
		
		serijalTimoveUJson(t);
	}
	
	public static String poslednjeAzuriranje() throws Exception{
		FileReader reader = new FileReader("data/log.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject o = gson.fromJson(reader, JsonObject.class);
		String s = o.get("datumVreme").getAsString();
		return s;
		
	}
		 
	    public static void rangListaVozaca() throws Exception{
	         LinkedList<Vozac> v=deserijalVozaceIzJson();
	         LinkedList<Vozac> vSort=new LinkedList<>();
	         
	         Vozac max=v.getFirst();
	        int j=0;
	         for (int i = 0; i <v.size(); i++) {
	        	 max=new Vozac();
	        	 max.setPoeni(-1);
				 for (j = 0; j < v.size(); j++) {
					 if(!vSort.contains(v.get(j)) && max.getPoeni()<=v.get(j).getPoeni()) {
						 if(max.getPoeni()==v.get(j).getPoeni()) {
							 if(max.getPobede()>v.get(j).getPobede()) {
								 continue;
								 
							 }
							 
						 }
						 max=v.get(j);
	        		
					 	}
	         	}
				 vSort.addLast(max);	 	 
	      }
	         
	            FileWriter writer = new FileWriter("data/rangListaVozaca.json");
	     		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	     		JsonArray a = new JsonArray();
	     		for (int i = 0; i < vSort.size(); i++) {
	     			String s = gson.toJson(vSort.get(i));
	     			JsonObject o = gson.fromJson(s, JsonObject.class);
	     			a.add(o);

	     		}
	     		writer.write(gson.toJson(a));
	     		writer.close();

	  
	    }
	    
	    public static void rangListaTimova() throws Exception{
	    	LinkedList<Tim> t=deserijalTimoveIzJson();
	    	LinkedList<Tim> tSort=new LinkedList<>();
	    	Tim max=t.getFirst();
		        int j=0;
		        
		         for (int i = 0; i <t.size(); i++) {
		        	 max=new Tim();
		        	 max.setPoeni(-1);
					 for (j = 0; j < t.size(); j++) {
						 if(!tSort.contains(t.get(j)) && max.getPoeni()<=t.get(j).getPoeni()) {
							if(max.getPoeni()==t.get(j).getPoeni()) {
								if(max.getPobede()>t.get(j).getPobede())
									continue;
							}
							else
								max=t.get(j);
		        		
						 	}
		         	}
					 tSort.addLast(max);	 	 
		      }
		         FileWriter writer = new FileWriter("data/rangListaTimova.json");
		     		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		     		JsonArray a = new JsonArray();
		     		for (int i = 0; i < tSort.size(); i++) {
		     			Tim t1=tSort.get(i);
		     			//String s=gson.toJson(t1);
		     			String s = "{" + "\"nazivTima\"" + ":" + "\"" + t1.getNazivTima() + "\"" + "," + "\"Poeni\"" + ":" + t1.getPoeni()
		     					 + "," + "\"Pobede\""+":" + t1.getPobede() + "}";
		     			JsonObject o = gson.fromJson(s, JsonObject.class);
		     			a.add(o);

		     		}
		     		writer.write(gson.toJson(a));
		     		writer.close();
		     		
		    		
	}
	    
	    public static void rangListaVozacaPoTrci(String prezime,String nazivTrke) throws Exception {
	    	LinkedList<Rezultat> r=deserijalizacijaRezultataIzJson(nazivTrke);
	    	FileWriter writer = new FileWriter("data/rangListaVozacaPoTrci.json");
	     	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	     	JsonArray a = new JsonArray();
	    	for (int i = 0; i < r.size(); i++) {
     			Rezultat r1=r.get(i);
     			//String s=gson.toJson(r1);
     			String s = "{" + "\"Ime\"" + ":" + "\"" + r1.getVozac().getIme() + "\"" + "," + "\"Prezime\"" + ":" +"\""+
     					r1.getVozac().getPrezime() + "\"" + 
     					 ","+"\"Vreme\"" +":"+"\"" + r1.getVreme()+ "\"" + "}";
     			JsonObject o = gson.fromJson(s, JsonObject.class);
     			a.add(o);

     		}
     		writer.write(gson.toJson(a));
     		writer.close();
     		
			
	    }
	   
	    
}
