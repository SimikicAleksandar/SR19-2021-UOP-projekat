package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import knjige.Knjiga;
import knjige.PrimerakKnjige;
import knjige.TipPoveza;

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

public class PrimerakKnjigeProzor extends JFrame {

	private DefaultTableModel model;
	private JPanel contentPane;
	private JLabel lblNewLabel; 
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField; 	// ------------> "ID: "
	private JTextField textField_1; // ------------> "ID KNJIGE: "
	private JTextField textField_2; // ------------> "BROJ STRANA: "
	private JTextField textField_3; // ------------> "POVEZ"
	private JTextField textField_4; // ------------> "JEZIK STAMPANJA: "
	private JTextField textField_5; // ------------> "GODINA:"
	private JTextField textField_6; // ------------> "IZNAJMLJENA:"
	private JTable table;
	private Biblioteka biblioteka;
	
	
	/* Validacija broja */

	public static boolean validacijaBroja(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Id mora biti broj", "Greska", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
	/* DODAJ */
	private void add_Row() {
		try {			
			if (validacijaBroja("5") == true){
				boolean error = false;
				int id = Integer.parseInt(textField.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int godina = Integer.parseInt(textField_5.getText());
				TipPoveza tip = TipPoveza.valueOf(textField_3.getText());
				int idknjige = Integer.parseInt(textField_1.getText());
				int brstrana = Integer.parseInt(textField_2.getText());
				boolean iznajmljena = false;
				boolean obrisan = false;
				Knjiga trazenaKnjiga = null;
				for(Knjiga primerak : this.biblioteka.getKnjige()) {
					if (primerak.getId() == (idknjige)) {
						trazenaKnjiga = primerak;
					}
				}
				PrimerakKnjige knjiga2 = new PrimerakKnjige(id, trazenaKnjiga, brstrana,
						tip, textField_4.getText(), godina, iznajmljena, obrisan);

				String[] zaglavlja = new String[] {"ID",  "ID KNJIGE", "BR STRANA", "POVEZ", "JEZIK", "GODINA", "IZNAJMLJENA" };
				Object[][] sadrzaj1 = new Object[biblioteka.getPrimerciKnjiga().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];

				for (int x = 0; x < biblioteka.getPrimerciKnjiga().size(); x++) {
					PrimerakKnjige knjiga = biblioteka.getPrimerciKnjiga().get(x);
					sadrzaj1[x][0] = knjiga.getId();
					if (sadrzaj1[x][0].equals(textField.getText())) {
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
						break;
					}

				}
				if (error != true) {
					biblioteka.addPrimer(knjiga2);
					biblioteka.snimiPrimerakKnjige();

					sadrzaj[0] = knjiga2.getId();
					sadrzaj[1] = knjiga2.getKnjige().getId();
					sadrzaj[2] = knjiga2.getBrStrana();
					sadrzaj[3] = knjiga2.getTip();
					sadrzaj[4] = knjiga2.getJezikStampanja();
					sadrzaj[5] = knjiga2.getGodinaStampanja();
					sadrzaj[6] = knjiga2.isDaLiJeIznajmljena();

					biblioteka.snimiPrimerakKnjige();
					model.addRow(sadrzaj);
					table.setModel(model);
				}
			}
		} catch (NumberFormatException x) {
			System.out.println(x);
			JOptionPane.showMessageDialog(null, "Uneli ste slovo u polje za broj", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/* AZURIRAJ */

	private void updateRow() {
		try {

			String[] zaglavlja = new String[] {"ID",  "ID KNJIGE", "BR STRANA", "POVEZ", "JEZIK", "GODINA", "IZNAJMLJENA" };
			Object[][] sadrzaj1 = new Object[biblioteka.getPrimerciKnjiga().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String ID = textField.getText();

			if (validacijaBroja(ID) == true) {
				boolean error = false;
				int id = Integer.parseInt(textField.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowIndex = table.getSelectedRow();
				String selectedID = model.getValueAt(rowIndex, 0).toString();
				int selectedIDint = Integer.parseInt(selectedID);
				int godina = Integer.parseInt(textField_5.getText());
				TipPoveza tip = TipPoveza.valueOf(textField_3.getText());
				int idknjige = Integer.parseInt(textField_1.getText());
				int brstrana = Integer.parseInt(textField_2.getText());
				boolean iznajmljena = false;
				boolean obrisan = false;
				Knjiga trazenaKnjiga = null;
				for(Knjiga primerak : this.biblioteka.getKnjige()) {
					if (primerak.getId() == (idknjige)) {
						trazenaKnjiga = primerak;
					}
				}
					
				PrimerakKnjige knjiga = biblioteka.getPrimerciKnjiga().get(rowIndex);
				PrimerakKnjige knjiga2 = new PrimerakKnjige(id, trazenaKnjiga, brstrana,
						tip, textField_4.getText(), godina, iznajmljena, obrisan);

				if (error != true) {

					knjiga.setId(id);
					knjiga.setKnjige(trazenaKnjiga);
					knjiga.setBrStrana(brstrana);
					knjiga.setTip(tip);
					knjiga.setJezikStampanja(textField_4.getText());
					knjiga.setGodinaStampanja(godina);
					knjiga.setDaLiJeIznajmljena(iznajmljena);

					model.setValueAt(knjiga.getId(), rowIndex, 0);
					model.setValueAt(knjiga.getKnjige().getId(), rowIndex, 1);
					model.setValueAt(knjiga.getBrStrana(), rowIndex, 2);
					model.setValueAt(knjiga.getTip(), rowIndex, 3);
					model.setValueAt(knjiga.getJezikStampanja(), rowIndex, 4);
					model.setValueAt(knjiga.getGodinaStampanja(), rowIndex, 5);
					model.setValueAt(knjiga.isDaLiJeIznajmljena(), rowIndex, 6);

					biblioteka.snimiPrimerakKnjige();
					model.fireTableRowsInserted(rowIndex, selectedIDint);
					table.setModel(model);
					model.fireTableDataChanged();
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Mozete uneti samo broj za input", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/* DELETE */

	private void deleteRow() {
		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			String selectedID = model.getValueAt(rowIndex, 0).toString();
			int selectedIDint = Integer.parseInt(selectedID);
			PrimerakKnjige knjiga = biblioteka.getPrimerciKnjiga().get(rowIndex);
			knjiga.setJeObrisan(true);
			biblioteka.snimiAdministratore();

			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");

			model.removeRow(selectedIDint);
			table.setModel(model);
			model.fireTableDataChanged();
		} catch (ArrayIndexOutOfBoundsException x) {
			JOptionPane.showMessageDialog(null, "Izaberi red", "Greska", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska" + e, "Greska", JOptionPane.WARNING_MESSAGE);
		}
	}

	
	public PrimerakKnjigeProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka; 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		getContentPane().setBackground(new Color(192,192,192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TABELA

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 360, 489);
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		
		biblioteka.ucitajKnjige();
		ArrayList<PrimerakKnjige> aktivniPrimerci = new ArrayList<PrimerakKnjige>();
		for(PrimerakKnjige primerak:biblioteka.getPrimerciKnjiga()) {
			if(!primerak.isJeObrisan()) {
				aktivniPrimerci.add(primerak);
			}
		}
		
		String[] zaglavlja = new String[] {"ID",  "ID KNJIGE", "BR STRANA", "POVEZ", "JEZIK", "GODINA", "IZNAJMLJENA" };
		Object[][] sadrzaj = new Object[aktivniPrimerci.size()+1][zaglavlja.length];
		
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
		sadrzaj[0][2] = zaglavlja[2];
		sadrzaj[0][3] = zaglavlja[3];
		sadrzaj[0][4] = zaglavlja[4];
		sadrzaj[0][5] = zaglavlja[5];
		sadrzaj[0][6] = zaglavlja[6];
		
		for(int i=0; i<aktivniPrimerci.size(); i++) {						
			PrimerakKnjige primerak = aktivniPrimerci.get(i);			
			sadrzaj[i+1][0] = primerak.getId();	
			sadrzaj[i+1][1] = primerak.getKnjige().getId();
			sadrzaj[i+1][2] = primerak.getBrStrana();
			sadrzaj[i+1][3] = primerak.getTip();
			sadrzaj[i+1][4] = primerak.getJezikStampanja();	
			sadrzaj[i+1][5] = primerak.getGodinaStampanja();
			sadrzaj[i+1][6] = primerak.isDaLiJeIznajmljena();
		}
		this.model = new DefaultTableModel(sadrzaj, zaglavlja);
		table = new JTable(this.model);
		
		table.setBounds(10, 11, 320, 239);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		panel.add(table);
		
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);		
				//////////////////////////////////
				
				
		
		lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setBounds(380, 43, 140, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ID KNJIGE: ");
		lblNewLabel_1.setBounds(380, 68, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("BROJ STRANA: ");
		lblNewLabel_2.setBounds(380, 93, 140, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("POVEZ");
		lblNewLabel_3.setBounds(380, 118, 140, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("JEZIK STAMPANJA: ");
		lblNewLabel_4.setBounds(380, 143, 140, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("GODINA:");
		lblNewLabel_5.setBounds(380, 168, 140, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("IZNAJMLJENA:");
		lblNewLabel_6.setBounds(380, 193, 140, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(530, 40, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(530, 65, 144, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(530, 90, 144, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(530, 115, 144, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(530, 140, 144, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(530, 165, 144, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(530, 190, 144, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	
		JButton btnNewButton = new JButton("UKLONI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					deleteRow();
			}
		});
		btnNewButton.setBounds(449, 374, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		 btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                updateRow();
	            }
	        });
		btnNewButton_1.setBounds(449, 311, 182, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_Row();
			}
		});
		btnNewButton_2.setBounds(449, 248, 182, 52);
		contentPane.add(btnNewButton_2);
		
		
	}

}
