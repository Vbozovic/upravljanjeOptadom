package entities;

public class ZbirniKatalog {

	private char indexPNO;
	private char indexA;
	private String indexKO;
	private char indexDPN;
	private String indexC;
	private String karakter;
	private String indexH;
	private String opis;
	
	public ZbirniKatalog() {
		
	}
	
	public ZbirniKatalog(char indexPNO, char indexA, String indexKO, char indexDPN, String indexC, String karakter,
			String indexH, String opis) {
		this.indexPNO = indexPNO;
		this.indexA = indexA;
		this.indexKO = indexKO;
		this.indexDPN = indexDPN;
		this.indexC = indexC;
		this.karakter = karakter;
		this.indexH = indexH;
		this.opis = opis;
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
	public String getIndexC() {
		return indexC;
	}
	public void setIndexC(String indexC) {
		this.indexC = indexC;
	}
	public String getKarakter() {
		return karakter;
	}
	public void setKarakter(String karakter) {
		this.karakter = karakter;
	}
	public String getIndexH() {
		return indexH;
	}
	public void setIndexH(String indexH) {
		this.indexH = indexH;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
	
}
