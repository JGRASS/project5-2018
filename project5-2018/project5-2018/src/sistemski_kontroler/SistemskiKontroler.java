package sistemski_kontroler;

import java.io.IOException;
import java.util.LinkedList;
import com.google.gson.JsonArray;

import domenske_klase.Rezultat;
import domenske_klase.Tim;
import domenske_klase.Trka;
import domenske_klase.Vozac;
import sistemske_operacije.SODaLiJeSerijalizovana;
import sistemske_operacije.SODeserijalCeoRezultat;
import sistemske_operacije.SODeserijalRezultateAPI;
import sistemske_operacije.SODeserijalTimoveIzJson;
import sistemske_operacije.SODeserijalTimoviAPI;
import sistemske_operacije.SODeserijalTrkeAPI;
import sistemske_operacije.SODeserijalTrkeIzJson;
import sistemske_operacije.SODeserijalVozaceIzJson;
import sistemske_operacije.SODeserijalVozaciAPI;
import sistemske_operacije.SODeserijalizacijaRezultataIzJson;
import sistemske_operacije.SODodajPoeneTimovima;
import sistemske_operacije.SODodajPoeneVozacima;
import sistemske_operacije.SODodeliTimovimaVozace;
import sistemske_operacije.SODodeliVozacimaTimove;
import sistemske_operacije.SOGetContent;
import sistemske_operacije.SOPoslednjeAzuriranje;
import sistemske_operacije.SORangListaTimova;
import sistemske_operacije.SORangListaVozaca;
import sistemske_operacije.SORezultatiPoVozacu;
import sistemske_operacije.SOSerijalTimoveUJson;
import sistemske_operacije.SOSerijalTrkeUJson;
import sistemske_operacije.SOSerijalVozaceUJson;
import sistemske_operacije.SOSerijalizacijaRezultataUJson;

public class SistemskiKontroler {
	public static final String DRIVERS_API_URL = "http://ergast.com/api/f1/2018/drivers.json";
	public static final String CONSTRUCTORS_API_URL = "http://ergast.com/api/f1/2018/constructors.json";
	public static final String RACES_API_URL = "http://ergast.com/api/f1/2018.json";

	public static String getContent(String driversApiUrl) throws IOException {
		return SOGetContent.izvrsi(driversApiUrl);
	}

	public LinkedList<Vozac> deserijalVozaciAPI() throws Exception {
		return SODeserijalVozaciAPI.izvrsi(DRIVERS_API_URL);
	}

	public static void serijalVozaceUJson(LinkedList<Vozac> v) throws Exception {
		SOSerijalVozaceUJson.izvrsi(v);
	}

	public static LinkedList<Vozac> deserijalVozaceIzJson() throws Exception {
		return SODeserijalVozaceIzJson.izvrsi();
	}

	public LinkedList<Tim> deserijalTimoviAPI() throws Exception {
		return SODeserijalTimoviAPI.izvrsi(CONSTRUCTORS_API_URL);
	}

	public static void serijalTimoveUJson(LinkedList<Tim> t) throws Exception {
		SOSerijalTimoveUJson.izvrsi(t);
	}

	public static LinkedList<Tim> deserijalTimoveIzJson() throws Exception {
		return SODeserijalTimoveIzJson.izvrsi();
	}

	public static LinkedList<Trka> deserijalTrkeAPI() throws Exception {
		return SODeserijalTrkeAPI.izvrsi(RACES_API_URL);
	}

	public void serijalTrkeUJson(LinkedList<Trka> t) throws IOException {
		SOSerijalTrkeUJson.izvrsi(t);
	}

	public static LinkedList<Trka> deserijalTrkeIzJson() throws Exception {
		return SODeserijalTrkeIzJson.izvrsi();
	}

	public void dodeliVozacimaTimove() throws Exception {
		SODodeliVozacimaTimove.izvrsi();
	}

	public void dodeliTimovimaVozace() throws Exception {
		SODodeliTimovimaVozace.izvrsi();
	}

	public void deserijalRezultateAPI() throws Exception {
		SODeserijalRezultateAPI.izvrsi();

	}

	public static void serijalizacijaRezultataUJson(LinkedList<Rezultat> r, int runda, String nazivTrke)
			throws Exception {
		SOSerijalizacijaRezultataUJson.izvrsi(r, runda, nazivTrke);

	}

	public static JsonArray deserijalCeoRezultat() throws Exception {
		return SODeserijalCeoRezultat.izvrsi();
	}

	public static LinkedList<Rezultat> deserijalizacijaRezultataIzJson(String nazivTrke) throws Exception {
		return SODeserijalizacijaRezultataIzJson.izvrsi(nazivTrke);
	}

	public static int daLiJeSerijalizovana() throws Exception {
		return SODaLiJeSerijalizovana.izvrsi();
	}

	public void dodajPoeneVozacima() throws Exception {
		SODodajPoeneVozacima.izvrsi();
	}

	public void dodajPoeneTimovima() throws Exception {
		SODodajPoeneTimovima.izvrsi();
	}

	public String poslednjeAzuriranje() throws Exception {
		return SOPoslednjeAzuriranje.izvrsi();
	}

	public LinkedList<Vozac> rangListaVozaca() throws Exception {
		return SORangListaVozaca.izvrsi();
	}

	public LinkedList<Tim> rangListaTimova() throws Exception {
		return SORangListaTimova.izvrsi();
	}
	public static LinkedList<String> rezultatiPoVozacu(String prezime) throws IOException{
		return SORezultatiPoVozacu.izvrsi(prezime);
	}

}
