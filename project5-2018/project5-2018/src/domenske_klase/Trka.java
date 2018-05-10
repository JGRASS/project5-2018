package domenske_klase;

import java.util.LinkedList;

public class Trka {
	private String nazivTrke;
	private String drzava;
	private String datum;
	private int runda;
	private LinkedList<Rezultat> rezultati;
	
	public String getNazivTrke() {
		return nazivTrke;
	}
	public void setNazivTrke(String nazivTrke) {
		if(nazivTrke == null || nazivTrke.equals(""))
			throw new RuntimeException("Nije unet naziv trke");
		this.nazivTrke = nazivTrke;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		if(drzava == null || drzava.equals(""))
			throw new RuntimeException("Nije unet naziv drzave u kojoj se trka odrzava");
		this.drzava = drzava;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		if(datum == null || datum.equals(""))
			throw new RuntimeException("Nije unet datum");
		this.datum = datum;
	}
	public LinkedList<Rezultat> getRezultat() {
		return rezultati;
	}
	public void setRezultat(LinkedList<Rezultat> rezultat) {
		if(rezultati == null)
			throw new RuntimeException("Nije unet rezultat");
		this.rezultati = rezultati;
	}
	public int getRunda() {
		return runda;
	}
	public void setRunda(int runda) {
		if(runda < 1)
			throw new RuntimeException("Runda ne moze biti 0 ili negativan broj");
		this.runda = runda;
	}
	@Override
	public String toString() {
		return "Trka [nazivTrke=" + nazivTrke + ", drzava=" + drzava + ", datum=" + datum + ", runda=" + runda
				+ ", rezultati=" + rezultati + "]";
	}
	
	
	
	
}
