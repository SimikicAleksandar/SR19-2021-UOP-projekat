package knjige;


import java.time.LocalDate;

import Osobe.ClanBiblioteke;
import Osobe.Pol;
import Osobe.Zaposleni;

public class IzdavanjeKnjige extends Zaposleni{
	private Zaposleni zaposleni;
	private ClanBiblioteke clan;
	private PrimerakKnjige primerak;
	private LocalDate datumIzdavanja;
	private LocalDate datumVracanja;
	
	
	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public IzdavanjeKnjige() {
		super();
	}

	public IzdavanjeKnjige(Zaposleni zaposleni) {
		super();
		this.zaposleni = zaposleni;
	}

	public ClanBiblioteke getClan() {
		return clan;
	}

	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}

	public PrimerakKnjige getPrimerak() {
		return primerak;
	}

	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
	}

	

	public IzdavanjeKnjige(int id, String ime, String prezime, String jMBG, String adresa, Pol pol,
			String korisnickoIme, String korisnickaSifra, double plata, Zaposleni zaposleni, ClanBiblioteke clan,
			PrimerakKnjige primerak, LocalDate datumIzdavanja, LocalDate datumVracanja) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerak = primerak;
		this.setDatumIzdavanja(datumIzdavanja);
		this.setDatumVracanja(datumVracanja);
	}

	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public LocalDate getDatumIzdavanja() {
		return datumIzdavanja;
	}

	public void setDatumIzdavanja(LocalDate datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}

	
	
	
	
}
