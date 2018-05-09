package sistemske_operacije;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domenske_klase.Tim;
import sistemski_kontroler.SistemskiKontroler;

public class SODeserijalTimoviAPI {
	
	public static LinkedList<Tim> izvrsi(String CONSTRUCTORS_API_URL) throws Exception {
		LinkedList<Tim> t = new LinkedList<Tim>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject o = gson.fromJson(SistemskiKontroler.getContent(CONSTRUCTORS_API_URL), JsonObject.class);
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

}
