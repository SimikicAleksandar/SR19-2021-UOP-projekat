package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Biblioteka.Biblioteka;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZanroviProzro extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ZanroviProzro frame = new ZanroviProzro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param biblioteka 
	 */
	public ZanroviProzro(Biblioteka biblioteka) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setBackground(new Color(192,192,192));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel = new JLabel("OZNAKA: ");
		lblNewLabel.setBounds(380, 25, 130, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("OPIS ZANRA:");
		lblNewLabel_1.setBounds(380, 50, 130, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(520, 19, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(520, 44, 154, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("DODAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(483, 102, 119, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("AZURIRAJ");
		btnNewButton_1.setBounds(483, 153, 119, 40);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("UKLONI");
		btnNewButton_2.setBounds(483, 210, 119, 40);
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		table.setBounds(10, 11, 320, 239);
		contentPane.add(table);
	}
}
