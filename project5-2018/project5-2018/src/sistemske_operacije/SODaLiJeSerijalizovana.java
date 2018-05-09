package sistemske_operacije;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class SODaLiJeSerijalizovana {
	
	public static int izvrsi() throws Exception {
		FileReader reader = new FileReader("data/rezultati.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = new JsonArray();
		a = gson.fromJson(reader, JsonArray.class);
		if(a==null)
			return 0;
		return a.size();
	}

}
