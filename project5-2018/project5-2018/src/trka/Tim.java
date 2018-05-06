package trka;

import java.util.LinkedList;

public class Tim {
	private String nazivTima;
	private LinkedList<Vozac> vozaci;
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
	public void setVozaci(LinkedList<Vozac> vozaci) {
		this.vozaci = vozaci;
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
