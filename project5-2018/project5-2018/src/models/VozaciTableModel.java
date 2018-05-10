package models;

import java.awt.List;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import domenske_klase.Vozac;

public class VozaciTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Ime", "Prezime", "Tim", "Poeni", "Pobede", "Drzava" };
	private LinkedList<Vozac> vozaci = new LinkedList<Vozac>();

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return vozaci.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vozac v = vozaci.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return v.getIme();
		case 1:
			return v.getPrezime();
		case 2:
			return v.getTim();
		case 3:
			return v.getPoeni();
		case 4:
			return v.getPobede();
		case 5:
			return v.getDrzava();
		default:
			return "NN";

		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void staviSveVozaceUModel(LinkedList<Vozac> vozaci) {
		this.vozaci = vozaci;
		fireTableDataChanged();
	}
	
	public String vratiSelektovanoPrezime(int row) {
		Vozac v=vozaci.get(row);
		return v.getPrezime();		
	}
}
