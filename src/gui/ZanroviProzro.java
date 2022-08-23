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
import knjige.ZanrKnjige;

import javax.swing.JTable;
import javax.swing.JLabel;
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
		String[] zaglavlja = new String[] {"OZNAKA", "OPIS ZANRA"};
		Object[][] sadrzaj = new Object[aktivniZanrovi.size()+1][zaglavlja.length];
		sadrzaj[0][0] = zaglavlja[0];
		sadrzaj[0][1] = zaglavlja[1];
		
		for(int i=0; i<aktivniZanrovi.size(); i++) {
			ZanrKnjige zanr = aktivniZanrovi.get(i);
			sadrzaj[i+1][0] = zanr.getOznaka();
			sadrzaj[i+1][1] = zanr.getOpisZanra();
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
		
		btnNewButton = new JButton("DODAJ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	add_Row();
			}
		});
		btnNewButton.setBounds(483, 102, 119, 40);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             //   updateRow();
            }
        });
		btnNewButton_1.setBounds(483, 153, 119, 40);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("UKLONI");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//	deleteRow();
		}
	});
		btnNewButton_2.setBounds(483, 210, 119, 40);
		panel.add(btnNewButton_2);
		
		
		
	}
}
