package sistemske_operacije;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
/**
 * Klasa koja predstavlja deserijalizaciju vremena poslednjeg preuzimanja podataka sa interneta o trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class SOPoslednjeAzuriranje {
	/**
	 * Deserijalizuje vreme poslednje azuriranja interne baze
	 * @return s vreme kao String
	 * @throws Exception onemoguceno povezivanje sa fajlom
	 */
	public static String izvrsi() throws Exception{
		FileReader reader = new FileReader("data/log.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject o = gson.fromJson(reader, JsonObject.class);
		String s = o.get("datumVreme").getAsString();
		return s;
		
	}

}
