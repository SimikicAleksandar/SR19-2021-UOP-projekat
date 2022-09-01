package knjige;

import java.time.LocalDate;
import Osobe.ClanBiblioteke;
import Osobe.Zaposleni;

public class Izdavanje {
	private Zaposleni zaposleni;
	private ClanBiblioteke clanovi;
	private PrimerakKnjige primerci;
	private LocalDate datumIznajmljivanja;
	private LocalDate datumVracanja;
	
	public Izdavanje() {
		super();
	}

	public Izdavanje(Zaposleni zaposleni, ClanBiblioteke clanovi, PrimerakKnjige primerci,
			LocalDate datumIznajmljivanja, LocalDate datumVracanja) {
		super();
		this.zaposleni = zaposleni;
		this.clanovi = clanovi;
		this.primerci = primerci;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public ClanBiblioteke getClanovi() {
		return clanovi;
	}

	public void setClanovi(ClanBiblioteke clanovi) {
		this.clanovi = clanovi;
	}

	public PrimerakKnjige getPrimerak() {
		return primerci;
	}

	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerci = primerak;
	}

	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}

	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}

	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	
	
	
	
}
