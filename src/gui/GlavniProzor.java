package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.Zaposleni;

public class GlavniProzor extends JFrame {
	private Zaposleni prijavljeniZaposleni;
	private boolean admin = false;
	private JPanel contentPane;
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu osobeMenu = new JMenu("Osobe");
	private JMenuItem adminiItem = new JMenuItem("Admini");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	private JMenuItem clanoviItem = new JMenuItem("Clanovi");
	private JMenu knjigeMenu = new JMenu("Sve Knjige");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem zanrItem = new JMenuItem("Zanr");
	private JMenuItem primerakKnjigeItem = new JMenuItem("Primerak Knjige");
	private JMenuItem izdavanjeItem = new JMenuItem("Izdavanje");
	private Biblioteka biblioteka;


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
		mainMenu.add(izdavanjeItem);
		
	}
	
	public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniZaposleni, boolean daLiJeAdmin) {
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
		
		izdavanjeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzdavanjeProzor ip = new IzdavanjeProzor(biblioteka);
                ip.setVisible(true);
                
            }
        });
	}
}
