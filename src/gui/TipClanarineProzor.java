//package gui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTable;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//public class TipClanarineProzor extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//	private JLabel lblNewLabel;
//	private JLabel lblNewLabel_1;
//	private JLabel lblNewLabel_2;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JButton btnNewButton;
//	private JButton btnNewButton_1;
//	private JButton btnNewButton_2;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TipClanarineProzor frame = new TipClanarineProzor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public TipClanarineProzor() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 700, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().setBackground(new Color(192,192,192));;
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBounds(10, 11, 360, 239);
//		contentPane.add(panel);
//		
//		table = new JTable();
//		panel.add(table);
//		
//		lblNewLabel = new JLabel("ID:");
//		lblNewLabel.setBounds(380, 27, 134, 14);
//		contentPane.add(lblNewLabel);
//		
//		lblNewLabel_1 = new JLabel("NAZIV: ");
//		lblNewLabel_1.setBounds(380, 52, 134, 14);
//		contentPane.add(lblNewLabel_1);
//		
//		lblNewLabel_2 = new JLabel("CENA:");
//		lblNewLabel_2.setBounds(380, 77, 134, 14);
//		contentPane.add(lblNewLabel_2);
//		
//		textField = new JTextField();
//		textField.setBounds(524, 21, 150, 20);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(524, 46, 150, 20);
//		contentPane.add(textField_1);
//		textField_1.setColumns(10);
//		
//		textField_2 = new JTextField();
//		textField_2.setBounds(524, 71, 150, 20);
//		contentPane.add(textField_2);
//		textField_2.setColumns(10);
//		
//		btnNewButton = new JButton("UKLONI");
//		btnNewButton.setBounds(468, 212, 104, 38);
//		contentPane.add(btnNewButton);
//		
//		btnNewButton_1 = new JButton("AZURIRAJ");
//		btnNewButton_1.setBounds(468, 163, 104, 38);
//		contentPane.add(btnNewButton_1);
//		
//		btnNewButton_2 = new JButton("DODAJ");
//		btnNewButton_2.setBounds(468, 114, 104, 38);
//		contentPane.add(btnNewButton_2);
//	}
//
//}
