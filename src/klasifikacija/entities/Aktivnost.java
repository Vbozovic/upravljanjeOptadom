package klasifikacija.entities;

public class Aktivnost {

	private String indeks;
	private String opis;
	
	
	public Aktivnost() {
		super();
	}
	public Aktivnost(String indeks, String opis) {
		super();
		this.indeks = indeks;
		this.opis = opis;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
}
