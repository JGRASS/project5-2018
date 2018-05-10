package models;

import java.awt.List;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import domenske_klase.Trka;
import domenske_klase.Vozac;

public class TrkeTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Naziv", "Drzava", "Datum", "Runda"};
	private LinkedList<Trka> trke = new LinkedList<Trka>();

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return trke.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Trka t = trke.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return t.getNazivTrke();
		case 1:
			return t.getDrzava();
		case 2:
			return t.getDatum();
		case 3:
			return t.getRunda();
		default:
			return "NN";

		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void staviSveTrkeUModel(LinkedList<Trka> trke) {
		this.trke = trke;
		fireTableDataChanged();
	}
	
	public String vratiSelektovanuTrku(int row) {
		return trke.get(row).getNazivTrke();		
	}

}
