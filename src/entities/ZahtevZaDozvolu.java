package entities;

public class ZahtevZaDozvolu {
	
	private int brojZahteva;
	private String nazivPodnosioca;
	private int idPostrojenja;
	private String kodDozvole;
	private int odobren;
	
	public ZahtevZaDozvolu() {
		
	}	
	
	public ZahtevZaDozvolu(int brojZahteva, String nazivPodnosioca, int idPostrojenja, String kodDozvole, int odobren) {
		this.brojZahteva = brojZahteva;
		this.nazivPodnosioca = nazivPodnosioca;
		this.idPostrojenja = idPostrojenja;
		this.kodDozvole = kodDozvole;
		this.odobren = odobren;
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
	public int getIdPostrojenja() {
		return idPostrojenja;
	}
	public void setIdPostrojenja(int idPostrojenja) {
		this.idPostrojenja = idPostrojenja;
	}
	public String getKodDozvole() {
		return kodDozvole;
	}
	public void setKodDozvole(String kodDozvole) {
		this.kodDozvole = kodDozvole;
	}
	public int getOdobren() {
		return odobren;
	}
	public void setOdobren(int odobren) {
		this.odobren = odobren;
	}
	
	
	
}
