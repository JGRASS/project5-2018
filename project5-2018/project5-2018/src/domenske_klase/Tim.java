package domenske_klase;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class Tim {
	@SerializedName(value="nazivTima", alternate="name")
	private String nazivTima;
	private LinkedList<Vozac> vozaci = new LinkedList<Vozac>();
	private int poeni;
	private int pobede;
	
	public String getNazivTima() {
		return nazivTima;
	}
	public void setNazivTima(String nazivTima) {
		this.nazivTima = nazivTima;
	}
	public LinkedList<Vozac> getVozaci() {
		return vozaci;
	}
	public void setVozaci(Vozac vozac) {
		this.vozaci.add(vozac);
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
	@Override
	public String toString() {
		return "Tim [nazivTima=" + nazivTima + ", vozaci=" + vozaci + ", poeni=" + poeni + ", pobede=" + pobede + "]";
	}
	
	
}
