package knjige;

public class PrimerakKnjige {
	private Knjiga knjiga ;
	private int idPrimerka ;
	private int brStrana;
	private TipPoveza tip;
	private int godinaStampanja;
	private String jezikStampanja;
	private boolean daLiJeIznajmljena;
	private boolean jeObrisan ;
	
	public PrimerakKnjige() {
		super();
	}

	public PrimerakKnjige(Knjiga knjiga, int idPrimerka, int brStrana, TipPoveza tip, int godinaStampanja,
			String jezikStampanja, boolean daLiJeIznajmljena, boolean jeObrisan) {
		super();
		this.knjiga = knjiga;
		this.idPrimerka = idPrimerka;
		this.brStrana = brStrana;
		this.tip = tip;
		this.godinaStampanja = godinaStampanja;
		this.jezikStampanja = jezikStampanja;
		this.daLiJeIznajmljena = daLiJeIznajmljena;
		this.jeObrisan = jeObrisan;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public int getIdPrimerka() {
		return idPrimerka;
	}

	public void setIdPrimerka(int idPrimerka) {
		this.idPrimerka = idPrimerka;
	}

	public int getBrStrana() {
		return brStrana;
	}

	public void setBrStrana(int brStrana) {
		this.brStrana = brStrana;
	}

	public TipPoveza getTip() {
		return tip;
	}

	public void setTip(TipPoveza tip) {
		this.tip = tip;
	}

	public int getGodinaStampanja() {
		return godinaStampanja;
	}

	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}

	public String getJezikStampanja() {
		return jezikStampanja;
	}

	public void setJezikStampanja(String jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}

	public boolean isDaLiJeIznajmljena() {
		return daLiJeIznajmljena;
	}

	public void setDaLiJeIznajmljena(boolean daLiJeIznajmljena) {
		this.daLiJeIznajmljena = daLiJeIznajmljena;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}
	
	
	
	
	
}
