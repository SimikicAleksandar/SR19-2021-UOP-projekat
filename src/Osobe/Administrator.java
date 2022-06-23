package Osobe;

public class Administrator extends Zaposleni {
	private boolean jeObrisan ;
	
	public Administrator(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaSifra, double plata, boolean jeObrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
		this.jeObrisan = jeObrisan ;
	}
	
	public Bibliotekar registrujZaposlenog(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaSifra, double plata) {
		Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jMBG, adresa, pol, korisnickoIme,
		korisnickaSifra, plata, jeObrisan);
		return bibliotekar;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	
	
}
