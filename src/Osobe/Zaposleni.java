package Osobe;

import java.time.LocalDate;

public abstract class Zaposleni extends Osoba{
	private String korisnickoIme;
	private String korisnickaSifra;
	private double plata ;
	
	public Zaposleni() {
		
	}

	public Zaposleni(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaSifra, double plata) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.korisnickoIme = korisnickoIme;
		this.korisnickaSifra = korisnickaSifra;
		this.plata = plata;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getKorisnickaSifra() {
		return korisnickaSifra;
	}

	public void setKorisnickaSifra(String korisnickaSifra) {
		this.korisnickaSifra = korisnickaSifra;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public ClanBiblioteke dodajClana(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String brClanKarte,
			TipClanarine tipclanarine, LocalDate datumPoslednjeUplate, int brojMeseciClanarine, boolean isActive) {
		ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, jMBG, adresa, pol, brClanKarte, tipclanarine, datumPoslednjeUplate, brojMeseciClanarine, isActive);
		return clan;
	}
	
	
}
