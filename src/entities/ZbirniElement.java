package entities;

public class ZbirniElement {

	private String indeksAktivnosti;
	private String indeksProcesa;
	private String indeksDelaProcesa;
	private String opis;
	private String karakter;
	
	
	public ZbirniElement() {
		super();
	}



	public ZbirniElement(String indeksAktivnosti, String indeksProcesa, String indeksDelaProcesa, String opis) {
		super();
		this.indeksAktivnosti = indeksAktivnosti;
		this.indeksProcesa = indeksProcesa;
		this.indeksDelaProcesa = indeksDelaProcesa;
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



	public String getIndeksDelaProcesa() {
		return indeksDelaProcesa;
	}



	public void setIndeksDelaProcesa(String indeksDelaProcesa) {
		this.indeksDelaProcesa = indeksDelaProcesa;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}



	public String getKarakter() {
		return karakter;
	}



	public void setKarakter(String karakter) {
		this.karakter = karakter;
	}
	
	
	
}
