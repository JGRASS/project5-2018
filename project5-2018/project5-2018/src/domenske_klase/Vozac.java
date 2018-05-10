package domenske_klase;

import com.google.gson.annotations.SerializedName;
/**
 * Klasa koja predstavlja vozaca na trci Formule 1
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Miloševic
 * @version 1.0
 */
public class Vozac {
	/**
	 * Ime vozaca
	 */
	@SerializedName(value = "ime", alternate = "givenName")
	private String ime;
	/**
	 * Prezime vozaca
	 */
	@SerializedName(value = "prezime", alternate = "familyName")
	private String prezime;
	/**
	 * Tim vozaca
	 */
	private String tim;
	/**
	 * Poeni vozaca
	 */
	private int poeni;
	/**
	 * Pobede vozaca
	 */
	private int pobede;
	/**
	 * Poreklo vozaca
	 */
	@SerializedName(value = "drzava", alternate = "nationality")
	private String drzava;
	/**
	 * vraca vrednost atributa ime
	 * @return ime kao String
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Postavlja novu vrednost za ime
	 * 
	 * @param ime nova vrednost za ime vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>null String</li>
	 * 
	 * <li>prazan String</li>
	 * 
	 * </ul>
	 */
	public void setIme(String ime) {
		if(ime == null || ime.equals(""))
			throw new RuntimeException("Nije uneto ime vozaca");
		this.ime = ime;
	}
	/**
	 * vraca vrednost atributa prezime
	 * @return prezime kao String
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Postavlja novu vrednost za prezime
	 * 
	 * @param prezime nova vrednost za prezime vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>null String</li>
	 * 
	 * <li>prazan String</li>
	 * 
	 * </ul>
	 */
	public void setPrezime(String prezime) {
		if(prezime == null || prezime.equals(""))
			throw new RuntimeException("Nije uneto prezime vozaca");
		this.prezime = prezime;
	}
	/**
	 * vraca vrednost atributa tim
	 * @return tim kao String
	 */
	public String getTim() {
		return tim;
	}
	/**
	 * Postavlja novu vrednost za tim
	 * 
	 * @param tim nova vrednost za tim vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>null String</li>
	 * 
	 * <li>prazan String</li>
	 * 
	 * </ul>
	 */
	public void setTim(String tim) {
		if(tim == null || tim.equals(""))
			throw new RuntimeException("Nije uneto ime tima");
		this.tim = tim;
	}
	/**
	 * vraca vrednost atributa poeni
	 * @return poeni kao int
	 */
	public int getPoeni() {
		return poeni;
	}
	/**
	 * Postavlja novu vrednost za poene
	 * 
	 * @param poeni nova vrednost za poene vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>broj manji od nule</li>
	 * 
	 * </ul>
	 */
	public void setPoeni(int poeni) {
		if(poeni < 0)
			throw new RuntimeException("Poeni ne mogu biti negativni brojevi");
		this.poeni = poeni;
	}
	/**
	 * vraca vrednost atributa pobede
	 * @return pobede kao int
	 */
	public int getPobede() {
		return pobede;
	}
	/**
	 * Postavlja novu vrednost za pobede
	 * 
	 * @param pobede nova vrednost za pobede vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>broj manji od nule</li>
	 * 
	 * </ul>
	 */
	public void setPobede(int pobede) {
		if(pobede < 0)
			throw new RuntimeException("Pobede ne mogu biti negativni brojevi");
		this.pobede = pobede;
	}
	/**
	 * vraca vrednost atributa drzava
	 * @return drzava kao String
	 */
	public String getDrzava() {
		return drzava;
	}
	/**
	 * Postavlja novu vrednost za drzavu
	 * 
	 * @param drzava nova vrednost za poreklo vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>null String</li>
	 * 
	 * <li>prazan String</li>
	 * 
	 * </ul>
	 */
	public void setDrzava(String drzava) {
		if(drzava == null || drzava.equals(""))
			throw new RuntimeException("Nije uneto ime drzave");
		this.drzava = drzava;
	}
	/**vraca string koji sadrzi ime i prezime vozaca.
	 * @return podaci o vozacu kao String
	 */
	@Override
	public String toString() {
		return ime+" "+prezime;
	}

	
}