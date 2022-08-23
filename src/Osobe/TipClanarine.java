package Osobe;

public class TipClanarine {
	private int id ;
	private String naziv ;
	private double cena ;
	private boolean jeObrisan;
	
	public TipClanarine() {
		super();
	}

	public TipClanarine(int id, String naziv, double cena, boolean jeObrisan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.jeObrisan = jeObrisan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}

	
	
	
}
