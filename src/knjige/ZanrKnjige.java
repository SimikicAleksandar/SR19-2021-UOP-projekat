package knjige;

public class ZanrKnjige {
	private String oznaka;
	private String opisZanra;
	private boolean jeObrisan;

	public ZanrKnjige(String oznaka, String opisZanra, boolean jeObrisan) {
		super();
		this.oznaka = oznaka;
		this.opisZanra = opisZanra;
		this.jeObrisan = jeObrisan;
	}

	public boolean isJeObrisan() {
		return jeObrisan;
	}

	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}

	public ZanrKnjige() {
		super();
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpisZanra() {
		return opisZanra;
	}
   
	public void setOpisZanra(String opisZanra) {
		this.opisZanra = opisZanra;
	}

	
}
