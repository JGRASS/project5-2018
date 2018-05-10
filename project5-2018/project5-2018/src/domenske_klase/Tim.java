package domenske_klase;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;
/**
 * Klasa koja predstavlja tim na trci Formule 1
 * @author Monika Milenkovic
 * @author Jelena Milev
 * @author Dusko Milosevic
 * @version 1.0
 */
public class Tim {
	/**
	 * naziv tima
	 */
	@SerializedName(value="nazivTima", alternate="name")
	private String nazivTima;
	/**
	 * lista vozaca tog tima
	 */
	private LinkedList<Vozac> vozaci = new LinkedList<Vozac>();
	/**
	 * poeni tima
	 */
	private int poeni;
	/**
	 * pobede tima
	 */
	private int pobede;
	
	
	/**
	 * vraca vrednost atributa ime
	 * @return ime kao String
	 */
	public String getNazivTima() {
		return nazivTima;
	}
	/**
	 * Postavlja novu vrednost za naziv tima
	 * 
	 * @param nazivTima nova vrednost za naziv tima
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
	public void setNazivTima(String nazivTima) {
		if(nazivTima == null || nazivTima.equals(""))
			throw new RuntimeException("Nije unet naziv tima");
		this.nazivTima = nazivTima;
	}
	/**
	 * vraca listu vozaca tog tima
	 * @return vozaci kao listu
	 */
	public LinkedList<Vozac> getVozaci() {
		return vozaci;
	}
	/**
	 * Dodaje vozaca u listu
	 * 
	 * @param vozac novi element liste vozaci
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>null objekat</li>
	 * 
	 * </ul>
	 */
	public void setVozaci(Vozac vozac) {
		if(vozac == null)
			throw new RuntimeException("Nije unet vozac");
		this.vozaci.add(vozac);
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
	 * @param poeni nova vrednost za poene tima
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
	 * @return poebde kao int
	 */
	public int getPobede() {
		return pobede;
	}
	/**
	 * Postavlja novu vrednost za pobede
	 * 
	 * @param pobede nova vrednost za pobede tima
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
			throw new RuntimeException("Pobede ne mogu biti vrednost manja od nule");
		this.pobede = pobede;
	}
	/**vraca string koji sadrzi za svaki tim njegov naziv,listu vozaca,poene i pobede.
	 * @return podaci o timu kao String
	 */
	@Override
	public String toString() {
		return "Tim [nazivTima=" + nazivTima + ", vozaci=" + vozaci + ", poeni=" + poeni + ", pobede=" + pobede + "]";
	}
	
	
}
