package entities;

public class Izdavac {
	
	private int idIzdavaca;
	private String nazivIzdavaca;
	
	public Izdavac() {
		
	}
	
	public Izdavac(int idIzdavaca, String nazivIzdavaca) {		
		this.idIzdavaca = idIzdavaca;
		this.nazivIzdavaca = nazivIzdavaca;
	}

	public int getIdIzdavaca() {
		return idIzdavaca;
	}

	public void setIdIzdavaca(int idIzdavaca) {
		this.idIzdavaca = idIzdavaca;
	}

	public String getNazivIzdavaca() {
		return nazivIzdavaca;
	}

	public void setNazivIzdavaca(String nazivIzdavaca) {
		this.nazivIzdavaca = nazivIzdavaca;
	}
		
}
