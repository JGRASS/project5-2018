package models;

import java.awt.List;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import domenske_klase.Rezultat;
import domenske_klase.Trka;
import domenske_klase.Vozac;

public class RezultatTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Vozac", "Vreme", "Mesto" };
	private LinkedList<Rezultat> rezultati = new LinkedList<Rezultat>();

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return rezultati.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Rezultat r = rezultati.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return r.getVozac();
		case 1:
			return r.getVreme();
		case 2:
			return r.getMesto();
		default:
			return "NN";

		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void staviSveRezultateUModel(LinkedList<Rezultat> rez) throws Exception {
		if (rez.isEmpty()) throw new RuntimeException("Trka se jos uvek nije odžala!");
			this.rezultati = rez;
			fireTableDataChanged();
		
	}

}
