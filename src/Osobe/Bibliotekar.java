package Osobe;

public class Bibliotekar extends Zaposleni{
	private boolean jeObrisan ;
	
	public Bibliotekar() {
		super();
		
	}

	public Bibliotekar(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String korisnickoIme,
			String korisnickaSifra, double plata, boolean jeObrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
		this.jeObrisan = jeObrisan ;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}



}
