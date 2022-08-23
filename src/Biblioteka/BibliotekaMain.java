package Biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;

import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.ClanBiblioteke;
import Osobe.Pol;
import Osobe.TipClanarine;
import gui.GlavniProzor;
import knjige.Knjiga;
import knjige.PrimerakKnjige;
import knjige.ZanrKnjige;

public class BibliotekaMain {
	public static String ADMINI_FAJL = "src/fajlovi/administratori.txt";
	public static void main(String[] args) {
		Biblioteka biblioteka = Biblioteka.ucitajBiblioteku();
		
		biblioteka.ucitajAdministratore();
		for(Administrator administrator : biblioteka.getAdministratori()) {
			System.out.println(""/*administrator.getKorisnickoIme()*/);
		}
	        
		biblioteka.ucitajBibliotekare();
		for(Bibliotekar bibliotekar : biblioteka.getBibliotekari()) {
			System.out.println(""/*bibliotekar.getKorisnickoIme()*/);
		}
		
		biblioteka.ucitajClanove();
		for(ClanBiblioteke clan : biblioteka.getClanovi()) {
			System.out.println(clan.getPrezime());
		}

		biblioteka.ucitajZanr();
		for(ZanrKnjige Zanr : biblioteka.getZanrovi()) {
			System.out.println(Zanr.getOznaka());
		}
		
		biblioteka.ucitajKnjige();
		for(Knjiga knjiga : biblioteka.getKnjige()) {
			System.out.println(knjiga.getNaslovKnjige());
		}
		
//		biblioteka.ucitajPrimerakKnjige();
//		for(PrimerakKnjige primerak : biblioteka.getPrimerciKnjiga()) {
//			System.out.println("Bilo sta");
//		}
//		
		GlavniProzor lp = new GlavniProzor(biblioteka);
		lp.setVisible(true);
	}
	

}


		

