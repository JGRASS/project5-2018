package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JTextArea;

import domenske_klase.Rezultat;
import domenske_klase.Vozac;
import models.RezultatTableModel;
import models.TimTableModel;
import models.TrkeTableModel;
import models.VozaciTableModel;
import sistemski_kontroler.SistemskiKontroler;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Cursor;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel centralPanel;
	private JPanel southPanel;
	private JButton btnAzuriraj;
	private JLabel lblDatumPoslednjegAzuriranja;
	private JTextField textFieldAzuriranje;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JPanel panelVozaci;
	private JScrollPane scrollPaneVozaci;
	private JTable tableVozaci;
	private LinkedList<Vozac> vozaci;
	private JPanel panelTimovi;
	private JPanel eastPanelVozaci;
	private JButton btnPrikaziVozace;
	private JButton btnRezultati;
	private JButton btnRangiraj;
	private JScrollPane scrollPaneTimovi;
	private JScrollPane scrollPaneRez;
	private JPanel tabRez;
	private JTextArea textAreaRezultati=null;
	private JPanel tabRezSouth;
	private JButton btnZatvoriRez;
	private JPanel panelTrke;
	private JScrollPane scrollPanelTrke;
	private JTable tableTrke;
	private JPanel panelEastTrke;
	private JButton btnPrikaziTrke;
	private JButton btnRezultat;
	private JPanel tabRezTrke;
	private JScrollPane scrollPaneRezTrke;
	private JPanel tabRezTrkeSouth;
	private JButton btnZatvoriRezTrke;
	private JTable tableRezultati;
	private JTable tableTimovi;
	private JPanel panelEastTimovi;
	private JButton btnPrikaziTimove;
	private JButton btnPrikaziVozace_1;

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setTitle("Aplikacija");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getCentralPanel(), BorderLayout.CENTER);
		contentPane.add(getSouthPanel(), BorderLayout.SOUTH);
		
		try {
			// vozaci=GUIKontroler.sistemskiKontroler.deserijalVozaciAPI();
			GUIKontroler.sistemskiKontroler.dodeliVozacimaTimove();
			vozaci = SistemskiKontroler.deserijalVozaceIzJson();
			textFieldAzuriranje.setText(GUIKontroler.sistemskiKontroler.poslednjeAzuriranje());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}

	}

	private JPanel getCentralPanel() {
		if (centralPanel == null) {
			centralPanel = new JPanel();
			centralPanel.setLayout(new BorderLayout(0, 0));
			centralPanel.add(getScrollPane());
		}
		return centralPanel;
	}

	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setPreferredSize(new Dimension(0, 80));
			southPanel.setLayout(null);
			southPanel.add(getBtnAzuriraj());
			southPanel.add(getLblDatumPoslednjegAzuriranja());
			southPanel.add(getTextFieldAzuriranje());
		}
		return southPanel;
	}

	private JButton getBtnAzuriraj() {
		if (btnAzuriraj == null) {
			btnAzuriraj = new JButton("Azuriraj");
			btnAzuriraj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						GUIKontroler.sistemskiKontroler.deserijalRezultateAPI();
						GUIKontroler.sistemskiKontroler.dodajPoeneTimovima();
						GUIKontroler.sistemskiKontroler.dodajPoeneVozacima();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnAzuriraj.setBounds(210, 12, 117, 25);
		}
		return btnAzuriraj;
	}

	private JLabel getLblDatumPoslednjegAzuriranja() {
		if (lblDatumPoslednjegAzuriranja == null) {
			lblDatumPoslednjegAzuriranja = new JLabel("Datum poslednjeg azuriranja:");
			lblDatumPoslednjegAzuriranja.setBounds(29, 49, 226, 15);
		}
		return lblDatumPoslednjegAzuriranja;
	}

	private JTextField getTextFieldAzuriranje() {
		if (textFieldAzuriranje == null) {
			textFieldAzuriranje = new JTextField();
			textFieldAzuriranje.setBorder(null);
			textFieldAzuriranje.setEditable(false);
			textFieldAzuriranje.setBounds(248, 44, 216, 25);
			textFieldAzuriranje.setColumns(10);
		}
		return textFieldAzuriranje;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
		}
		return mnFile;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(null);
			scrollPane.setViewportView(getTabbedPane());
		}
		return scrollPane;
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBorder(null);
			tabbedPane.setPreferredSize(new Dimension(180, 200));
			tabbedPane.addTab("Trke", null, getPanelTrke(), null);
			tabbedPane.addTab("Timovi", null, getPanelTimovi(), null);
			tabbedPane.addTab("Vozaci", null, getPanelVozaci(), null);
		}
		return tabbedPane;
	}

	private JPanel getPanelVozaci() {
		if (panelVozaci == null) {
			panelVozaci = new JPanel();
			panelVozaci.setLayout(new BorderLayout(0, 0));
			panelVozaci.add(getScrollPaneVozaci(), BorderLayout.CENTER);
			panelVozaci.add(getEastPanelVozaci(), BorderLayout.EAST);
		}
		return panelVozaci;
	}

	private JScrollPane getScrollPaneVozaci() {
		if (scrollPaneVozaci == null) {
			scrollPaneVozaci = new JScrollPane();
			scrollPaneVozaci.setViewportView(getTableVozaci());
		}
		return scrollPaneVozaci;
	}

	public JTable getTableVozaci() {
		if (tableVozaci == null) {
			tableVozaci = new JTable();
			tableVozaci.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					btnRezultati.setEnabled(true);

				}
			});
			tableVozaci.setModel(new VozaciTableModel());
			tableVozaci.setShowVerticalLines(false);
			tableVozaci.setShowGrid(false);
			tableVozaci.setShowHorizontalLines(false);
			tableVozaci.getTableHeader().setReorderingAllowed(false);

		}
		return tableVozaci;
	}

	private JPanel getPanelTimovi() {
		if (panelTimovi == null) {
			panelTimovi = new JPanel();
			panelTimovi.setLayout(new BorderLayout(0, 0));
			panelTimovi.add(getPanelEastTimovi(), BorderLayout.EAST);
			panelTimovi.add(getScrollPaneTimovi());
		}
		return panelTimovi;
	}

	private JPanel getEastPanelVozaci() {
		if (eastPanelVozaci == null) {
			eastPanelVozaci = new JPanel();
			eastPanelVozaci.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			eastPanelVozaci.setPreferredSize(new Dimension(150, 100));
			eastPanelVozaci.add(getBtnPrikaziVozace());
			eastPanelVozaci.add(getBtnRangiraj());
			eastPanelVozaci.add(getButtonRezultati());
		}
		return eastPanelVozaci;
	}

	private JButton getBtnPrikaziVozace() {
		if (btnPrikaziVozace == null) {
			btnPrikaziVozace = new JButton("Prikazi vozace");
			btnPrikaziVozace.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPrikaziVozace.setContentAreaFilled(false);
			btnPrikaziVozace.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziSveVozace(vozaci);
				}
			});
		}
		return btnPrikaziVozace;
	}

	private JButton getButtonRezultati() {
		if (btnRezultati == null) {
			btnRezultati = new JButton("Rezultati vozaca");
			btnRezultati.setToolTipText("Prikaz ostvarenih rezultata u trkama za odabranog vozaca");
			btnRezultati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRezultati.setEnabled(false);
			btnRezultati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.addTab("Rezultati " + GUIKontroler.selektovanoPrezime(), getTabRez());
					tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					textAreaRezultati.setText("");
					textAreaRezultati.append("      Trka\t\tVreme\tMesto\n");
					try {
						LinkedList<String> s;
						s = SistemskiKontroler.rezultatiPoVozacu(GUIKontroler.selektovanoPrezime());
						for (int i = 0; i < s.size(); i++) {
							textAreaRezultati.append(s.get(i) + "\n");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			btnRezultati.setContentAreaFilled(false);
		}
		return btnRezultati;
	}

	private JPanel getTabRez() {
		if (tabRez == null) {
			tabRez = new JPanel();
			tabRez.setLayout(new BorderLayout(0, 0));
			tabRez.add(getScrollPaneRez(), BorderLayout.CENTER);
			tabRez.add(getTabRezSouth(), BorderLayout.SOUTH);
		}
		return tabRez;
	}

	private JPanel getTabRezSouth() {
		if (tabRezSouth == null) {
			tabRezSouth = new JPanel();
			tabRezSouth.setLayout(null);
			tabRezSouth.setPreferredSize(new Dimension(100, 50));
			tabRezSouth.add(getBtnZatvoriRez());
		}
		return tabRezSouth;
	}

	private JButton getBtnZatvoriRez() {
		if (btnZatvoriRez == null) {
			btnZatvoriRez = new JButton("Zatvori");
			btnZatvoriRez.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = tabbedPane.getSelectedIndex();
					if (i != -1)
						tabbedPane.remove(i);
				}
			});
			btnZatvoriRez.setBounds(210, 12, 117, 25);
		}
		return btnZatvoriRez;
	}

	private JScrollPane getScrollPaneRez() {
		if (scrollPaneRez == null) {
			scrollPaneRez = new JScrollPane();
			scrollPaneRez.setViewportView(getTextAreaRezultati());
		}
		return scrollPaneRez;
	}

	private JTextArea getTextAreaRezultati() {
		if (textAreaRezultati == null) {
			textAreaRezultati = new JTextArea();
		}
		textAreaRezultati.setEditable(false);
		return textAreaRezultati;
	}

	private JButton getBtnRangiraj() {
		if (btnRangiraj == null) {
			btnRangiraj = new JButton("Rangiraj vozace");
			btnRangiraj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						vozaci = GUIKontroler.sistemskiKontroler.rangListaVozaca();
						GUIKontroler.prikaziSveVozace(vozaci);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnRangiraj.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRangiraj.setContentAreaFilled(false);
		}
		return btnRangiraj;
	}

	private JScrollPane getScrollPaneTimovi() {
		if (scrollPaneTimovi == null) {
			scrollPaneTimovi = new JScrollPane();
			scrollPaneTimovi.setViewportView(getTableTimovi());

		}
		return scrollPaneTimovi;
	}

	private JPanel getPanelTrke() {
		if (panelTrke == null) {
			panelTrke = new JPanel();
			panelTrke.setLayout(new BorderLayout(0, 0));
			panelTrke.add(getScrollPanelTrke(), BorderLayout.CENTER);
			panelTrke.add(getPanelEastTrke(), BorderLayout.EAST);
		}
		return panelTrke;
	}

	private JScrollPane getScrollPanelTrke() {
		if (scrollPanelTrke == null) {
			scrollPanelTrke = new JScrollPane();
			scrollPanelTrke.setViewportView(getTableTrke());
		}
		return scrollPanelTrke;
	}

	public JTable getTableTrke() {
		if (tableTrke == null) {
			tableTrke = new JTable();
			tableTrke.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					btnRezultat.setEnabled(true);

				}
			});
			tableTrke.setModel(new TrkeTableModel());
			tableTrke.setShowVerticalLines(false);
			tableTrke.setShowGrid(false);
			tableTrke.setShowHorizontalLines(false);
			tableTrke.getTableHeader().setReorderingAllowed(false);
		}
		return tableTrke;
	}

	private JPanel getPanelEastTrke() {
		if (panelEastTrke == null) {
			panelEastTrke = new JPanel();
			panelEastTrke.setPreferredSize(new Dimension(150, 0));
			panelEastTrke.setLayout(new FlowLayout());
			panelEastTrke.add(getBtnPrikaziTrke());
			panelEastTrke.add(getBtnRezultat());
		}
		return panelEastTrke;
	}

	private JButton getBtnPrikaziTrke() {
		if (btnPrikaziTrke == null) {
			btnPrikaziTrke = new JButton("Prikazi trke");
			btnPrikaziTrke.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziSveTrke();
				}
			});
			btnPrikaziTrke.setContentAreaFilled(false);
		}
		return btnPrikaziTrke;
	}

	private JButton getBtnRezultat() {
		if (btnRezultat == null) {
			btnRezultat = new JButton("Rezultati trke");
			btnRezultat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.addTab("Rezultati trke " + GUIKontroler.selektovanaTrka(), getTabRezTrke());
					int i = tabbedPane.getTabCount();
					tabbedPane.setSelectedIndex(i - 1);
					try {
						GUIKontroler.prikaziSveRezultate();
					} catch (Exception e1) {
						int t=tabbedPane.getSelectedIndex();
						if(t!=-1) 
							tabbedPane.remove(t);
						tabbedPane.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnRezultat.setEnabled(false);
			btnRezultat.setToolTipText("Prikaz rezultata izabrane trke");
			btnRezultat.setContentAreaFilled(false);
		}
		return btnRezultat;
	}

	private JPanel getTabRezTrke() {
		if (tabRezTrke == null) {
			tabRezTrke = new JPanel();
			tabRezTrke.setLayout(new BorderLayout(0, 0));
			tabRezTrke.add(getScrollPaneRezTrke(), BorderLayout.CENTER);
			tabRezTrke.add(getTabRezTrkeSouth(), BorderLayout.SOUTH);
		}
		return tabRezTrke;
	}

	//
	private JPanel getTabRezTrkeSouth() {
		if (tabRezTrkeSouth == null) {
			tabRezTrkeSouth = new JPanel();
			tabRezTrkeSouth.setLayout(null);
			tabRezTrkeSouth.setPreferredSize(new Dimension(100, 50));
			tabRezTrkeSouth.add(getBtnZatvoriRezTrke());
		}
		return tabRezTrkeSouth;
	}

	private JButton getBtnZatvoriRezTrke() {
		if (btnZatvoriRezTrke == null) {
			btnZatvoriRezTrke = new JButton("Zatvori");
			btnZatvoriRezTrke.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = tabbedPane.getSelectedIndex();
					if (i != -1)
						tabbedPane.remove(i);
				}
			});
			btnZatvoriRezTrke.setBounds(210, 12, 117, 25);
		}
		return btnZatvoriRezTrke;
	}

	private JScrollPane getScrollPaneRezTrke() {
		if (scrollPaneRezTrke == null) {
			scrollPaneRezTrke = new JScrollPane();
			scrollPaneRezTrke.setViewportView(getTableRezultati());
		}
		return scrollPaneRezTrke;
	}

	public JTable getTableRezultati() {
		if (tableRezultati == null) {
			tableRezultati = new JTable();
			tableRezultati.setModel(new RezultatTableModel());
			tableRezultati.setShowVerticalLines(false);
			tableRezultati.setShowGrid(false);
			tableRezultati.setShowHorizontalLines(false);
			tableRezultati.getTableHeader().setReorderingAllowed(false);
		}
		return tableRezultati;
	}
	public JTable getTableTimovi() {
		if (tableTimovi == null) {
			tableTimovi = new JTable();
			tableTimovi.setModel(new TimTableModel());
			tableTimovi.setShowVerticalLines(false);
			tableTimovi.setShowGrid(false);
			tableTimovi.setShowHorizontalLines(false);
			tableTimovi.getTableHeader().setReorderingAllowed(false);
		}
		return tableTimovi;
	}
	private JPanel getPanelEastTimovi() {
		if (panelEastTimovi == null) {
			panelEastTimovi = new JPanel();
			panelEastTimovi.setPreferredSize(new Dimension(150, 0));
			panelEastTimovi.add(getBtnPrikaziTimove());
			panelEastTimovi.add(getBtnPrikaziVozace_1());
		}
		return panelEastTimovi;
	}
	private JButton getBtnPrikaziTimove() {
		if (btnPrikaziTimove == null) {
			btnPrikaziTimove = new JButton("Prikazi timove");
			btnPrikaziTimove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziSveTimove();
				}
			});
			btnPrikaziTimove.setContentAreaFilled(false);
		}
		return btnPrikaziTimove;
	}
	private JButton getBtnPrikaziVozace_1() {
		if (btnPrikaziVozace_1 == null) {
			btnPrikaziVozace_1 = new JButton("Prikazi vozace");
			btnPrikaziVozace_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TimTableModel model=(TimTableModel) tableTimovi.getModel();
					String s=model.vratiSelektovaniTim(tableTimovi.getSelectedRow());
					tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
					tableVozaci.setRowSelectionAllowed(true);
					/////////////////////////////
				}
			});
			btnPrikaziVozace_1.setContentAreaFilled(false);
		}
		return btnPrikaziVozace_1;
	}
}
