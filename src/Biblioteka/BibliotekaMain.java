package Biblioteka;

import java.util.ArrayList;

import Osobe.Adminisatrator;
import Osobe.Bibliotekar;
import Osobe.ClanBiblioteke;
import Osobe.Pol;
import knjige.Knjiga;
import knjige.ZanrKnjige;

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
	/*
	public static void main(String[] args) {
		
		Biblioteka biblioteka = new Biblioteka();
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		biblioteka.setKnjige(knjige);
		biblioteka.ucitajKnjige();
		for(Knjiga knjiga : biblioteka.getKnjige()) {
			System.out.println(knjiga.getZanr());
		}
	} */
	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajClanove();
		for(ClanBiblioteke clan : biblioteka.getClanovi()) {
			System.out.println(clan.getPrezime());
		}
		
		ClanBiblioteke clan = new ClanBiblioteke(002, "ALEKSANDAR", "DOKTORIRAOJAVU", "12313212312312", "BULEVAR JAVE", Pol.valueOf("MUSKI"), "RADI", "MOLIMTE", 004,LocalDate.valueOf(2021-08-24),11,);
		ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
		clanovi.add(clan);
		biblioteka.setClanovi(clanovi);
		biblioteka.snimiClanove();
		
	}
}
