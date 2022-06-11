package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Biblioteka.Biblioteka;
public class GlavniProzor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GlavniProzor frame = new GlavniProzor();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu osobeMenu = new JMenu("Osobe");
	private JMenuItem adminiItem = new JMenuItem("Admini");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	private JMenuItem clanoviItem = new JMenuItem("Clanovi");
	private JMenu knjigeMenu = new JMenu("Sve Knjige");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem zanrItem = new JMenuItem("Zanr");
	private JMenuItem primerakKnjigeItem = new JMenuItem("Primerak Knjige");
//	private JMenuItem clanarinaItem = new JMenuItem("Tip Clanarine");

	private static Biblioteka biblioteka;

	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(osobeMenu);
		osobeMenu.add(adminiItem);
		osobeMenu.add(bibliotekariItem);
		osobeMenu.add(clanoviItem);
		mainMenu.add(knjigeMenu);
		knjigeMenu.add(knjigeItem);
		knjigeMenu.add(zanrItem);
		knjigeMenu.add(primerakKnjigeItem);
	//	knjigeMenu.add(clanarinaItem);

	}
	public GlavniProzor() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.biblioteka = biblioteka;
		setSize(700, 500);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		setTitle("Biblioteka");
	}
	
	
	private void initActions() {
		adminiItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminProzor ap = new AdminProzor(biblioteka);
				ap.setVisible(true);
				
			}
		});
		bibliotekariItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekarProzor bp = new BibliotekarProzor(biblioteka);
				bp.setVisible(true);
			
			}
		});
		
		clanoviItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanProzor cp = new ClanProzor(biblioteka);
				cp.setVisible(true);
				
			}
		});
		
		knjigeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigaProzor kp = new KnjigaProzor(biblioteka);
				kp.setVisible(true);
				
			}
		});
		
		zanrItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviProzro zp = new ZanroviProzro(biblioteka);
				zp.setVisible(true);
				
			}
		});
	
		primerakKnjigeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerakKnjigeProzor pk = new PrimerakKnjigeProzor(biblioteka);
				pk.setVisible(true);
			}
		});
	
		
	}
}
