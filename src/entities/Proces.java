package entities;

public class Proces {

	private String indeksAktivnosti;
	private String indeksProcesa;
	private String opis;
	
	
	public Proces() {
		super();
	}
	public Proces(String indeksAktivnosti, String indeksProcesa, String opis) {
		super();
		this.indeksAktivnosti = indeksAktivnosti;
		this.indeksProcesa = indeksProcesa;
		this.opis = opis;
	}
	public String getIndeksAktivnosti() {
		return indeksAktivnosti;
	}
	public void setIndeksAktivnosti(String indeksAktivnosti) {
		this.indeksAktivnosti = indeksAktivnosti;
	}
	public String getIndeksProcesa() {
		return indeksProcesa;
	}
	public void setIndeksProcesa(String indeksProcesa) {
		this.indeksProcesa = indeksProcesa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
}
