package domenske_klase;

import java.util.LinkedList;
/**
 * Klasa koja predstavlja trku Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */
public class Trka {
	/**
	 * naziv trke
	 */
	private String nazivTrke;
	/**
	 * naziv drzave u kojoj se odrzava trka
	 */
	private String drzava;
	/**
	 * datum odrzavanja trke
	 */
	private String datum;
	/**
	 * broj runde
	 */
	private int runda;
	/**
	 * lista rezultata trke
	 */
	private LinkedList<Rezultat> rezultati;
	
	/**
	 * vraca vrednost atributa nazivTrke
	 * @return naziv trke kao String
	 */
	public String getNazivTrke() {
		return nazivTrke;
	}
	/**
	 * Postavlja novu vrednost za naziv trke
	 * 
	 * @param nazivTrke nova vrednost za naziv trke
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
	public void setNazivTrke(String nazivTrke) {
		if(nazivTrke == null || nazivTrke.equals(""))
			throw new RuntimeException("Nije unet naziv trke");
		this.nazivTrke = nazivTrke;
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
	 * @param drzava nova vrednost za drzavu 
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
			throw new RuntimeException("Nije unet naziv drzave u kojoj se trka odrzava");
		this.drzava = drzava;
	}
	/**
	 * vraca vrednost atributa datum
	 * @return datum kao String
	 */
	public String getDatum() {
		return datum;
	}
	/**
	 * Postavlja novu vrednost za datum
	 * 
	 * @param datum nova vrednost za datum trke
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
	public void setDatum(String datum) {
		if(datum == null || datum.equals(""))
			throw new RuntimeException("Nije unet datum");
		this.datum = datum;
	}
	
	/*public LinkedList<Rezultat> getRezultat() {
		return rezultati;
	}*/
	
	/*public void setRezultat(LinkedList<Rezultat> rezultat) {
		if(rezultati == null)
			throw new RuntimeException("Nije unet rezultat");
		this.rezultati = rezultati;
	}*/
	/**
	 * vraca vrednost atributa runda
	 * @return runda kao int
	 */
	public int getRunda() {
		return runda;
	}
	/**
	 * Postavlja novu vrednost za rundu
	 * 
	 * @param runda nova vrednost za rundu trke
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>broj manji od 1</li>
	 * 
	 * </ul>
	 */
	public void setRunda(int runda) {
		if(runda < 1)
			throw new RuntimeException("Runda ne moze biti 0 ili negativan broj");
		this.runda = runda;
	}
	/**vraca string koji sadrzi naziv trke,drzavu,datum odrzavanja,rundu i listu rezultata.
	 * @return podaci o trci kao String
	 */
	@Override
	public String toString() {
		return "Trka [nazivTrke=" + nazivTrke + ", drzava=" + drzava + ", datum=" + datum + ", runda=" + runda
				+ ", rezultati=" + rezultati + "]";
	}
	
	
	
	
}
