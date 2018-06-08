package postrojenja.entities;

public class RezultatStatistike {

	private int idPostrojenja;
	private String aktivnost;
	private String indeks_ko;
	private String procesNastajanja;
	private String deoProcesa;
	private String nazivOblasti;
	private long suma;
	public RezultatStatistike() {
		super();
	}
	public int getIdPostrojenja() {
		return idPostrojenja;
	}
	public void setIdPostrojenja(int idPostrojenja) {
		this.idPostrojenja = idPostrojenja;
	}
	public String getAktivnost() {
		return aktivnost;
	}
	public void setAktivnost(String aktivnost) {
		this.aktivnost = aktivnost;
	}
	public String getIndeks_ko() {
		return indeks_ko;
	}
	public void setIndeks_ko(String indeks_ko) {
		this.indeks_ko = indeks_ko;
	}
	public String getProcesNastajanja() {
		return procesNastajanja;
	}
	public void setProcesNastajanja(String procesNastajanja) {
		this.procesNastajanja = procesNastajanja;
	}
	public String getDeoProcesa() {
		return deoProcesa;
	}
	public void setDeoProcesa(String deoProcesa) {
		this.deoProcesa = deoProcesa;
	}
	public String getNazivOblasti() {
		return nazivOblasti;
	}
	public void setNazivOblasti(String nazivOblasti) {
		this.nazivOblasti = nazivOblasti;
	}
	public long getSuma() {
		return suma;
	}
	public void setSuma(long suma) {
		this.suma = suma;
	}
	
	
	
}
