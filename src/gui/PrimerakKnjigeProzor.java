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
import knjige.PrimerakKnjige;

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

public class PrimerakKnjigeProzor extends JFrame {


	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnNewRadioButton;
	private JTable table;


	public PrimerakKnjigeProzor(Biblioteka biblioteka) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		getContentPane().setBackground(new Color(192,192,192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TABELA
				ArrayList<PrimerakKnjige> aktivniPrimerci = new ArrayList<PrimerakKnjige>();
				for(PrimerakKnjige primerakKnjige:biblioteka.getPrimerciKnjiga()) {
					if(!primerakKnjige.isJeObrisan()) {
						aktivniPrimerci.add(primerakKnjige);
					}
				}
				String[] zaglavlja = new String[] {"BROJ STRANA", "TIP POVEZA", "GODINA STAMPANJA", "JEZIK STAMPANJA"};
				Object[][] sadrzaj = new Object[aktivniPrimerci.size()][zaglavlja.length];
				
				for(int i=0; i<aktivniPrimerci.size(); i++) {
					PrimerakKnjige primerak = aktivniPrimerci.get(i);
					sadrzaj[i][0] = primerak.getBrStrana();
					sadrzaj[i][1] = primerak.getTip();
					sadrzaj[i][2] = primerak.getGodinaStampanja();
					sadrzaj[i][3] = primerak.getJezikStampanja();
				}
				
				DefaultTableModel tabelaPrimeraka = new DefaultTableModel(sadrzaj, zaglavlja);
				table = new JTable(tabelaPrimeraka);
				table.setBounds(10, 11, 360, 489);
				contentPane.add(table);
				
				table.setRowSelectionAllowed(true);
				table.setColumnSelectionAllowed(false);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setDefaultEditor(Object.class, null);
				table.getTableHeader().setReorderingAllowed(false);	
				//////////////////////////////////
				
				
		
		lblNewLabel = new JLabel("KNJIGA: ");
		lblNewLabel.setBounds(380, 43, 140, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BROJ STRANA: ");
		lblNewLabel_1.setBounds(380, 68, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("TIP POVEZA: ");
		lblNewLabel_2.setBounds(380, 93, 140, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("GODINA STAMPANJA: ");
		lblNewLabel_3.setBounds(380, 118, 140, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("JEZIK STAMPANJA: ");
		lblNewLabel_4.setBounds(380, 143, 140, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("DA LI JE IZNAJMLJENA: ");
		lblNewLabel_5.setBounds(380, 168, 140, 14);
		contentPane.add(lblNewLabel_5);
		
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
		
		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(530, 168, 144, 20);
		contentPane.add(rdbtnNewRadioButton);
	
		JButton btnNewButton = new JButton("UKLONI");
		btnNewButton.setBounds(449, 374, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.setBounds(449, 311, 182, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.setBounds(449, 248, 182, 52);
		contentPane.add(btnNewButton_2);
		
		
	}

}
