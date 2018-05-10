package sistemske_operacije;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
/**
 * Klasa koja deserijalizuje sve rezultate sa trka Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SODeserijalCeoRezultat {
	/**
	 *	Metoda koja deserijalizuje rezultate u json formatu.
	 * @return a niz rezultata u json-u.
	 * @throws Exception ako nije moguce pristupiti fajlu.
	 */
	public static JsonArray izvrsi() throws Exception {
		FileReader reader = new FileReader("data/rezultati.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		return a;
	}

}
