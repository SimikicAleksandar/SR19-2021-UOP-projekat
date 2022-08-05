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
import knjige.Knjiga;
import knjige.ZanrKnjige;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class KnjigaProzor extends JFrame {

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;


	public KnjigaProzor(Biblioteka biblioteka) {
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
		String[] zaglavlja = new String[] {"ID", "NASLOV KNJIGE", "PISAC"};
		Object[][] sadrzaj = new Object[aktivneKnjige.size()+1][zaglavlja.length];
		
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
		sadrzaj[0][2] = zaglavlja[2];
		for(int i=0; i<aktivneKnjige.size(); i++) {
			Knjiga knjiga = aktivneKnjige.get(i);
			sadrzaj[i+1][0] = knjiga.getId();
			sadrzaj[i+1][1] = knjiga.getNaslovKnjige();
			sadrzaj[i+1][2] = knjiga.getPisac();
			}
		
		DefaultTableModel tabelaZanrova = new DefaultTableModel(sadrzaj, zaglavlja);
		table = new JTable(tabelaZanrova);
		table.setBounds(10, 11, 320, 239);
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
		btnNewButton.setBounds(434, 412, 182, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.setBounds(434, 349, 182, 52);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(aktivneKnjige.get(table.getSelectedRow()-1).getId());
			}
		});
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.setBounds(434, 286, 182, 52);
		contentPane.add(btnNewButton_2);
	}

}
