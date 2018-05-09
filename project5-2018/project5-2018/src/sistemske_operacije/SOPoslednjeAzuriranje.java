package sistemske_operacije;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class SOPoslednjeAzuriranje {
	
	public static String izvrsi() throws Exception{
		FileReader reader = new FileReader("data/log.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject o = gson.fromJson(reader, JsonObject.class);
		String s = o.get("datumVreme").getAsString();
		return s;
		
	}

}
