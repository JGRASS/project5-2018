package sistemske_operacije;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class SODeserijalCeoRezultat {
	
	public static JsonArray izvrsi() throws Exception {
		FileReader reader = new FileReader("data/rezultati.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		return a;
	}

}
