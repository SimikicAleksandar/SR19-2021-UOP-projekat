package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.ClanBiblioteke;
import Osobe.Zaposleni;
import knjige.Izdavanje;
import knjige.PrimerakKnjige;

public class IzdavanjeProzor extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelTabele;
	private JTable table_1;
	private Biblioteka biblioteka;
	private JTextField textDatumIznajmljivanja;
	private JTextField textDatumVracanja;
	private JComboBox comboBoxZaposleni = new JComboBox();
	private JComboBox comboBoxClan = new JComboBox();
	private JComboBox comboBoxKnjiga = new JComboBox();
	
	public IzdavanjeProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		biblioteka.ucitajIzdavanja();
		biblioteka.ucitajZanrove();
		biblioteka.ucitajKnjige();
		biblioteka.ucitajPrimerakKnjige();
		biblioteka.ucitajClanove();
		biblioteka.ucitajBibliotekare();
		biblioteka.ucitajAdministratore();
		popuniTabelu();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Biblioteka");
		getContentPane().setBackground(new Color(192, 192, 192));

		JButton btnNewButton = new JButton("DODAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRow();
			}
		});
		btnNewButton.setBounds(534, 226, 154, 36);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("AZURIRAJ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateRow();
			}
		});
		btnNewButton_2.setBounds(534, 273, 154, 36);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("UKLONI");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnNewButton_3.setBounds(534, 320, 154, 33);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 11, 441, 342);
		contentPane.add(scrollPane);

		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setRowSelectionAllowed(true);
		table_1.setColumnSelectionAllowed(false);
		table_1.setBackground(new Color(192, 192, 192));

		JLabel lblNewLabel_1 = new JLabel("Zaposleni:");
		lblNewLabel_1.setBounds(461, 16, 77, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Clan:");
		lblNewLabel_2.setBounds(461, 46, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Knjiga:");
		lblNewLabel_3.setBounds(461, 86, 49, 14);
		contentPane.add(lblNewLabel_3);

		comboBoxZaposleni.setBounds(571, 14, 173, 23);
		contentPane.add(comboBoxZaposleni);

		for (int i = 0; i < biblioteka.getAdmin().size(); i++) {
			Administrator admin = biblioteka.getAdmin().get(i);

			comboBoxZaposleni.addItem(String.valueOf(admin.getId()));
		}
		for (int i = 0; i < biblioteka.getBibliotekari().size(); i++) {
			Bibliotekar bibliotekar = biblioteka.getBibliotekari().get(i);
			comboBoxZaposleni.addItem(String.valueOf(bibliotekar.getId()));
		}
		for (int i = 0; i < biblioteka.getClanovi().size(); i++) {
			ClanBiblioteke clan = biblioteka.getClanovi().get(i);
			comboBoxClan.addItem(clan.getId());
		}
		for (int i = 0; i < biblioteka.getPrimerakKnjige().size(); i++) {
			PrimerakKnjige pknjiga = biblioteka.getPrimerakKnjige().get(i);
			if (pknjiga.isDaLiJeIznajmljena() == false) {
				comboBoxKnjiga.addItem(pknjiga.getId());
			}
		}

		comboBoxClan.setBounds(571, 48, 173, 23);
		contentPane.add(comboBoxClan);

		comboBoxKnjiga.setBounds(571, 82, 173, 23);
		contentPane.add(comboBoxKnjiga);

		JLabel lblNewLabel_4 = new JLabel("Datum Iznajmljivanja:");
		lblNewLabel_4.setBounds(461, 120, 111, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Datum Vracanja:");
		lblNewLabel_6.setBounds(461, 157, 100, 14);
		contentPane.add(lblNewLabel_6);

		textDatumIznajmljivanja = new JTextField();
		textDatumIznajmljivanja.setBounds(571, 116, 173, 23);
		contentPane.add(textDatumIznajmljivanja);
		textDatumIznajmljivanja.setColumns(10);

		textDatumVracanja = new JTextField();
		textDatumVracanja.setBounds(571, 153, 173, 23);
		contentPane.add(textDatumVracanja);
		textDatumVracanja.setColumns(10);
	}
		/* DODAJ */
	private void addRow() {
		try {
			boolean error = false;

			boolean obrisan = false;

			Zaposleni zaposleni;
			if (biblioteka.nadjiIdAdministratora(Integer.parseInt(comboBoxZaposleni.getSelectedItem().toString())) == null) {
				zaposleni = biblioteka.nadjiIdBibliotekara(Integer.parseInt(comboBoxZaposleni.getSelectedItem().toString()));
			} else {
				zaposleni = biblioteka.nadjiIdAdministratora(Integer.parseInt(comboBoxZaposleni.getSelectedItem().toString()));
			}

			Izdavanje unetoIzdavanje = new Izdavanje(zaposleni,
					biblioteka.nadjiIdClana(Integer.parseInt(comboBoxClan.getSelectedItem().toString())),
					biblioteka.nadjiIdPrimerka(Integer.parseInt(comboBoxKnjiga.getSelectedItem().toString())),
					LocalDate.parse(textDatumIznajmljivanja.getText()), LocalDate.parse(textDatumVracanja.getText()));

			String[] zaglavlja = new String[] { "Zaposleni", "Clan", "Primerak", "Datum Izdavanja", "Datum Vracanja" };
			Object[][] sadrzaj1 = new Object[biblioteka.getIzdavanja().size()][zaglavlja.length];
			Object[] sadrzaj = new Object[zaglavlja.length];

			for (int x = 0; x < biblioteka.getIzdavanja().size(); x++) {
				Izdavanje izd = biblioteka.getIzdavanja().get(x);
				if (izd.getPrimerak().getId() == unetoIzdavanje.getPrimerak().getId()) {
					JOptionPane.showMessageDialog(null, "Entitet sa istim id-om vec postoji", "Greska",
							JOptionPane.WARNING_MESSAGE);
					error = true;
					break;
				}

			}
			if (error != true) {
				biblioteka.addIzdavanje(unetoIzdavanje);
				sadrzaj[0] = unetoIzdavanje.getZaposleni().getKorisnickoIme();
				sadrzaj[1] = unetoIzdavanje.getClanovi().getIme();
				sadrzaj[2] = unetoIzdavanje.getPrimerak().getKnjige().getNaslovKnjige();
				sadrzaj[3] = unetoIzdavanje.getDatumIznajmljivanja();
				sadrzaj[4] = unetoIzdavanje.getDatumVracanja();
				unetoIzdavanje.getPrimerak().setDaLiJeIznajmljena(true);
				biblioteka.snimiIzdavanja();
				modelTabele.addRow(sadrzaj);
				table_1.setModel(modelTabele);

			}
		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Uneli ste slovo u input polje za broj", "Greska",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	/* AZURIRAJ */

	private void updateRow() {
		try {
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			int rowIndex = table_1.getSelectedRow();
			
			Zaposleni zaposleni;
			if (biblioteka.nadjiIdAdministratora(Integer.parseInt(comboBoxZaposleni.getSelectedItem().toString())) == null) {
				zaposleni = biblioteka.nadjiIdBibliotekara(Integer.parseInt(comboBoxZaposleni.getSelectedItem().toString()));
			} else {
				zaposleni = biblioteka.nadjiIdAdministratora(Integer.parseInt(comboBoxZaposleni.getSelectedItem().toString()));
			}
			
			Izdavanje izd = biblioteka.getIzdavanja().get(rowIndex);
			Izdavanje izd2 = new Izdavanje(zaposleni,
					biblioteka.nadjiIdClana(Integer.parseInt(comboBoxClan.getSelectedItem().toString())),
					biblioteka.nadjiIdPrimerka(Integer.parseInt(comboBoxKnjiga.getSelectedItem().toString())),
					LocalDate.parse(textDatumIznajmljivanja.getText()), LocalDate.parse(textDatumVracanja.getText()));

			izd.setZaposleni(zaposleni);
			izd.setClanovi(izd2.getClanovi());
			izd.setPrimerak(izd2.getPrimerak());
			izd.setDatumIznajmljivanja(LocalDate.parse(textDatumIznajmljivanja.getText()));
			izd.setDatumVracanja(LocalDate.parse(textDatumVracanja.getText()));

			model.setValueAt(izd.getZaposleni().getIme(), rowIndex, 0);
			model.setValueAt(izd.getClanovi().getIme(), rowIndex, 1);
			model.setValueAt(izd.getPrimerak().getKnjige().getNaslovKnjige(), rowIndex, 2);
			model.setValueAt(izd.getDatumIznajmljivanja(), rowIndex, 3);
			model.setValueAt(izd.getDatumVracanja(), rowIndex, 4);

			biblioteka.snimiIzdavanja(); 
			table_1.setModel(model);
			model.fireTableDataChanged();

		} catch (

		ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		}
	}

	/* OBRISI */

	private void deleteRow() {
		try {
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			int rowIndex = table_1.getSelectedRow();
			Izdavanje izn = biblioteka.getIzdavanja().get(rowIndex);
			biblioteka.snimiAdministratore();

			textDatumIznajmljivanja.setText("");
			textDatumVracanja.setText("");

			model.removeRow(rowIndex);
			table_1.setModel(model);
			model.fireTableDataChanged();

		} catch (ArrayIndexOutOfBoundsException x) {
			JOptionPane.showMessageDialog(null, "Izaberite red", "Greska", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska" + e, "Greska", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void popuniTabelu() {
		String[] zaglavlja = new String[] {"Zaposleni", "Clan", "Primerak", "Datum Izdavanja", "Datum Vracanja"};
		Object[][] sadrzaj = new Object[biblioteka.getIzdavanja().size()][zaglavlja.length];

		for (int i = 0; i < biblioteka.getIzdavanja().size(); i++) {
			Izdavanje ubaci = biblioteka.getIzdavanja().get(i);
			sadrzaj[i][0] = ubaci.getZaposleni().getIme();
			sadrzaj[i][1] = ubaci.getClanovi().getIme();
			sadrzaj[i][2] = ubaci.getPrimerak().getKnjige().getNaslovKnjige();
			sadrzaj[i][3] = ubaci.getDatumIznajmljivanja();
			sadrzaj[i][4] = ubaci.getDatumVracanja();

		}
		modelTabele = new DefaultTableModel(sadrzaj, zaglavlja);
		table_1 = new JTable(modelTabele);
	}
	
	
	
}
