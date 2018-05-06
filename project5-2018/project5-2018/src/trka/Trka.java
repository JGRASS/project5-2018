package trka;

public class Trka {
	private String nazivTrke;
	private String drzava;
	private String datum;
	private int runda;
	private Rezultat rezultat;
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
	public Rezultat getRezultat() {
		return rezultat;
	}
	public void setRezultat(Rezultat rezultat) {
		this.rezultat = rezultat;
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
				+ ", rezultat=" + rezultat + "]";
	}
	
	
	
}
