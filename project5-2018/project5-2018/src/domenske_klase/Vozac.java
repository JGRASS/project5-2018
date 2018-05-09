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
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getTim() {
		return tim;
	}
	public void setTim(String tim) {
		this.tim = tim;
	}
	public int getPoeni() {
		return poeni;
	}
	public void setPoeni(int poeni) {
		this.poeni = poeni;
	}
	public int getPobede() {
		return pobede;
	}
	public void setPobede(int pobede) {
		this.pobede = pobede;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	@Override
	public String toString() {
		return "Vozac [ime=" + ime + ", prezime=" + prezime + ", tim=" + tim + ", poeni=" + poeni + ", pobede=" + pobede
				+ ", drzava=" + drzava + "]";
	}
	
}