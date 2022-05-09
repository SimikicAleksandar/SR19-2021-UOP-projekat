package knjige;

public class Knjiga{
	private int id ;
	private String naslovKnjige ;
	private String originalNaslovKnjige ;
	private String pisac ;
	private int godinaObjavljivanja ;
	private String jezikOriginala ; 
	private String opis ;
	private ZanrKnjige zanr;
	
	public Knjiga() {
		super();
	}

	public Knjiga(int id, String naslovKnjige, String originalNaslovKnjige, String pisac, int godinaObjavljivanja,
			String jezikOriginala, String opis, ZanrKnjige zanr) {
		super();
		this.id = id;
		this.naslovKnjige = naslovKnjige;
		this.originalNaslovKnjige = originalNaslovKnjige;
		this.pisac = pisac;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.jezikOriginala = jezikOriginala;
		this.opis = opis;
		this.zanr = zanr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaslovKnjige() {
		return naslovKnjige;
	}

	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}

	public String getOriginalNaslovKnjige() {
		return originalNaslovKnjige;
	}

	public void setOriginalNaslovKnjige(String originalNaslovKnjige) {
		this.originalNaslovKnjige = originalNaslovKnjige;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(String jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public ZanrKnjige getZanr() {
		return zanr;
	}

	public void setZanr(ZanrKnjige zanr) {
		this.zanr = zanr;
	}
	
	
	
	
	
	
	
	
	
}
