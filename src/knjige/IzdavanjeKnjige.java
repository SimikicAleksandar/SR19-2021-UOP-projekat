package knjige;

import Osobe.Zaposleni;

public class IzdavanjeKnjige extends Zaposleni{
	private Zaposleni zaposleni;

	
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
	
	
	
	
}
