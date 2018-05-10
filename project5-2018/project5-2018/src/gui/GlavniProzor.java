package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import domenske_klase.Vozac;
import models.VozaciTableModel;
import sistemski_kontroler.SistemskiKontroler;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.AbstractListModel;


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
	private JTextArea textAreaRezultati;
	private JPanel tabRezSouth;
	private JButton btnZatvoriRez;
	

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
			vozaci = GUIKontroler.sistemskiKontroler.deserijalVozaceIzJson();

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
			panelTimovi.add(getScrollPaneTimovi(), BorderLayout.CENTER);
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
			btnRezultati = new JButton("Rezultati");
			btnRezultati.setToolTipText("Prikaz dostignuca po trkama za odabranog vozaca");
			btnRezultati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRezultati.setEnabled(false);
			btnRezultati.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.addTab("Rezultati "+GUIKontroler.selektovanoPrezime(), getTabRez());
					tabbedPane.setSelectedIndex(2);

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
					int i=tabbedPane.getSelectedIndex();
					if(i!=-1)
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
			textAreaRezultati.append("      Trka\t\tVreme\tMesto\n");
			LinkedList<String> s;
			try {
				s = SistemskiKontroler.rezultatiPoVozacu(GUIKontroler.selektovanoPrezime());
				for (int i = 0; i < s.size(); i++) {
					textAreaRezultati.append(s.get(i)+"\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
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

		}
		return scrollPaneTimovi;
	}

	
}
