package Osobe;

public class Adminisatrator extends Zaposleni {

	public Adminisatrator(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaSifra, double plata) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
	}
	
	public Bibliotekar registrujZaposlenog(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaSifra, double plata) {
		Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jMBG, adresa, pol, korisnickoIme,
		korisnickaSifra, plata);
		return bibliotekar;
	}
}
