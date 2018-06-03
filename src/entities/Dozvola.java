package entities;

public class Dozvola {
	
	private int brojDozvole;
	private int idIzdavaca;
	private String kodDozvole;
	
	public Dozvola() {
		
	}	
	
	//vuk no homo
	public Dozvola(int brojDozvole, int idIzdavaca, String kodDozvole) {
		this.brojDozvole = brojDozvole;
		this.idIzdavaca = idIzdavaca;
		this.kodDozvole = kodDozvole;
	}

	public int getBrojDozvole() {
		return brojDozvole;
	}

	public void setBrojDozvole(int brojDozvole) {
		this.brojDozvole = brojDozvole;
	}

	public int getIdIzdavaca() {
		return idIzdavaca;
	}

	public void setIdIzdavaca(int idIzdavaca) {
		this.idIzdavaca = idIzdavaca;
	}

	public String getKodDozvole() {
		return kodDozvole;
	}

	public void setKodDozvole(String kodDozvole) {
		this.kodDozvole = kodDozvole;
	}
	
	
	
}
