package trka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



public class PullAPIData {
	public static final String DRIVERS_API_URL  = "http://ergast.com/api/f1/2018/drivers.json";
	public static void main(String[] args) {
		try {
			PullAPIData.serijalVozaceUJson(PullAPIData.deserijalVozaciAPI());
			LinkedList<Vozac> v = new LinkedList<>();
			v = PullAPIData.deserijalVozaceIzJson();
			for (int i = 0; i < v.size(); i++) {
				System.out.println(v.get(i));
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
		public static LinkedList<Vozac> deserijalVozaciAPI() throws Exception{
			LinkedList<Vozac> v = new LinkedList<Vozac>();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
				JsonObject o =gson.fromJson(getContent(DRIVERS_API_URL), JsonObject.class);
				JsonArray a = ((JsonObject) ((JsonObject) o.get("MRData")).get("DriverTable")).get("Drivers").getAsJsonArray();
				System.out.println(a.size());
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
				JsonObject o=gson.fromJson(s, JsonObject.class);
				a.add(o);
			}
			writer.write(gson.toJson(a));
			writer.close();
		}
		public static LinkedList<Vozac> deserijalVozaceIzJson() throws Exception{
			FileReader reader = new FileReader("data/vozaci.json");
			LinkedList<Vozac> v = new LinkedList<>();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonArray a = gson.fromJson(reader, JsonArray.class);
			for (int i = 0; i < a.size(); i++) {
				v.add(gson.fromJson(a.get(i), Vozac.class));
			}
			return v;
		}
		
}
