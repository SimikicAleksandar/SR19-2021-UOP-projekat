package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Biblioteka.Biblioteka;
import Osobe.Administrator;
import Osobe.Bibliotekar;
import net.miginfocom.swing.MigLayout;

public class LoginProzor extends JFrame {

	private JLabel lblGreeting = new JLabel("Dobrodošli. Molimo da se prijavite.");
	private JLabel lblUsername = new JLabel("Korisničko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Šifra");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private Biblioteka biblioteka;
	
	
	
	
	public LoginProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		getContentPane().setLayout(mig);
		
		getContentPane().add(lblGreeting, "span 2");
		getContentPane().add(lblUsername);
		getContentPane().add(txtKorisnickoIme);
		getContentPane().add(lblPassword);
		getContentPane().add(pfPassword);
		getContentPane().add(new JLabel());
		getContentPane().add(btnOk, "split 2");
		getContentPane().add(btnCancel);
		
		
		txtKorisnickoIme.setText("Aciko");
		pfPassword.setText("Acikol");
		getRootPane().setDefaultButton(btnOk);
		
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String korisnikoIme = txtKorisnickoIme.getText().trim();
                String sifra = new String(pfPassword.getPassword()).trim();

                if (korisnikoIme.equals("") || sifra.equals("")) {
                    JOptionPane.showMessageDialog(null, "Podaci su prazni.", "Greska",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean admin = false;
                    Administrator prijavljeniAdmin = biblioteka.adminLogin(korisnikoIme, sifra);
                    Bibliotekar prijavljeniBibliotekar = biblioteka.bibliotekarLogin(korisnikoIme, sifra);

                    if (prijavljeniAdmin == null && prijavljeniBibliotekar == null) {

                        JOptionPane.showMessageDialog(null, "Login podaci nisu ispravni.", "GreÅ¡ka",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (prijavljeniAdmin != null) {
                        admin = true;
                        }
                        if (admin != true) {
                            LoginProzor.this.dispose();
                            LoginProzor.this.setVisible(false);
                            GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeniBibliotekar, false);
                            gp.setVisible(true);
                        } else {
                            LoginProzor.this.dispose();
                            LoginProzor.this.setVisible(false);
                            GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeniAdmin, admin);
                            gp.setVisible(true);
                        }

                    }

                }
            }

        });
		
	}
}
