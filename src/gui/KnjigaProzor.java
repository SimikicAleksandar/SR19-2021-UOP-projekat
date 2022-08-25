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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Bibliotekar;
import Osobe.Pol;
import knjige.Knjiga;
import knjige.ZanrKnjige;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class KnjigaProzor extends JFrame {
	
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField; // lblNewLabel = new JLabel("ID:");
	private JTextField textField_1; // lblNewLabel_1 = new JLabel("NASLOV KNJIGE:");
	private JTextField textField_2; // lblNewLabel_2 = new JLabel("ORIGINAL NASLOV KNJIGE:");
	private JTextField textField_3; // lblNewLabel_3 = new JLabel("PISAC:");
	private JTextField textField_4; // 	lblNewLabel_4 = new JLabel("GODINA OBJAVLJIVANJA: ");
	private JTextField textField_5; // lblNewLabel_5 = new JLabel("JEZIK ORIGINALA: ");
	private JTextField textField_6; //  lblNewLabel_6 = new JLabel("OPIS: ");
	private JTextField textField_7; // lblNewLabel_7 = new JLabel("ZANR: ");
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
			int godina = Integer.parseInt(textField_4.getText());
			boolean obrisan = false;
			int jedanZanr = Integer.parseInt(textField_7.getText());
			ZanrKnjige zanr = null ;
			biblioteka.ucitajZanr();
			for(ZanrKnjige zanrovi : biblioteka.getZanrovi()) {
				System.out.println(zanrovi.getId());
				if(zanrovi.getId() == jedanZanr) {
					zanr = zanrovi; 
				}
			}
						
			if (validacijaBroja(textField.getText()) == true) {
				Knjiga knjiga2 = new Knjiga(id, textField_1.getText(), textField_2.getText(),
						textField_3.getText(), godina, textField_5.getText(), textField_6.getText(),
						zanr, obrisan);
				
				String[] zaglavlja = new String[] {"ID", "NASLOV", "ORIGINAL NASLOV", "PISAC", "GODINA OBJAVLJIVANJA", "JEZIK", "OPIS", "ZANR", "OBRISAN"};
				
				
				Object[][] sadrzaj1 = new Object[biblioteka.getKnjige().size()][zaglavlja.length];
				Object[] sadrzaj = new Object[zaglavlja.length];
				
				for (int x = 0; x < biblioteka.getKnjige().size(); x++) {
					Knjiga knjiga = biblioteka.getKnjige().get(x);
					sadrzaj1[x][0] = knjiga.getId();
					if (sadrzaj1[x][0].equals(textField.getText())) {
						JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
								JOptionPane.WARNING_MESSAGE);
						error = true;
						break;
					}

				}
				if (error != true) {
					biblioteka.addKnjiga(knjiga2);
					biblioteka.snimiKnjige();
					
					sadrzaj[0] = knjiga2.getId();
					sadrzaj[1] = knjiga2.getNaslovKnjige();
					sadrzaj[2] = knjiga2.getOriginalNaslovKnjige();
					sadrzaj[3] = knjiga2.getPisac();
					sadrzaj[4] = knjiga2.getGodinaObjavljivanja();
					sadrzaj[5] = knjiga2.getJezikOriginala();
					sadrzaj[6] = knjiga2.getOpis();
					sadrzaj[7] = knjiga2.getZanr().getOpisZanra();
					sadrzaj[8] = knjiga2.isJeObrisan() ;
					biblioteka.snimiKnjige();
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
			
			String[] zaglavlja = new String[] {"ID", "NASLOV", "ORIGINAL NASLOV", "PISAC", "GODINA OBJAVLJIVANJA", "JEZIK", "OPIS", "ZANR", "OBRISAN"};
			Object[][] sadrzaj1 = new Object[biblioteka.getKnjiga().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];
			String AJDIJCINA = textField.getText();
			
			if (validacijaBroja(AJDIJCINA) == true) {
				boolean error = false;
				int id = Integer.parseInt(textField.getText());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int rowIndex = table.getSelectedRow();
				String izabranID = model.getValueAt(rowIndex, 0).toString();
				int izabranIDint = Integer.parseInt(izabranID);
				boolean obrisan = false;
				int godina = Integer.parseInt(textField_4.getText());
				int jedanZanr = Integer.parseInt(textField_7.getText()); 
				ZanrKnjige zanr = null ;
				for(ZanrKnjige zanrovi : biblioteka.getZanrovi()) {
					if(zanrovi.getId() == jedanZanr) {
						zanr = zanrovi ;
					}
				}
				
				Knjiga knjiga = biblioteka.getKnjige().get(rowIndex);
				Knjiga knjiga2 = new Knjiga(id, textField_1.getText(), textField_2.getText(),
						textField_3.getText(), godina, textField_5.getText(), textField_6.getText(),
						zanr, obrisan);


				if (error != true) {
					
					knjiga.setId(id);
					knjiga.setNaslovKnjige(textField_1.getText()); 
					knjiga.setOriginalNaslovKnjige(textField_2.getText());			
					knjiga.setPisac(textField_3.getText());
					knjiga.setGodinaObjavljivanja(godina);
					knjiga.setJezikOriginala(textField_5.getText());
					knjiga.setOpis(textField_6.getText());
					knjiga.setZanr(knjiga2.getZanr());
					knjiga.setJeObrisan(obrisan);
					
					model.setValueAt(knjiga.getId(), rowIndex, 0);
					model.setValueAt(knjiga.getNaslovKnjige(), rowIndex, 1);
					model.setValueAt(knjiga.getOriginalNaslovKnjige(), rowIndex, 2);
					model.setValueAt(knjiga.getPisac(), rowIndex, 3);
					model.setValueAt(knjiga.getGodinaObjavljivanja(), rowIndex, 4);
					model.setValueAt(knjiga.getJezikOriginala(), rowIndex, 5);
					model.setValueAt(knjiga.getOpis(), rowIndex, 6);
					model.setValueAt(knjiga.getZanr().getId(), rowIndex, 7);
					model.setValueAt(knjiga.isJeObrisan(), rowIndex, 8);
					
					biblioteka.snimiKnjige();
					model.fireTableRowsInserted(rowIndex, izabranIDint);
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
			String izabranID = model.getValueAt(rowIndex, 0).toString();
			int izabranIDint = Integer.parseInt(izabranID);
			Knjiga knjiga = biblioteka.getKnjige().get(rowIndex);
			knjiga.setJeObrisan(true);
			
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			
			model.removeRow(izabranIDint);
			table.setModel(model);
			model.fireTableDataChanged();

		}catch(ArrayIndexOutOfBoundsException x) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska" + e, "Greska", JOptionPane.WARNING_MESSAGE);
		}
		}
	
	
	
	public KnjigaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 360, 489);
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		
		biblioteka.ucitajKnjige();
		ArrayList<Knjiga> aktivneKnjige = new ArrayList<Knjiga>();
		for(Knjiga knjiga:biblioteka.getKnjige()) {
			if(!knjiga.isJeObrisan()) {
				aktivneKnjige.add(knjiga);
			}
		}
		String[] zaglavlja = new String[] {"ID", "NASLOV", "ORIGINAL NASLOV", "PISAC", "GODINA OBJAVLJIVANJA", "JEZIK", "OPIS", "ZANR", "OBRISAN"};
		Object[][] sadrzaj = new Object[aktivneKnjige.size()+1][zaglavlja.length];
		
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
		sadrzaj[0][2] = zaglavlja[2];
		sadrzaj[0][3] = zaglavlja[3];
		sadrzaj[0][4] = zaglavlja[4];
		sadrzaj[0][5] = zaglavlja[5];
		sadrzaj[0][6] = zaglavlja[6];
		sadrzaj[0][7] = zaglavlja[7];
		sadrzaj[0][8] = zaglavlja[8];
		
		for(int i=0; i<aktivneKnjige.size(); i++) {
			Knjiga knjiga = aktivneKnjige.get(i);
			sadrzaj[i+1][0] = knjiga.getId();
			sadrzaj[i+1][1] = knjiga.getNaslovKnjige();
			sadrzaj[i+1][2] = knjiga.getOriginalNaslovKnjige();
			sadrzaj[i+1][3] = knjiga.getPisac();
			sadrzaj[i+1][4] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i+1][5] = knjiga.getJezikOriginala();
			sadrzaj[i+1][6] = knjiga.getOpis();
			sadrzaj[i+1][7] = knjiga.getZanr().getId();
			sadrzaj[i+1][8] = knjiga.isJeObrisan();
			
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
			
		
		lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(380, 31, 130, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("NASLOV KNJIGE:");
		lblNewLabel_1.setBounds(380, 56, 130, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ORIGINAL NASLOV KNJIGE:");
		lblNewLabel_2.setBounds(380, 81, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("PISAC:");
		lblNewLabel_3.setBounds(380, 106, 130, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("GODINA OBJAVLJIVANJA: ");
		lblNewLabel_4.setBounds(380, 131, 130, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("JEZIK ORIGINALA: ");
		lblNewLabel_5.setBounds(380, 156, 130, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("OPIS: ");
		lblNewLabel_6.setBounds(380, 181, 130, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("ZANR: ");
		lblNewLabel_7.setBounds(380, 206, 130, 14);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(530, 25, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(530, 50, 145, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(530, 75, 145, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(530, 100, 145, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(530, 125, 145, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(530, 150, 145, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(530, 175, 145, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(530, 200, 145, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("UKLONI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnNewButton.setBounds(434, 412, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });
		btnNewButton_1.setBounds(434, 349, 182, 52);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_Row();
			}
		});
		btnNewButton_2.setBounds(434, 286, 182, 52);
		contentPane.add(btnNewButton_2);
	}

}
