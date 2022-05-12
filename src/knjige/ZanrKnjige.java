package knjige;

public class ZanrKnjige {
	private String oznaka;
	private String opisZanra;

	public ZanrKnjige(String oznaka, String opisZanra) {
		super();
		this.oznaka = oznaka;
		this.opisZanra = opisZanra;
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
