package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.Pol;
import knjige.ZanrKnjige;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ZanroviProzro extends JFrame {
	private DefaultTableModel model;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;
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
			
			if (validacijaBroja(textField.getText()) == true) {
				ZanrKnjige updated = new ZanrKnjige(id, textField_1.getText(), obrisan);
				String[] zaglavlja = new String[] {"OZNAKA", "OPIS ZANRA", "OBRISAN"};
		
				Object[][] sadrzaj1 = new Object[biblioteka.getZanrovi().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < biblioteka.getZanrovi().size(); x++) {
					ZanrKnjige zanr = biblioteka.getZanrovi().get(x);
					sadrzaj1[x][0] = zanr.getId();
					if (updated.getId() == zanr.getId()) {
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
						break;
					}

				}
				if (error != true) {
					biblioteka.addZanr(updated);
					sadrzaj[0] = updated.getId();
					sadrzaj[1] = updated.getOpisZanra();
					biblioteka.snimiZanr();
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
		
		/* OBRISI */
		
		private void deleteRow() {
			try {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowIndex = table.getSelectedRow();
				String selectedID = model.getValueAt(rowIndex, 0).toString();
				int selectedIDint = Integer.parseInt(selectedID);
				ZanrKnjige zanr = biblioteka.getZanr().get(rowIndex);
				zanr.setJeObrisan(true);
				biblioteka.snimiZanr();
				textField.setText("");
				textField_1.setText("");
				
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
		
		/* AZURIRAJ */

		private void updateRow() {
			try {

				String[] zaglavlja = new String[] {"OZNAKA", "OPIS ZANRA", "OBRISAN"};
				Object[][] sadrzaj1 = new Object[biblioteka.getZanrovi().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];
				String ID = textField.getText();
				
				if (validacijaBroja(ID) == true) {
					boolean error = false;
					int id = Integer.parseInt(textField.getText());
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int rowIndex = table.getSelectedRow();
					String selectedID = model.getValueAt(rowIndex, 0).toString();
					int selectedIDint = Integer.parseInt(selectedID);
					boolean obrisan = false;

					ZanrKnjige zanr = biblioteka.getZanrovi().get(rowIndex);
					ZanrKnjige zanr2 = new ZanrKnjige(id, textField_1.getText(), obrisan);

					for (int x = 0; x < biblioteka.getZanrovi().size(); x++) {
						ZanrKnjige current = biblioteka.getZanrovi().get(x);
						if (current.getId() == zanr2.getId()) {
							
							JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
									JOptionPane.WARNING_MESSAGE);
							error = true;
								break;
					
						}

						}

					if (error != true) {

						zanr.setId(id);
						zanr.setOpisZanra(textField_1.getText());

						model.setValueAt(zanr.getId(), rowIndex, 0);
						model.setValueAt(zanr.getOpisZanra(), rowIndex, 1);

						biblioteka.snimiZanr();
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
	public ZanroviProzro(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 684, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//TABELA
		biblioteka.ucitajZanr();
		ArrayList<ZanrKnjige> aktivniZanrovi = new ArrayList<ZanrKnjige>();
		for(ZanrKnjige zanr:biblioteka.getZanrovi()) {
			if(!zanr.isJeObrisan()) {
				aktivniZanrovi.add(zanr);
			}
		}
		String[] zaglavlja = new String[] {"OZNAKA", "OPIS ZANRA", /*"OBRISAN"*/};
		Object[][] sadrzaj = new Object[aktivniZanrovi.size()+1][zaglavlja.length];
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
	//	sadrzaj[0][2] = zaglavlja[2];
		for(int i=0; i<aktivniZanrovi.size(); i++) {
			ZanrKnjige zanr = aktivniZanrovi.get(i);
			sadrzaj[i+1][0] = zanr.getId();
			sadrzaj[i+1][1] = zanr.getOpisZanra();
			//sadrzaj[i+1][2] = zanr.isJeObrisan();
			}
		this.model = new DefaultTableModel(sadrzaj, zaglavlja);
		table = new JTable(this.model);
		
		table.setBounds(10, 11, 320, 239);
		panel.add(table);
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);	
		//////////////////////////////////
		
		lblNewLabel = new JLabel("OZNAKA: ");
		lblNewLabel.setBounds(380, 25, 130, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("OPIS ZANRA:");
		lblNewLabel_1.setBounds(380, 50, 130, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(520, 19, 154, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(520, 44, 154, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		
	
		JButton btnNewButton = new JButton("DODAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_Row();
			}
		});
		btnNewButton.setBounds(483, 102, 119, 40);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });
		btnNewButton_1.setBounds(483, 153, 119, 40);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("UKLONI");
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			deleteRow();
		}
	});
		btnNewButton_2.setBounds(483, 210, 119, 40);
		panel.add(btnNewButton_2);
		
		
		
	}
}
