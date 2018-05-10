package domenske_klase;
/**
 * Klasa koja predstavlja  rezultat za jednog vozaca na trci Formule 1
 * @author Monika Milenkoviæ
 * @author Jelena Milev
 * @author Duško Miloševiæ
 * @version 1.0
 */

public class Rezultat {
	/**
	 * Vozac kao objekat
	 */
	private Vozac vozac;
	/**
	 * vreme voznje na trci
	 */
	private String vreme;
	/**
	 * redni broj na trci
	 */
	private int mesto;
	/**
	 * vraca objekat Vozac
	 * @return Vozac trke 
	 */
	public Vozac getVozac() {
		return vozac;
	}
	/**
	 * Postavlja novog vozaca
	 * 
	 * @param Vozac novi objekat za vozaca
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>null objekat</li>
	 * 
	 * </ul>
	 */
	public void setVozac(Vozac vozac) {
		if(vozac == null)
			throw new RuntimeException("Nije unet vozac");
		this.vozac = vozac;
	}
	/**
	 * vraca vrednost atributa vreme
	 * @return vreme kao String
	 */
	public String getVreme() {
		return vreme;
	}
	/**
	 * Postavlja novu vrednost za vreme
	 * 
	 * @param vreme nova vrednost za vreme vozaca na trci
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
	public void setVreme(String vreme) {
		if(vreme == null || vreme.equals(""))
			throw new RuntimeException("Nije uneto vreme");
		this.vreme = vreme;
	}
	/**
	 * vraca vrednost atributa mesto
	 * @return mesto kao int
	 */
	public int getMesto() {
		return mesto;
	}
	/**
	 * Postavlja novu vrednost za mesto
	 * 
	 * @param mesto nova vrednost za mesto na trci
	 * 
	 * @throws java.lang.RuntimeException ako je 
	 * unet
	 *   <ul> 
	 * 
	 * <li>broj manji od 1</li>
	 * 
	 * </ul>
	 */
	public void setMesto(int mesto) {
		if(mesto < 1)
			throw new RuntimeException("Mesto ne moze biti 0 ili negativan broj");
		this.mesto = mesto;
	}
	/**vraca string koji sadrzi rezultat na trci jednog vozaca, mesto i vreme na trci.
	 * @return podaci o rezultatu kao String
	 */
	@Override
	public String toString() {
		return "Rezultat [vozac=" + vozac + ", vreme=" + vreme + ", mesto=" + mesto + "]";
	}
}
