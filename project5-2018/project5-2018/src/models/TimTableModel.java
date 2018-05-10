package models;

import java.awt.List;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import domenske_klase.Tim;
import domenske_klase.Trka;
import domenske_klase.Vozac;

public class TimTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Naziv", "Poeni", "Pobede"};
	private LinkedList<Tim> timovi = new LinkedList<Tim>();

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return timovi.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tim t = timovi.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return t.getNazivTima();
		case 1:
			return t.getPoeni();
		case 2:
			return t.getPobede();
		default:
			return "NN";

		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void staviSveTimoveUModel(LinkedList<Tim> timovi) {
		this.timovi=timovi;
		fireTableDataChanged();
	}
	
	public String vratiSelektovaniTim(int row) {
		return timovi.get(row).getNazivTima();		
	}

}
