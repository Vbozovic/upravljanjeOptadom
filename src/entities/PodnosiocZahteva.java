package entities;

public class PodnosiocZahteva {
	
	private String nazivPodnosioca;
	private String imeOdgovornogLica;
	private String prezimeOdgovornogLica;
	private String adresaLica;
	private String brojTelefona;
	private String brojFaksa;
	private String emailOdgovornogLica;	
	private int brojZahteva;
	
	public PodnosiocZahteva() {
		
	}
	
	
	public PodnosiocZahteva(String nazivPodnosioca, String imeOdgovornogLica, String prezimeOdgovornogLica,
			String adresaLica, String brojTelefona, String brojFaksa, String emailOdgovornogLica, int brojZahteva) {
		
		this.nazivPodnosioca = nazivPodnosioca;
		this.imeOdgovornogLica = imeOdgovornogLica;
		this.prezimeOdgovornogLica = prezimeOdgovornogLica;
		this.adresaLica = adresaLica;
		this.brojTelefona = brojTelefona;
		this.brojFaksa = brojFaksa;
		this.emailOdgovornogLica = emailOdgovornogLica;
		this.brojZahteva = brojZahteva;
		
	}
	
	public int getBrojZahteva() {
		return brojZahteva;
	}
	
	public void setBrojZahteva(int brojZahteva) {
		this.brojZahteva = brojZahteva;
	}
	
	public String getNazivPodnosioca() {
		return nazivPodnosioca;
	}
	public void setNazivPodnosioca(String nazivPodnosioca) {
		this.nazivPodnosioca = nazivPodnosioca;
	}
	public String getImeOdgovornogLica() {
		return imeOdgovornogLica;
	}
	public void setImeOdgovornogLica(String imeOdgovornogLica) {
		this.imeOdgovornogLica = imeOdgovornogLica;
	}
	public String getPrezimeOdgovornogLica() {
		return prezimeOdgovornogLica;
	}
	public void setPrezimeOdgovornogLica(String prezimeOdgovornogLica) {
		this.prezimeOdgovornogLica = prezimeOdgovornogLica;
	}
	public String getAdresaLica() {
		return adresaLica;
	}
	public void setAdresaLica(String adresaLica) {
		this.adresaLica = adresaLica;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getBrojFaksa() {
		return brojFaksa;
	}
	public void setBrojFaksa(String brojFaksa) {
		this.brojFaksa = brojFaksa;
	}
	public String getEmailOdgovornogLica() {
		return emailOdgovornogLica;
	}
	public void setEmailOdgovornogLica(String emailOdgovornogLica) {
		this.emailOdgovornogLica = emailOdgovornogLica;
	}
	
	
	
	
}
