package gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import domenske_klase.Vozac;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziSveVozace(LinkedList<Vozac> vozaci) {
		VozaciTableModel model = (VozaciTableModel)(gp.getTableVozaci().getModel());
		model.staviSveValuteUModel(vozaci);
	}
	
	
		
	


}