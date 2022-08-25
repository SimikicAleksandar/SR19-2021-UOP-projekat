package knjige;

public class ZanrKnjige {
	private int id;
	private String opisZanra;
	private boolean jeObrisan;
		
	public ZanrKnjige() {
		super();
	}
	
	public ZanrKnjige(int id, String opisZanra, boolean jeObrisan) {
		super();
		this.id = id;
		this.opisZanra = opisZanra;
		this.jeObrisan = jeObrisan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpisZanra() {
		return opisZanra;
	}
	public void setOpisZanra(String opisZanra) {
		this.opisZanra = opisZanra;
	}
	public boolean isJeObrisan() {
		return jeObrisan;
	}
	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}


	
}
