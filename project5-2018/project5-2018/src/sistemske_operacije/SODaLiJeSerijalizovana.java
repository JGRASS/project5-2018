package sistemske_operacije;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
/**
 * Klasa koja proverava da li je rezultat serijalizovan.
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class SODaLiJeSerijalizovana {
	/**
	 * Metoda koja cita podatke iz fajla i proverava da li je fajl prazan
	 * @return a.size(); broj objekata koje sadrzi fajl
	 * @throws Exception ako nije moguce pristupiti fajlu.
	 */
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
