package knjige;

public class PrimerakKnjige {
	private int id;
	private Knjiga knjige;
	private int brStrana;
	private TipPoveza tip;
	private String jezikStampanja;
	private int godinaStampanja;
	private boolean daLiJeIznajmljena;
	private boolean jeObrisan ;
	
	public PrimerakKnjige() {
		super();
	}
	
	public PrimerakKnjige(int id, Knjiga knjige, int brStrana, TipPoveza tip, String jezikStampanja,
			int godinaStampanja, boolean daLiJeIznajmljena, boolean jeObrisan) {
		super();
		this.id = id;
		this.knjige = knjige;
		this.brStrana = brStrana;
		this.tip = tip;
		this.jezikStampanja = jezikStampanja;
		this.godinaStampanja = godinaStampanja;
		this.daLiJeIznajmljena = daLiJeIznajmljena;
		this.jeObrisan = jeObrisan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Knjiga getKnjige() {
		return knjige;
	}
	public void setKnjige(Knjiga knjige) {
		this.knjige = knjige;
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
	public String getJezikStampanja() {
		return jezikStampanja;
	}
	public void setJezikStampanja(String jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}
	public int getGodinaStampanja() {
		return godinaStampanja;
	}
	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
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
