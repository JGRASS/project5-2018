package domenske_klase;


public class Rezultat {
	private Vozac vozac;
	private String vreme;
	private int mesto;
	
	public Vozac getVozac() {
		return vozac;
	}
	public void setVozac(Vozac vozac) {
		if(vozac == null)
			throw new RuntimeException("Nije unet vozac");
		this.vozac = vozac;
	}
	
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		if(vreme == null || vreme.equals(""))
			throw new RuntimeException("Nije uneto vreme");
		this.vreme = vreme;
	}
	public int getMesto() {
		return mesto;
	}
	public void setMesto(int mesto) {
		if(mesto < 1)
			throw new RuntimeException("Mesto ne moze biti 0 ili negativan broj");
		this.mesto = mesto;
	}
	@Override
	public String toString() {
		return "Rezultat [vozac=" + vozac + ", vreme=" + vreme + ", mesto=" + mesto + "]";
	}
}
