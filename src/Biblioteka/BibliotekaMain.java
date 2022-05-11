package Biblioteka;

import java.util.ArrayList;

import Osobe.Adminisatrator;
import Osobe.Bibliotekar;
import Osobe.Pol;
import knjige.Knjiga;

public class BibliotekaMain {
/*
	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajAdministratore();
		for(Adminisatrator administrator : biblioteka.getAdministratori()) {
			System.out.println(administrator.getKorisnickoIme());
			
		
		}
		Adminisatrator administrator = new Adminisatrator(002, "ALEKSANDAR", "DOKTORIRAOJAVU", "12313212312312", "BULEVAR JAVE", Pol.valueOf("MUSKI"), "RADI", "MOLIMTE", 9999999.00);
		ArrayList<Adminisatrator> administratori = new ArrayList<Adminisatrator>();
		administratori.add(administrator);
		biblioteka.setAdministratori(administratori);
		biblioteka.snimiAdministratore();
		
	}
	*/ 
	/*
	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajBibliotekare();
		for(Bibliotekar bibliotekar : biblioteka.getBibliotekari()) {
			System.out.println(bibliotekar.getKorisnickoIme());
		}
		
		Bibliotekar bibliotekar = new Bibliotekar(002, "ALEKSANDAR", "DOKTORIRAOJAVU", "12313212312312", "BULEVAR JAVE", Pol.valueOf("MUSKI"), "RADI", "MOLIMTE", 9999999.00);
		ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
		bibliotekari.add(bibliotekar);
		biblioteka.setBibliotekari(bibliotekari);
		biblioteka.snimiBibliotekari();
	}
	*/
	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajKnjige();
		for(Knjiga knjiga : biblioteka.getKnjige()) {
			System.out.println(knjiga.getZanr());
			
		
		}
		/*
		Knjiga knjiga = new Knjiga(123, "IMEKNJIGE", "LAGANADESETKA", "STIRNOAIBNSOI", 2022, "Ruski", "MOJAOCENA", "001");
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		knjige.add(knjiga);
		biblioteka.setKnjige(knjige);
		biblioteka.snimiKnjige(knjige);
		*/
	}
	
}
