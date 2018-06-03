package entities;

public class KorisceneTehnologije {

	private String sifraTehnologije;
	private String nazivTehnologije;
	private String opisTehnologija;
	
	public KorisceneTehnologije() {
		
	}
	
	public KorisceneTehnologije(String sifraTehnologije, String nazivTehnologije, String opisTehnologija) {
		this.sifraTehnologije = sifraTehnologije;
		this.nazivTehnologije = nazivTehnologije;
		this.opisTehnologija = opisTehnologija;
	}

	public String getSifraTehnologije() {
		return sifraTehnologije;
	}

	public void setSifraTehnologije(String sifraTehnologije) {
		this.sifraTehnologije = sifraTehnologije;
	}

	public String getNazivTehnologije() {
		return nazivTehnologije;
	}

	public void setNazivTehnologije(String nazivTehnologije) {
		this.nazivTehnologije = nazivTehnologije;
	}

	public String getOpisTehnologija() {
		return opisTehnologija;
	}

	public void setOpisTehnologija(String opisTehnologija) {
		this.opisTehnologija = opisTehnologija;
	}
	
	
	
}
