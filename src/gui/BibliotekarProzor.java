package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.Pol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BibliotekarProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField; 
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	private Biblioteka biblioteka;
	
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
			boolean obrisan = false;
			double plata = Double.parseDouble(textField_8.getText());


			Pol polovi = Pol.valueOf(textField_5.getText());
			if (validacijaBroja(textField.getText()) == true) {
				Bibliotekar updated = new Bibliotekar(id, textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(), polovi, textField_6.getText(),
						textField_7.getText(), plata, obrisan);
				String[] zaglavlja = new String[] {"ID", "IME", "PREZIME","JMBG", "ADRESA", "POL","KORISNICKO IME","KORISNICKA SIFRA", "PLATA"};

				
				Object[][] sadrzaj1 = new Object[biblioteka.getBibliotekari().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];
				
				for (int x = 0; x < biblioteka.getBibliotekari().size(); x++) {
					Bibliotekar nisamKreativan = biblioteka.getBibliotekari().get(x);
					sadrzaj1[x][0] = nisamKreativan.getId();
					if (updated.getId() == nisamKreativan.getId()) {
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
						break;
					}

				}
				if (error != true) {
					biblioteka.addBibliotekar(updated);
					sadrzaj[0] = updated.getId();
					sadrzaj[1] = updated.getIme();
					sadrzaj[2] = updated.getPrezime();
					sadrzaj[3] = updated.getJMBG();
					sadrzaj[4] = updated.getAdresa();
					sadrzaj[5] = updated.getPol();
					sadrzaj[6] = updated.getKorisnickoIme();
					sadrzaj[7] = updated.getKorisnickaSifra();
					sadrzaj[8] = updated.getPlata();
					
					biblioteka.snimiBibliotekari();
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
	
	/* AZURIRAJ */

	private void updateRow() {
		try {

			String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Korisnicko Ime", "Korisnicka Sifra",
					"Plata"};
			Object[][] sadrzaj1 = new Object[biblioteka.getBibliotekari().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textField.getText();
			
			if (validacijaBroja(ID) == true) {
				boolean error = false;
				int id = Integer.parseInt(textField.getText());
				double textPlataDouble = Double.parseDouble(textField_8.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowIndex = table.getSelectedRow();
				String selectedID = model.getValueAt(rowIndex, 0).toString();
				int selectedIDint = Integer.parseInt(selectedID);
				
				Pol pol = Pol.valueOf(textField_5.getText());
				boolean obrisan = false;

				Bibliotekar bibliotekarcina = biblioteka.getBibliotekari().get(rowIndex);
				Bibliotekar bibliotekarcina2 = new Bibliotekar(id, textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(), pol, textField_6.getText(),
						textField_7.getText(), textPlataDouble, obrisan);

				for (int x = 0; x < biblioteka.getBibliotekari().size(); x++) {
					Bibliotekar current = biblioteka.getBibliotekari().get(x);
					if (current.getId() == bibliotekarcina2.getId()) {						
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
							break;				
					}
				}

				if (error != true) {

					bibliotekarcina.setId(id);
					bibliotekarcina.setIme(textField_1.getText());
					bibliotekarcina.setPrezime(textField_2.getText());
					bibliotekarcina.setJMBG(textField_3.getText());
					bibliotekarcina.setAdresa(textField_4.getText());
					bibliotekarcina.setPol(pol);
					bibliotekarcina.setKorisnickoIme(textField_6.getText());
					bibliotekarcina.setKorisnickaSifra(textField_7.getText());
					bibliotekarcina.setPlata(textPlataDouble);


					model.setValueAt(bibliotekarcina.getId(), rowIndex, 0);
					model.setValueAt(bibliotekarcina.getIme(), rowIndex, 1);
					model.setValueAt(bibliotekarcina.getPrezime(), rowIndex, 2);
					model.setValueAt(bibliotekarcina.getJMBG(), rowIndex, 3);
					model.setValueAt(bibliotekarcina.getAdresa(), rowIndex, 4);
					model.setValueAt(bibliotekarcina.getPol(), rowIndex, 5);
					model.setValueAt(bibliotekarcina.getKorisnickoIme(), rowIndex, 6);
					model.setValueAt(bibliotekarcina.getKorisnickaSifra(), rowIndex, 7);
					model.setValueAt(bibliotekarcina.getPlata(), rowIndex, 8);

					biblioteka.snimiBibliotekari();
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
			Bibliotekar bibliotekarcina = biblioteka.getBibliotekari1().get(rowIndex);
			bibliotekarcina.setJeObrisan(true);
			biblioteka.snimiAdministratore();
			
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			textField_8.setText("");
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
	
	
	public BibliotekarProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka; 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 684, 511);
		contentPane.add(panel);
		panel.setLayout(null);		
		
		//tabela za bibliotekare 
		ArrayList<Bibliotekar> aktivniBibliotekari = new ArrayList<Bibliotekar>();
		for(Bibliotekar bibliotekar:biblioteka.getBibliotekari()) {
			if(!bibliotekar.isJeObrisan()) {
				aktivniBibliotekari.add(bibliotekar);
			}
		}
		String[] zaglavlja = new String[] {"ID", "IME", "PREZIME", "JMBG", "ADRESA", "POL", "KORISNICKO IME", "KORISNICKA SIFRA", "PLATA"};
		Object[][] sadrzaj = new Object[aktivniBibliotekari.size()+1][zaglavlja.length];
				
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
		sadrzaj[0][2] = zaglavlja[2];
		sadrzaj[0][3] = zaglavlja[3];
		sadrzaj[0][4] = zaglavlja[4];
		sadrzaj[0][5] = zaglavlja[5];
		sadrzaj[0][6] = zaglavlja[6];
		sadrzaj[0][7] = zaglavlja[7];
		sadrzaj[0][8] = zaglavlja[8];
		for(int i=0; i<aktivniBibliotekari.size(); i++) {
			Bibliotekar bibliotekar = aktivniBibliotekari.get(i);
			sadrzaj[i+1][0] = bibliotekar.getId();
			sadrzaj[i+1][1] = bibliotekar.getIme();
			sadrzaj[i+1][2] = bibliotekar.getPrezime();
			sadrzaj[i+1][3] = bibliotekar.getJMBG();
			sadrzaj[i+1][4] = bibliotekar.getAdresa();
			sadrzaj[i+1][5] = bibliotekar.getPol();
			sadrzaj[i+1][6] = bibliotekar.getKorisnickoIme();
			sadrzaj[i+1][7] = bibliotekar.getKorisnickaSifra();
			sadrzaj[i+1][8] = String.valueOf(bibliotekar.getPlata());
		}

		this.model = new DefaultTableModel(sadrzaj, zaglavlja);
		table = new JTable(this.model);
		table.setBounds(10, 11, 350, 489);
		panel.add(table);
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);	
	/////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(370, 36, 100, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IME:");
		lblNewLabel_1.setBounds(370, 61, 100, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PREZIME:");
		lblNewLabel_2.setBounds(370, 86, 100, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("JMBG:");
		lblNewLabel_3.setBounds(370, 111, 100, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADRESA:");
		lblNewLabel_4.setBounds(370, 136, 100, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("POL:");
		lblNewLabel_5.setBounds(370, 161, 100, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("KORISNICKO IME:");
		lblNewLabel_6.setBounds(370, 186, 100, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("KORISNICKA SIFRA:");
		lblNewLabel_7.setBounds(370, 211, 100, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PLATA:");
		lblNewLabel_8.setBounds(370, 236, 100, 14);
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(480, 30, 182, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(480, 55, 182, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(480, 80, 182, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(480, 105, 182, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(480, 130, 182, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(480, 155, 182, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(480, 180, 182, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(480, 205, 182, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(480, 230, 182, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("UKLONI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnNewButton.setBounds(435, 421, 182, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		 btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateRow();
	            }
	        });
		btnNewButton_1.setBounds(435, 358, 182, 52);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_Row();
			}
		});
		btnNewButton_2.setBounds(435, 295, 182, 52);
		panel.add(btnNewButton_2);
		

		
		
	}

}
