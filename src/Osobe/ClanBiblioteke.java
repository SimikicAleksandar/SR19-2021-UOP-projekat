package Osobe;

import java.time.LocalDate;

public class ClanBiblioteke extends Osoba{

	private String brClanKarte;
	private TipClanarine tipclanarine ;
	private LocalDate datumPoslednjeUplate ;
	private int brojMeseciClanarine;
	private boolean isActive ;
	
	public ClanBiblioteke() {
		super();
	}

	public ClanBiblioteke(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, String brClanKarte,
			TipClanarine tipclanarine, LocalDate datumPoslednjeUplate, int brojMeseciClanarine, boolean isActive) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.brClanKarte = brClanKarte;
		this.tipclanarine = tipclanarine;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.isActive = isActive;
	}

	public String getBrClanKarte() {
		return brClanKarte;
	}

	public void setBrClanKarte(String brClanKarte) {
		this.brClanKarte = brClanKarte;
	}

	public TipClanarine getTipclanarine() {
		return tipclanarine;
	}

	public void setTipclanarine(TipClanarine tipclanarine) {
		this.tipclanarine = tipclanarine;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrojMeseciClanarine() {
		return brojMeseciClanarine;
	}

	public void setBrojMeseciClanarine(int brojMeseciClanarine) {
		this.brojMeseciClanarine = brojMeseciClanarine;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
