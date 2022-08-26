 package Biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Osobe.Administrator;
import Osobe.Bibliotekar;
import Osobe.ClanBiblioteke;
import Osobe.Pol;
import Osobe.TipClanarine;
import knjige.Knjiga;
import knjige.PrimerakKnjige;
import knjige.TipPoveza;
import knjige.ZanrKnjige;

public class Biblioteka {
	//Za samu biblioteku postoje podaci o nazivu, adresi, telefonu i radnom vremenu
	private String naziv;
	private String adresa;
	private String telefon;
	private String radnoVreme;
	private ArrayList<Administrator> administratori;
	private ArrayList<Bibliotekar> bibliotekari;
	private ArrayList<ClanBiblioteke> clanovi;
	private ArrayList<Knjiga> knjige;
	private ArrayList<PrimerakKnjige> primerciKnjiga;
	private ArrayList<ZanrKnjige> zanrovi;
	private ArrayList<TipClanarine> tipovi;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getRadnoVreme() {
		return radnoVreme;
	}
	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}
	public ArrayList<TipClanarine> getTipovi() {
		return tipovi;
	}
	public void setTipovi(ArrayList<TipClanarine> tipovi) {
		this.tipovi = tipovi;
	}
	public Biblioteka(String naziv2, String adresa2, String telefon2, String radnoVreme2) {
		super();
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanovi = new ArrayList<ClanBiblioteke>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerciKnjiga = new ArrayList<PrimerakKnjige>();
		this.zanrovi = new ArrayList<ZanrKnjige>();
		this.tipovi = new ArrayList <TipClanarine>();
	}
	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}
	public void setAdministratori(ArrayList<Administrator> administratori) {
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

	
	
	
	//funkcija za ucitavanje i snimanje biblioteke
	public static Biblioteka ucitajBiblioteku() {
		try {
			File bibliotekcina = new File("src/fajlovi/Biblioteka.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekcina));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				String naziv = lineSplit[0];
				String adresa = lineSplit[1];
				String telefon = lineSplit[2];
				String radnoVreme = lineSplit[3];
				Biblioteka biblioteka = new Biblioteka(naziv, adresa, telefon, radnoVreme);
				return biblioteka;

				
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
		return null;

	}
	
	public void upisiBiblioteku() {
		String sadrzaj = "";
		sadrzaj += this.naziv + "|" + this.adresa + "|" + this.telefon + "|" + this.radnoVreme + "\n";
		try {
			File bibliotekaFile = new File("src/fajlovi/biblioteka.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(bibliotekaFile));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
		
		 
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
				boolean jeObrisan = Boolean.parseBoolean(lineSplit[9]);
				Administrator administrator = new Administrator(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata, jeObrisan);
				this.administratori.add(administrator);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiAdministratore() {
		String sadrzaj = "";
		for (Administrator administrator : this.administratori) {
			sadrzaj += administrator.getId()+ "|"  + administrator.getIme()+ "|" + administrator.getPrezime() + "|" + administrator.getJMBG() + "|" + administrator.getAdresa()  + "|" + administrator.getPol()  + "|" + administrator.getKorisnickoIme() + 
					"|" + administrator.getKorisnickaSifra()   + "|" + administrator.getPlata() + "|" + administrator.isJeObrisan() +"\n";
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
				boolean jeObrisan = Boolean.parseBoolean(lineSplit[9]);
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata, jeObrisan);
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
					"|" + bibliotekar.getKorisnickaSifra()   + "|" + bibliotekar.getPlata() + "|" + bibliotekar.isJeObrisan() +"\n";
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
	public void ucitajTipClanarine() {
		try {
			File korisniciFile = new File("src/fajlovi/tipClanarine.txt");
			BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naziv = lineSplit[1];
				double cena = Double.parseDouble(lineSplit[2]);
				TipClanarine tip = new TipClanarine(id,naziv,cena, false); //moguca greska ovde !
				this.tipovi.add(tip);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiTipClanarine() {
		String sadrzaj = "";
		for (TipClanarine tip : this.tipovi) {
			sadrzaj += tip.getId()+ "|"  + tip.getNaziv()+ "|" + tip.getCena()+ "\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/tipClanarine.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	
	public TipClanarine nadjiTipClanarine(int id) {
        TipClanarine tip = null;
        this.ucitajClanarinu();
        for (TipClanarine clanarina : this.getTipovi()) {
            if (clanarina.getId() == id) {
                tip = clanarina;
            }
        }
        return tip;
	}
	
	public void ucitajClanove() {
		ucitajClanarinu();           
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
				
				TipClanarine tip = this.nadjiTipClanarine(Integer.parseInt(lineSplit[7]));
				
				LocalDate datumPoslednjeUplate = LocalDate.parse(lineSplit[8]);
				int brojMeseciClanarine = Integer.parseInt(lineSplit[9]);
				boolean isActive = Boolean.parseBoolean(lineSplit[10]);
				boolean jeObrisan = Boolean.parseBoolean(lineSplit[11]);
				ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, jMBG, adresa, pol, brClanKarte, tip, datumPoslednjeUplate, brojMeseciClanarine, isActive, jeObrisan);
				boolean duplikat = false ;
				for(ClanBiblioteke cl : this.getClan()) {
					if(cl.getId() == id) {
						duplikat = true ;
						break;
					}
				}
				if(!duplikat) {
					this.clanovi.add(clan);
				}            
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiClanove() {
		String sadrzaj = "";
		for (ClanBiblioteke clan : this.clanovi) {
			sadrzaj += clan.getId()+ "|"  + clan.getIme()+ "|" + clan.getPrezime() + "|" + clan.getJMBG() + "|" + clan.getAdresa()  + "|" + clan.getPol()  + "|" + clan.getBrClanKarte() + 
					"|" + clan.getTipclanarine() + "|" +clan.getDatumPoslednjeUplate()  + "|" + clan.getBrojMeseciClanarine() + "|" + clan.isActive() + "|" + clan.isJeObrisan() +"\n";
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
				int id = Integer.parseInt(lineSplit[0]);
				String opisZanra = lineSplit[1];
				boolean jeObrisan = Boolean.parseBoolean(lineSplit[2]);
				ZanrKnjige zanr = new ZanrKnjige(id, opisZanra, jeObrisan);
				boolean duplikat = false ;
				for(ZanrKnjige zk : this.getZanrovi()) {
					if(zk.getId() == id) {
						duplikat = true ;
						break;
					}
				}
				if(!duplikat) {
				this.zanrovi.add(zanr);
				}
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiZanr() {
		String sadrzaj = "";
		for (ZanrKnjige zanr : this.zanrovi) {
			sadrzaj += zanr.getId() + "|"  + zanr.getOpisZanra()  + "|" + zanr.isJeObrisan() +"\n";
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

	public void ucitajZanrove() {
        try {
            File korisniciFile = new File("src/fajlovi/zanrovi.txt");
            BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                int id = Integer.parseInt(lineSplit[0]);
                String opis = lineSplit[1];
                boolean jeObrisan = Boolean.parseBoolean(lineSplit[2]);
                ZanrKnjige ZANR = new ZanrKnjige(id, opis, jeObrisan);
                boolean duplikat = false;
                for (ZanrKnjige zr : this.getZanr()) {
                    if (zr.getId() == id) {
                        duplikat = true;
                        break;
                    }
                }
                if (!duplikat) {
                    this.zanrovi.add(ZANR);

                
            }
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }

    }
	public void ucitajKnjige() {
		try {
			File korisniciFile = new File("src/fajlovi/knjiga.txt");
			BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
			String line;
			ucitajZanrove();
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naslovKnjige = lineSplit[1];
				String originalNaslovKnjige = lineSplit[2];
				String pisac = lineSplit[3];
				int godinaObjavljivanja = Integer.parseInt(lineSplit[4]);
				String jezikOriginala = lineSplit[5];
				String opis = lineSplit[6];
				//ZanrKnjige zanrKnjige = this.nadjiZanr(Integer.parseInt(lineSplit[7])) ;       
				int zanrKnjige = Integer.parseInt(lineSplit[7]);
				boolean jeObrisan = Boolean.parseBoolean(lineSplit[8]);
				ZanrKnjige zanr = null ;
				for(ZanrKnjige ZANR : this.zanrovi) {
					if(ZANR.getId()  == zanrKnjige) {
						zanr = ZANR ;
					}
				}
				
				Knjiga knjiga = new Knjiga(id, naslovKnjige, originalNaslovKnjige, pisac, godinaObjavljivanja, jezikOriginala, opis, zanr, jeObrisan);
				boolean duplikat = false ;
				for(Knjiga knjigaa : this.getKnjige()) {
					if(knjigaa.getId() == id) {
						duplikat = true ;
						break;
					}
				}
				if(!duplikat) {
				this.knjige.add(knjiga);
				}
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiKnjige() {
		String sadrzaj = "";
		for (Knjiga knjiga : this.knjige) {
			sadrzaj += knjiga.getId()+ "|"  + knjiga.getNaslovKnjige() + "|" + knjiga.getOriginalNaslovKnjige() + "|" + knjiga.getPisac()+ "|" + knjiga.getGodinaObjavljivanja()  + "|" + knjiga.getJezikOriginala() + "|" + knjiga.getOpis() + 
					"|" + knjiga.getZanr().getId() + "|" + knjiga.isJeObrisan() +"\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/knjiga.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	///////////////////////////////////////
	//Ucitavanje i snimanje primeraka knjgie
	
	public Knjiga nadjiKnjigu(int id) {
        Knjiga trazeni = null;
        for(int i = 0; i < this.knjige.size(); i++) {
            if (this.knjige.get(i).getId()== id) {
                trazeni = this.knjige.get(i);
            }
        }
        return trazeni;
        }
	
	
	public void ucitajPrimerakKnjige() {
		try {
			File korisniciFile = new File("src/fajlovi/primerakKnjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(korisniciFile));
			ucitajZanr();
			ucitajKnjige();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");

				int id = Integer.parseInt(lineSplit[0]);
				int idKnjige = Integer.parseInt(lineSplit[1]);
				int brojStrana = Integer.parseInt(lineSplit[2]);
				TipPoveza tipPoveza = TipPoveza.valueOf(lineSplit[3]);
				String jezikStampanja = lineSplit[4];
				int godinaStampanja = Integer.parseInt(lineSplit[5]);				
				boolean daLiJeIznajmljena = Boolean.parseBoolean(lineSplit[6]);
				boolean jeObrisan = Boolean.parseBoolean(lineSplit[7]);
				boolean duplikat = false;
				Knjiga knjiga = null;
				for (Knjiga primerak : this.knjige) {
					if (primerak.getId() == (idKnjige)) {
						knjiga = primerak;
					}
				}
				
				PrimerakKnjige primerak = new PrimerakKnjige (id, knjiga, brojStrana, tipPoveza, jezikStampanja, godinaStampanja, daLiJeIznajmljena, jeObrisan);
				
				for(PrimerakKnjige pr : this.getPrimerciKnjiga()) {
					if(pr.getId() == id) {
						duplikat = true;
						break;
					}
				}
				if(!duplikat) {
					this.primerciKnjiga.add(primerak);
				}
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}

	public void snimiPrimerakKnjige() {
		String sadrzaj = "";
		for (PrimerakKnjige primerak : this.primerciKnjiga) {
			sadrzaj += primerak.getId() + "|"  + primerak.getKnjige().getId()  + "|" + primerak.getBrStrana() + primerak.getTip() + "|" + primerak.getJezikStampanja() + "|" + primerak.getGodinaStampanja() + "|" + primerak.isDaLiJeIznajmljena() + "|" + primerak.isJeObrisan() +"\n";
		}
		try {
			File korisniciFile = new File("src/fajlovi/primerakKnjige.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	//ARRAY LISTE ZA ADMINE
	public ArrayList<Administrator> getAdmin() {
		return administratori;
	}

	public void addAdmin(Administrator admin) {
		this.administratori.add(admin);
	}

	public void delAdmin(Administrator admin) {
		this.administratori.remove(admin);
	}

	public ArrayList<Administrator> sviAdmini() {
		ArrayList<Administrator> sviadmini = new ArrayList<Administrator>();
		for (Administrator admin : administratori) {
			sviadmini.add(admin);
		}
		return sviadmini;
	}
	
	//ARRAY LISTE ZA BIBLIOTEKARE
	
	public ArrayList<Bibliotekar> getBibliotekari1(){
		return bibliotekari;
	}

	public void addBibliotekar(Bibliotekar novi) {
		this.bibliotekari.add(novi);
	}

	public void delBibliotekar(Bibliotekar bibliotekar) {
		this.bibliotekari.remove(bibliotekar);
	}

	public ArrayList<Bibliotekar> sviBibliotekari() {
		ArrayList<Bibliotekar> svibibliotekari = new ArrayList<Bibliotekar>();
		for (Bibliotekar bibliotekar : bibliotekari) {
			svibibliotekari.add(bibliotekar);
		}
		return svibibliotekari;
	}
	
	//ARRAY LISTE ZA CLANOVE
	
	public ArrayList<ClanBiblioteke> getClan() {
		return clanovi;
	}

	public void addClan(ClanBiblioteke clan) {
		this.clanovi.add(clan);
	}

	public void delClan(ClanBiblioteke clan) {
		this.clanovi.remove(clan);
	}

	public ArrayList<ClanBiblioteke> sviClanovi() {
		ArrayList<ClanBiblioteke> sviclanovi = new ArrayList<ClanBiblioteke>();
		for (ClanBiblioteke clan : clanovi) {
			sviclanovi.add(clan);
		}
		return sviclanovi;
	}
	
	//ARRAY LISTE ZA KNJIGE
	
	public ArrayList<Knjiga> getKnjiga() {
		return knjige;
	}

	public void addKnjiga(Knjiga knjiga) {
		this.knjige.add(knjiga);
	}

	public void delKnjiga(Knjiga knjiga) {
		this.knjige.remove(knjiga);
	}

	public ArrayList<Knjiga> sveKnjige() {
		ArrayList<Knjiga> sveknjige = new ArrayList<Knjiga>();
		for (Knjiga knjiga : knjige) {
			sveknjige.add(knjiga);
		}
		return sveknjige;
	}
	
	//ARRAY LISTE ZA ZANROVE
	
	public ArrayList<ZanrKnjige> getZanr() {
		return zanrovi;
	}

	public void addZanr(ZanrKnjige zanr) {
		this.zanrovi.add(zanr);
	}

	public void delZanr(ZanrKnjige zanr) {
		this.zanrovi.remove(zanr);
	}

	public ArrayList<ZanrKnjige> sviZanrovi() {
		ArrayList<ZanrKnjige> svizanrovi = new ArrayList<ZanrKnjige>();
		for (ZanrKnjige zanr : zanrovi) {
			svizanrovi.add(zanr);
		}
		return svizanrovi;
	}
	public void ucitajClanarinu() {
        try {
            File clanarinaFile = new File("src/fajlovi/tipClanarine.txt");
            BufferedReader reader = new BufferedReader(new FileReader(clanarinaFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                int id = Integer.parseInt(lineSplit[0]);
                String naziv = lineSplit[1];
                double cena = Double.parseDouble(lineSplit[2]);
                boolean jeObrisan = false;
               
                
                TipClanarine clanarina = new TipClanarine(id, naziv, cena, jeObrisan);
                this.tipovi.add(clanarina);
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
        }
    }
	
	public TipClanarine nadji_TipClanarine(int id) {
        TipClanarine tip = null;
        this.ucitajClanarinu();
        for (TipClanarine clanarina : this.getTipovi()) {
            if (clanarina.getId() == id) {
                tip = clanarina;
            }
        }
        return tip;
	}
	
	public ArrayList<ClanBiblioteke> get_Clan() {
        return clanovi;
    }

    public void add_Clan(ClanBiblioteke clan) {
        this.clanovi.add(clan);
    }

    public void del_Clan(ClanBiblioteke clan) {
        this.clanovi.remove(clan);
    }

    public ArrayList<ClanBiblioteke> svi_Clanovi() {
        ArrayList<ClanBiblioteke> sviclanovi = new ArrayList<ClanBiblioteke>();
        for (ClanBiblioteke clan : clanovi) {
            sviclanovi.add(clan);
        }
        return sviclanovi;
    }

	//ARRAY LISTE ZA PRIMERKE KNJIGE
	
	public ArrayList<PrimerakKnjige> getPrimerakKnjige() {
		return primerciKnjiga;
	}

	public void addPrimer(PrimerakKnjige knjiga) {
		this.primerciKnjiga.add(knjiga);
	}

	public void delPrimer(PrimerakKnjige knjiga) {
		this.primerciKnjiga.remove(knjiga);
	}

	public ArrayList<PrimerakKnjige> sviPrimeri() {
		ArrayList<PrimerakKnjige> sviprimeri = new ArrayList<PrimerakKnjige>();
		for (PrimerakKnjige knjiga : primerciKnjiga) {
			sviprimeri.add(knjiga);
		}
		return sviprimeri;
	}
	
	// ADMIN LOGIN I BIBLIOTEKAR LOGIN TREBA ZA LOGIN PROZOR KONJU
	public Administrator adminLogin(String korisnickoIme, String lozinka) {
        for (Administrator admin : administratori) {
            if (admin.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && admin.getKorisnickaSifra().equals(lozinka)) {
                return admin;
            }
        }
        return null;
    }

    public Bibliotekar bibliotekarLogin(String korisnickoIme, String lozinka) {
        for (Bibliotekar bibliotekar : bibliotekari) {
            if (bibliotekar.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)
                    && bibliotekar.getKorisnickaSifra().equals(lozinka)) {
                return bibliotekar;
            }
        }
        return null;
    }
	
	
	
}
