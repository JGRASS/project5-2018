package domenske_klase;

import com.google.gson.annotations.SerializedName;

public class Vozac {
	@SerializedName(value = "ime", alternate = "givenName")
	private String ime;
	@SerializedName(value = "prezime", alternate = "familyName")
	private String prezime;
	private String tim;
	private int poeni;
	private int pobede;
	@SerializedName(value = "drzava", alternate = "nationality")
	private String drzava;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(ime == null || ime.equals(""))
			throw new RuntimeException("Nije uneto ime vozaca");
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if(prezime == null || prezime.equals(""))
			throw new RuntimeException("Nije uneto prezime vozaca");
		this.prezime = prezime;
	}
	public String getTim() {
		return tim;
	}
	public void setTim(String tim) {
		if(tim == null || tim.equals(""))
			throw new RuntimeException("Nije uneto ime tima");
		this.tim = tim;
	}
	public int getPoeni() {
		return poeni;
	}
	public void setPoeni(int poeni) {
		if(poeni < 0)
			throw new RuntimeException("Poeni ne mogu biti negativni brojevi");
		this.poeni = poeni;
	}
	public int getPobede() {
		return pobede;
	}
	public void setPobede(int pobede) {
		if(pobede < 0)
			throw new RuntimeException("Pobede ne mogu biti negativni brojevi");
		this.pobede = pobede;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		if(drzava == null || drzava.equals(""))
			throw new RuntimeException("Nije uneto ime drzave");
		this.drzava = drzava;
	}
	@Override
	public String toString() {
		return ime+" "+prezime;
	}
	
}
