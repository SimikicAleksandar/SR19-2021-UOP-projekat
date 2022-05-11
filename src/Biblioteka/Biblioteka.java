package Biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
	
	
	//Funkcije za ucitavanje i snimanje Administratora
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
	
	//Funkcije za ucitavanje i snimanje Bibliotekara
	
	public void ucitajBibliotekare() {
		try {
			File korisniciFile = new File("src/fajlovi/bibliotekari.txt");
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
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
				this.bibliotekari.add(bibliotekar);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiBibliotekari() {
		String sadrzaj = "";
		for (Bibliotekar bibliotekar : this.bibliotekari) {
			sadrzaj += bibliotekar.getId()+ "|"  + bibliotekar.getIme()+ "|" + bibliotekar.getPrezime() + "|" + bibliotekar.getJMBG() + "|" + bibliotekar.getAdresa()  + "|" + bibliotekar.getPol()  + "|" + bibliotekar.getKorisnickoIme() + 
					"|" + bibliotekar.getKorisnickaSifra()   + "|" + bibliotekar.getPlata() +"\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/bibliotekari.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	//Funkcije za ucitavanje i snimanje Clanova Biblioteke i tipa clanarine ;
	
	
	
	public void ucitajClanove() {
		try {
			File korisniciFile = new File("src/fajlovi/clanovi.txt");
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
				String brClanKarte = lineSplit[6];
				
				//TipClanarine tip = this.
						
				LocalDate datumPoslednjeUplate = LocalDate.parse(lineSplit[8]);
				int brojMeseciClanarine = Integer.parseInt(lineSplit[9]);
				boolean isActive = Boolean.parseBoolean(lineSplit[10]);
				ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, jMBG, adresa, pol, brClanKarte, tip, datumPoslednjeUplate, brojMeseciClanarine, isActive);
				this.clanovi.add(clan);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiClanove() {
		String sadrzaj = "";
		for (ClanBiblioteke clan : this.clanovi) {
			sadrzaj += clan.getId()+ "|"  + clan.getIme()+ "|" + clan.getPrezime() + "|" + clan.getJMBG() + "|" + clan.getAdresa()  + "|" + clan.getPol()  + "|" + clan.getBrClanKarte() + 
					"|" + /*clan.getTipClanarine() + "|" +*/clan.getDatumPoslednjeUplate()  + "|" + clan.getBrojMeseciClanarine() + "|" + clan.isActive() + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/clanovi.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	//Funkcije za ucitavanje i snimanje knjiga, zanra i trazenje zanra
	public void ucitajZanr() {
		try {
			File korisniciFile = new File("src/fajlovi/zanrovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				String oznaka = lineSplit[0];
				String opisZanra = lineSplit[1];
				
				ZanrKnjige zanr = new ZanrKnjige(oznaka, opisZanra);
				this.zanrovi.add(zanr);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiZanr() {
		String sadrzaj = "";
		for (ZanrKnjige zanr : this.zanrovi) {
			sadrzaj += zanr.getOznaka() + "|"  + zanr.getOpisZanra()  + "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/zanrovi.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public ZanrKnjige nadjiZanr(int id) {
        ZanrKnjige trazeni = null;
        for(int i = 0; i < this.zanrovi.size(); i++) {
            if (this.zanrovi.get(i).getId() == id) {
                trazeni = this.zanrovi.get(i);
            }
        }
        return trazeni;
        }
	
	public void ucitajKnjige() {
		try {
			File korisniciFile = new File("src/fajlovi/knjiga.txt");
			BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naslovKnjige = lineSplit[1];
				String originalNaslovKnjige = lineSplit[2];
				String pisac = lineSplit[3];
				int godinaObjavljivanja = Integer.parseInt(lineSplit[4]);
				String jezikOriginala = lineSplit[5];
				String opis = lineSplit[6];
				ZanrKnjige zanr = this.nadjiZanr(Integer.parseInt(lineSplit[7])); 
				Knjiga knjiga = new Knjiga(id, naslovKnjige, originalNaslovKnjige, pisac, godinaObjavljivanja, jezikOriginala, opis, zanr);
				this.knjige.add(knjiga);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiKnjige() {
		String sadrzaj = "";
		for (Knjiga knjiga : this.knjige) {
			sadrzaj += knjiga.getId()+ "|"  + knjiga.getNaslovKnjige() + "|" + knjiga.getOriginalNaslovKnjige() + "|" + knjiga.getPisac()+ "|" + knjiga.getGodinaObjavljivanja()  + "|" + knjiga.getJezikOriginala() + "|" + knjiga.getOpis() + 
					"|" + knjiga.getZanr() +"\n";
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
