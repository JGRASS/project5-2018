package sistemske_operacije;

import java.io.FileWriter;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Vozac;

public class SOSerijalVozaceUJson {

	public static void izvrsi(LinkedList<Vozac> v) throws Exception {
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
}
