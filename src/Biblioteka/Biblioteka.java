package Biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Osobe.Adminisatrator;
import Osobe.Bibliotekar;
import Osobe.ClanBiblioteke;
import Osobe.Pol;
import knjige.Knjiga;
import knjige.PrimerakKnjige;
import knjige.ZanrKnjige;

public class Biblioteka {
	private ArrayList<Adminisatrator> administratori;
	private ArrayList<Bibliotekar> bibliotekari;
	private ArrayList<ClanBiblioteke> clanovi;
	private ArrayList<Knjiga> knjige;
	private ArrayList<PrimerakKnjige> primerciKnjiga;
	private ArrayList<ZanrKnjige> zanrovi;
	public Biblioteka() {
		super();
		this.administratori = new ArrayList<Adminisatrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanovi = new ArrayList<ClanBiblioteke>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerciKnjiga = new ArrayList<PrimerakKnjige>();
		this.zanrovi = new ArrayList<ZanrKnjige>();
	}
	public ArrayList<Adminisatrator> getAdministratori() {
		return administratori;
	}
	public void setAdministratori(ArrayList<Adminisatrator> administratori) {
		this.administratori = administratori;
	}
	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}
	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}
	public ArrayList<ClanBiblioteke> getClanovi() {
		return clanovi;
	}
	public void setClanovi(ArrayList<ClanBiblioteke> clanovi) {
		this.clanovi = clanovi;
	}
	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}
	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}
	public ArrayList<PrimerakKnjige> getPrimerciKnjiga() {
		return primerciKnjiga;
	}
	public void setPrimerciKnjiga(ArrayList<PrimerakKnjige> primerciKnjiga) {
		this.primerciKnjiga = primerciKnjiga;
	}
	public ArrayList<ZanrKnjige> getZanrovi() {
		return zanrovi;
	}
	public void setZanrovi(ArrayList<ZanrKnjige> zanrovi) {
		this.zanrovi = zanrovi;
	}
	
	
	//Funkcije za ucitavanje i snimanje administratora
	public void ucitajAdministratore() {
		try {
			File korisniciFile = new File("src/fajlovi/administratori.txt");
			BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String jMBG = lineSplit[3];
				String adresa = lineSplit[4];
				Pol pol = Pol.valueOf(lineSplit[5]);
				String korisnickoIme = lineSplit[6];
				String korisnickaSifra = lineSplit[7];
				double plata = Double.parseDouble(lineSplit[8]);
				Adminisatrator administrator = new Adminisatrator(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
				this.administratori.add(administrator);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiAdministratore() {
		String sadrzaj = "";
		for (Adminisatrator administrator : this.administratori) {
			sadrzaj += administrator.getId()+ "|"  + administrator.getIme()+ "|" + administrator.getPrezime() + "|" + administrator.getJMBG() + "|" + administrator.getAdresa()  + "|" + administrator.getPol()  + "|" + administrator.getKorisnickoIme() + 
					"|" + administrator.getKorisnickaSifra()   + "|" + administrator.getPlata() +"\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/administratori.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
}
