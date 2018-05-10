package gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import domenske_klase.Trka;
import domenske_klase.Vozac;
import models.RezultatTableModel;
import models.TrkeTableModel;
import models.VozaciTableModel;
import sistemski_kontroler.SistemskiKontroler;

public class GUIKontroler {
	public static SistemskiKontroler sistemskiKontroler=new SistemskiKontroler();
	public static GlavniProzor gp;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gp = new GlavniProzor();
					gp.setVisible(true);
					gp.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziSveVozace(LinkedList<Vozac> vozaci) {
		VozaciTableModel model = (VozaciTableModel)(gp.getTableVozaci().getModel());
		model.staviSveVozaceUModel(vozaci);
	}
	
	public static String selektovanoPrezime() {
		if (gp.getTableVozaci().getSelectedRow() != -1) {
			VozaciTableModel model = (VozaciTableModel)(gp.getTableVozaci().getModel());
			return model.vratiSelektovanoPrezime(gp.getTableVozaci().getSelectedRow());
		}
		return "";
	}
	public static void prikaziSveTrke() {
		TrkeTableModel model = (TrkeTableModel)(gp.getTableTrke().getModel());
		try {
			model.staviSveTrkeUModel(SistemskiKontroler.deserijalTrkeIzJson());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void prikaziSveRezultate() throws Exception {
		RezultatTableModel model = (RezultatTableModel)(gp.getTableRezultati().getModel());
		model.staviSveRezultateUModel(SistemskiKontroler.deserijalizacijaRezultataIzJson(selektovanaTrka()));
		
	}
	public static String selektovanaTrka() {
		if (gp.getTableTrke().getSelectedRow() != -1) {
			TrkeTableModel model = (TrkeTableModel)(gp.getTableTrke().getModel());
			return model.vratiSelektovanuTrku(gp.getTableTrke().getSelectedRow());
		}
		return "";
	}

}
