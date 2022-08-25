package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.ClanBiblioteke;
import Osobe.Pol;
import Osobe.TipClanarine;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ClanProzor extends JFrame {
	private Biblioteka biblioteka;
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel; //----> ID
	private JLabel lblNewLabel_1; //----> IME
	private JLabel lblNewLabel_2; //----> PREZIME
	private JLabel lblNewLabel_3; //----> JMBG
	private JLabel lblNewLabel_4; //----> ADRESA
	private JLabel lblNewLabel_5; //----> POL
	private JLabel lblNewLabel_6; //----> BROJ CLANSKE KARTE
	private JLabel lblNewLabel_7; //----> TIP CLANARINE ?
	private JLabel lblNewLabel_8; //----> DATUM POSLEDNJE UPLATE
	private JLabel lblNewLabel_9; //----> BROJ MESECI CLANARINE
	//private JLabel lblNewLabel_10; //----> AKTIVNOST
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/* DODAJ */
	public static boolean validacijaBroja(String str) { 
        try { 
                Integer.parseInt(str); 
                return true; 
        } catch (NumberFormatException e) { 
                JOptionPane.showMessageDialog(null, "ID mora biti broj", "Error", JOptionPane.WARNING_MESSAGE); 
                return false; 
        } 
}
	
	private void add_Row() {
		try {
			boolean error = false;
			int id = Integer.parseInt(textField.getText());
			int brojMeseciClanarine = Integer.parseInt(textField_9.getText());
			boolean obrisan = false;
			boolean isActive = false;
			LocalDate datum = LocalDate.parse(textField_8.getText());
			int jedanTip = Integer.parseInt(textField_7.getText());
			TipClanarine clanarina = null;
			
			for(TipClanarine clanarine : biblioteka.getTipovi()) {
				if(clanarine.getId() == (jedanTip)) {
					clanarina = clanarine ;
				}
			}
			
			Pol polovi = Pol.valueOf(textField_5.getText());
			if (validacijaBroja(textField.getText()) == true) {
				
				ClanBiblioteke updated = new ClanBiblioteke(id, textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(), polovi, textField_6.getText(),
						clanarina, datum, brojMeseciClanarine, isActive, obrisan);
				String[] zaglavlja = new String[] {"ID", "IME", "PREZIME", "JMBG", "ADRESA", "POL", "BROJ CK", "TIP CL", "DATUM","BR MSC","AKTIV","OBRISAN"};

				
				Object[][] sadrzaj1 = new Object[biblioteka.getClanovi().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];
				
				for (int x = 0; x < biblioteka.getClanovi().size(); x++) {
					ClanBiblioteke clan = biblioteka.getClanovi().get(x);
					sadrzaj1[x][0] = clan.getId();
					if (updated.getId() == clan.getId()) {
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
						break;
					}

				}
				if (error != true) {
					double cena = nadjiCenu(clanarina, brojMeseciClanarine);
					System.out.println(cena);
					JOptionPane.showMessageDialog(null, "Treba da uplatite "+ cena, "Racun", JOptionPane.INFORMATION_MESSAGE);
					biblioteka.addClan(updated);
					biblioteka.snimiClanove();
					sadrzaj[0] = updated.getId();
					sadrzaj[1] = updated.getIme();
					sadrzaj[2] = updated.getPrezime();
					sadrzaj[3] = updated.getJMBG();
					sadrzaj[4] = updated.getAdresa();
					sadrzaj[5] = updated.getPol();
					sadrzaj[6] = updated.getBrClanKarte();
					sadrzaj[7] = updated.getTipclanarine().getId();
					sadrzaj[8] = updated.getDatumPoslednjeUplate();
					sadrzaj[9] = updated.getBrojMeseciClanarine();
					sadrzaj[10] = updated.isActive();
					sadrzaj[11] = updated.isJeObrisan();
					
					biblioteka.snimiClanove();
					model.addRow(sadrzaj);
					table.setModel(model);

				}
			}
		}
		 catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Uneli ste slovo u input polje za broj", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}

	
///////////////////////////METODA ZA TRAZENJE CENE I ZADATAK ZA DESET/////////////////////////////////////////////
	
		public static double nadjiCenu(TipClanarine clanarina, int brojMeseciClanarine) {
        double pocetnaCena = clanarina.getCena();
        double popust = 0;

        if (brojMeseciClanarine >= 6) {
            if (brojMeseciClanarine >= 12) {
                popust = 20;
            } else {
                popust = 10;
            }            
        }

        double cena = ((pocetnaCena * brojMeseciClanarine) * ((100 - popust )/ 100));
        return Math.round(cena);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	/* AZURIRAJ */

	private void updateRow() {
		try {

			String[] zaglavlja = new String[] {"ID", "IME", "PREZIME", "JMBG", "ADRESA", "POL", "BROJ CK", "TIP CL", "DATUM","BR MSC","AKTIV","OBRISAN"};
			Object[][] sadrzaj1 = new Object[biblioteka.getClanovi().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textField.getText();
			
			if (validacijaBroja(ID) == true) {
				boolean error = false;
				int id = Integer.parseInt(textField.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowIndex = table.getSelectedRow();
				String selectedID = model.getValueAt(rowIndex, 0).toString();
				int selectedIDint = Integer.parseInt(selectedID);				
				Pol pol = Pol.valueOf(textField_5.getText());
				boolean obrisan = false;
				int brojMeseciClanarine = Integer.parseInt(textField_9.getText());
				boolean isActive = false;
				LocalDate datum = LocalDate.parse(textField_8.getText());
				int jedanTip = Integer.parseInt(textField_7.getText());
				TipClanarine clanarina = null;
				
				for(TipClanarine clanarine : biblioteka.getTipovi()) {
					if (clanarine.getId() == (jedanTip)) {
						clanarina = clanarine ;
					}
				}
								
				ClanBiblioteke clan = biblioteka.getClanovi().get(rowIndex);
				ClanBiblioteke clan2 = new ClanBiblioteke (id, textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(), pol, textField_6.getText(),
						clanarina, datum, brojMeseciClanarine, isActive, obrisan);
				
				for (int x = 0; x < biblioteka.getClanovi().size(); x++) {
					ClanBiblioteke current = biblioteka.getClanovi().get(x);
					if (current.getId() == clan2.getId()) {						
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
							break;				
					}
				}

				if (error != true) {
					double cena = nadjiCenu(clanarina, brojMeseciClanarine);
					System.out.println(cena);
					JOptionPane.showMessageDialog(null, "Treba da uplatite "+ cena, "Racun", JOptionPane.INFORMATION_MESSAGE);
					
					clan.setId(id);
					clan.setIme(textField_1.getText());
					clan.setPrezime(textField_2.getText());
					clan.setJMBG(textField_3.getText());
					clan.setAdresa(textField_4.getText());
					clan.setPol(pol);
					clan.setBrClanKarte(textField_6.getText());
					clan.setTipclanarine(clanarina);
					clan.setDatumPoslednjeUplate(datum);
					clan.setBrojMeseciClanarine(brojMeseciClanarine);
					clan.setActive(isActive);
					
					model.setValueAt(clan.getId(), rowIndex, 0);
					model.setValueAt(clan.getIme(), rowIndex, 1);
					model.setValueAt(clan.getPrezime(), rowIndex, 2);
					model.setValueAt(clan.getJMBG(), rowIndex, 3);
					model.setValueAt(clan.getAdresa(), rowIndex, 4);
					model.setValueAt(clan.getPol(), rowIndex, 5);
					model.setValueAt(clan.getBrClanKarte(), rowIndex, 6);
					model.setValueAt(clan.getTipclanarine().getId(), rowIndex, 7);
					model.setValueAt(clan.getDatumPoslednjeUplate(), rowIndex, 8);
					model.setValueAt(clan.getBrojMeseciClanarine(), rowIndex, 9);
					model.setValueAt(clan.isActive(), rowIndex, 10);
					
					biblioteka.snimiClanove();
					model.fireTableRowsInserted(rowIndex, selectedIDint);
					table.setModel(model);
					model.fireTableDataChanged();
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Unesite broj kao input", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
/* OBRISI */
	
	private void deleteRow() {
		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			String selectedID = model.getValueAt(rowIndex, 0).toString();
			int selectedIDint = Integer.parseInt(selectedID);
			ClanBiblioteke clan = biblioteka.get_Clan().get(rowIndex);
			clan.setJeObrisan(true);
			biblioteka.snimiClanove();;;
			
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			textField_8.setText("");
			textField_9.setText("");
			
			model.removeRow(selectedIDint);
			table.setModel(model);
			model.fireTableDataChanged();

		}catch(ArrayIndexOutOfBoundsException x) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska" + e, "Greska", JOptionPane.WARNING_MESSAGE);
		}
		}

	public ClanProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka; 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 360, 489);
		contentPane.add(panel);
	/////TABELA
		ArrayList<ClanBiblioteke> aktivniClanovi = new ArrayList<ClanBiblioteke>();
		
		for(ClanBiblioteke clan:biblioteka.getClanovi()) {
			if(!clan.isJeObrisan()) {
				aktivniClanovi.add(clan);
			}
		}
		String[] zaglavlja = new String[] {"ID", "IME", "PREZIME", "JMBG", "ADRESA", "POL", "BROJ CK", "TIP CL", "DATUM","BR MSC","AKTIV","OBRISAN"};
		Object[][] sadrzaj = new Object[aktivniClanovi.size()+1][zaglavlja.length];
		
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
		sadrzaj[0][2] = zaglavlja[2];
		sadrzaj[0][3] = zaglavlja[3];
		sadrzaj[0][4] = zaglavlja[4];
		sadrzaj[0][5] = zaglavlja[5];
		sadrzaj[0][6] = zaglavlja[6];
		sadrzaj[0][7] = zaglavlja[7];
		
		for(int i=0; i<aktivniClanovi.size(); i++) {
			ClanBiblioteke clan = aktivniClanovi.get(i);
			sadrzaj[i+1][0] = clan.getId();
			sadrzaj[i+1][1] = clan.getIme();
			sadrzaj[i+1][2] = clan.getPrezime();
			sadrzaj[i+1][3] = clan.getJMBG();
			sadrzaj[i+1][4] = clan.getAdresa();
			sadrzaj[i+1][5] = clan.getPol();
			sadrzaj[i+1][6] = clan.getBrClanKarte();
			sadrzaj[i+1][7] = clan.getTipclanarine().getId();
			sadrzaj[i+1][8] = clan.getDatumPoslednjeUplate();
			sadrzaj[i+1][9] = clan.getBrojMeseciClanarine();
			sadrzaj[i+1][10] = clan.isActive();
			sadrzaj[i+1][11] = clan.isJeObrisan();	
			biblioteka.ucitajClanarinu();
		}
		
		
		this.model = new DefaultTableModel(sadrzaj, zaglavlja);
		table = new JTable(this.model);

		table.setBounds(10, 11, 350, 489);
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		panel.add(table);
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);	
		
	//////////////////////////////
		lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(380, 20, 150, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("IME:");
		lblNewLabel_1.setBounds(380, 45, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("PREZIME:");
		lblNewLabel_2.setBounds(380, 70, 150, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("JMBG:");
		lblNewLabel_3.setBounds(380, 95, 150, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("ADRESA:");
		lblNewLabel_4.setBounds(380, 120, 150, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("POL:");
		lblNewLabel_5.setBounds(380, 145, 150, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("BROJ CLANSKE KARTE:");
		lblNewLabel_6.setBounds(380, 170, 150, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("TIP CLANARINE:");
		lblNewLabel_7.setBounds(380, 195, 150, 14);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("DATUM POSLEDNJE UPLATE:");
		lblNewLabel_8.setBounds(380, 220, 150, 14);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("BROJ MESECI CLANARINE:");
		lblNewLabel_9.setBounds(380, 245, 150, 14);
		contentPane.add(lblNewLabel_9);
		
//		lblNewLabel_10 = new JLabel("AKTIVNOST:");
//		lblNewLabel_10.setBounds(380, 270, 150, 14);
//		contentPane.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(540, 20, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(540, 42, 134, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(540, 67, 134, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(540, 92, 134, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(540, 117, 134, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(540, 142, 134, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(540, 167, 134, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(540, 192, 134, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(540, 217, 134, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(540, 242, 134, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
//		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
//		rdbtnNewRadioButton.setToolTipText("");
//		rdbtnNewRadioButton.setBounds(540, 270, 134, 20);
//		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("UKLONI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnNewButton.setBounds(434, 434, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	updateRow();
	            }
	        });
		btnNewButton_1.setBounds(434, 371, 182, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					add_Row();
			}
		});
		btnNewButton_2.setBounds(434, 308, 182, 52);
		contentPane.add(btnNewButton_2);
	}

}

