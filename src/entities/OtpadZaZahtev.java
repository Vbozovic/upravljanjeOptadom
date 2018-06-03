package entities;

public class OtpadZaZahtev {

	private char indexPNO;
	private char indexA;
	private String indexKO;
	private char indexDPN;
	private int brojZahteva;
	private int kolicina;
	
	public OtpadZaZahtev() {
		
	}
		
	public OtpadZaZahtev(char indexPNO, char indexA, String indexKO, char indexDPN, int brojZahteva, int kolicina) {
		this.indexPNO = indexPNO;
		this.indexA = indexA;
		this.indexKO = indexKO;
		this.indexDPN = indexDPN;
		this.brojZahteva = brojZahteva;
		this.kolicina = kolicina;
	}

	public char getIndexPNO() {
		return indexPNO;
	}
	public void setIndexPNO(char indexPNO) {
		this.indexPNO = indexPNO;
	}
	public char getIndexA() {
		return indexA;
	}
	public void setIndexA(char indexA) {
		this.indexA = indexA;
	}
	public String getIndexKO() {
		return indexKO;
	}
	public void setIndexKO(String indexKO) {
		this.indexKO = indexKO;
	}
	public char getIndexDPN() {
		return indexDPN;
	}
	public void setIndexDPN(char indexDPN) {
		this.indexDPN = indexDPN;
	}
	public int getBrojZahteva() {
		return brojZahteva;
	}
	public void setBrojZahteva(int brojZahteva) {
		this.brojZahteva = brojZahteva;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	
	
}
