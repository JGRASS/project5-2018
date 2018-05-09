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
		this.nazivTrke = nazivTrke;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public LinkedList<Rezultat> getRezultat() {
		return rezultati;
	}
	public void setRezultat(LinkedList<Rezultat> rezultat) {
		this.rezultati = rezultati;
	}
	public int getRunda() {
		return runda;
	}
	public void setRunda(int runda) {
		this.runda = runda;
	}
	@Override
	public String toString() {
		return "Trka [nazivTrke=" + nazivTrke + ", drzava=" + drzava + ", datum=" + datum + ", runda=" + runda
				+ ", rezultati=" + rezultati + "]";
	}
	
	
	
	
}
