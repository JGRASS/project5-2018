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
		if(nazivTima == null || nazivTima.equals(""))
			throw new RuntimeException("Nije unet naziv tima");
		this.nazivTima = nazivTima;
	}
	public LinkedList<Vozac> getVozaci() {
		return vozaci;
	}
	public void setVozaci(Vozac vozac) {
		if(vozac == null)
			throw new RuntimeException("Nije unet vozac");
		this.vozaci.add(vozac);
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
			throw new RuntimeException("Pobede ne mogu biti vrednost manja od nule");
		this.pobede = pobede;
	}
	@Override
	public String toString() {
		return "Tim [nazivTima=" + nazivTima + ", vozaci=" + vozaci + ", poeni=" + poeni + ", pobede=" + pobede + "]";
	}
	
	
}
