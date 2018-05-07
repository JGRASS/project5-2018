package trka;


public class Rezultat {
	private Vozac vozac;
	private String vreme;
	private int mesto;
	public Vozac getVozac() {
		return vozac;
	}
	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}
	
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public int getMesto() {
		return mesto;
	}
	public void setMesto(int mesto) {
		this.mesto = mesto;
	}
	@Override
	public String toString() {
		return "Rezultat [vozac=" + vozac + ", vreme=" + vreme + ", mesto=" + mesto + "]";
	}
}
