package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.ClanBiblioteke;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ClanProzor extends JFrame {

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
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
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


	public ClanProzor(Biblioteka biblioteka) {
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
		String[] zaglavlja = new String[] {"IME", "PREZIME", "POL", "BROJ CLANSKE KARTE", "AKTIVNOST"};
		Object[][] sadrzaj = new Object[aktivniClanovi.size()][zaglavlja.length];
		
		for(int i=0; i<aktivniClanovi.size(); i++) {
			ClanBiblioteke clan = aktivniClanovi.get(i);
			sadrzaj[i][0] = clan.getIme();
			sadrzaj[i][1] = clan.getPrezime();
			sadrzaj[i][2] = clan.getPol();
			sadrzaj[i][3] = clan.getBrClanKarte();
			sadrzaj[i][4] = String.valueOf(clan.isActive());
		}
		
		DefaultTableModel tabelaClanova = new DefaultTableModel(sadrzaj, zaglavlja);
		table = new JTable(tabelaClanova);
		table.setBounds(10, 11, 350, 489);
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
		
		lblNewLabel_10 = new JLabel("AKTIVNOST:");
		lblNewLabel_10.setBounds(380, 270, 150, 14);
		contentPane.add(lblNewLabel_10);
		
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setToolTipText("");
		rdbtnNewRadioButton.setBounds(540, 270, 134, 20);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("UKLONI");
		btnNewButton.setBounds(434, 434, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.setBounds(434, 371, 182, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.setBounds(434, 308, 182, 52);
		contentPane.add(btnNewButton_2);
	}

}
