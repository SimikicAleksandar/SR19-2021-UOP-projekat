package Biblioteka;

import java.util.ArrayList;

import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.Pol;
import gui.GlavniProzor;

public class BibliotekaMain {

	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajAdministratore();
		for(Administrator administrator : biblioteka.getAdministratori()) {
			System.out.println(administrator.getKorisnickoIme());
			
		
		}
		Administrator administrator = new Administrator(100, "ALEKSANDAR", "SIMIKIC", "10892376981", "FTN1234", Pol.valueOf("MUSKI"), "ACO", "ACOL", 9999999.00, false);
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		administratori.add(administrator);
		biblioteka.setAdministratori(administratori);
		biblioteka.snimiAdministratore();
		GlavniProzor lp = new GlavniProzor(biblioteka);
	        lp.setVisible(true);
	        
	        
		biblioteka.ucitajBibliotekare();
		for(Bibliotekar bibliotekar : biblioteka.getBibliotekari()) {
			System.out.println(bibliotekar.getKorisnickoIme());
		}
		
		Bibliotekar bibliotekar = new Bibliotekar(100, "ALEKSANDAR", "DOKTOR", "12313212312312", "DESETKAPROGRAMIRANJE", Pol.valueOf("MUSKI"), "RADI", "MOLIMTE", 9999999.00, false);
		ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
		bibliotekari.add(bibliotekar);
		biblioteka.setBibliotekari(bibliotekari);
		biblioteka.snimiBibliotekari();    
		}
			
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
//	public static void main(String[] args) {
//		Biblioteka biblioteka = new Biblioteka();
//		biblioteka.ucitajClanove();
//		for(ClanBiblioteke clan : biblioteka.getClanovi()) {
//			System.out.println(clan.getPrezime());
//		}
//		
//		ClanBiblioteke clan = new ClanBiblioteke(002, "ALEKSANDAR", "DOKTORIRAOJAVU", "12313212312312", "BULEVAR JAVE", Pol.valueOf("MUSKI"), "RADI", "MOLIMTE", 004,LocalDate.valueOf(2021-08-24),11,);
//		ArrayList<ClanBiblioteke> clanovi = new ArrayList<ClanBiblioteke>();
//		clanovi.add(clan);
//		biblioteka.setClanovi(clanovi);
//		biblioteka.snimiClanove();
//		
//	}
}
