package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Biblioteka.Biblioteka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BibliotekarProzor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BibliotekarProzor frame = new BibliotekarProzor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BibliotekarProzor(Biblioteka biblioteka) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		table = new JTable();
		table.setBounds(10, 11, 350, 489);
		panel.add(table);
		
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
		btnNewButton.setBounds(435, 421, 182, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.setBounds(435, 358, 182, 52);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DODAJ");
		btnNewButton_2.setBounds(435, 295, 182, 52);
		panel.add(btnNewButton_2);
	}

}
