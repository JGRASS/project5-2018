package sistemske_operacije;

import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import domenske_klase.Tim;

public class SODeserijalTimoveIzJson {
	public static LinkedList<Tim> izvrsi() throws Exception {
		FileReader reader = new FileReader("data/timovi.json");
		LinkedList<Tim> t = new LinkedList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		for (int i = 0; i < a.size(); i++) {
			t.add(gson.fromJson(a.get(i), Tim.class));
		}
		return t;
	}

}
