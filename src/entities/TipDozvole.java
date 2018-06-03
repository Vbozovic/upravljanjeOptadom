package entities;

public class TipDozvole {
	
	private String kodDozvole;
	private String opisDozvole;
	
	public TipDozvole() {
		
	}
	
	public TipDozvole(String kodDozvole, String opisDozvole) {
		this.kodDozvole = kodDozvole;
		this.opisDozvole = opisDozvole;
	}

	public String getKodDozvole() {
		return kodDozvole;
	}
	public void setKodDozvole(String kodDozvole) {
		this.kodDozvole = kodDozvole;
	}
	public String getOpisDozvole() {
		return opisDozvole;
	}
	public void setOpisDozvole(String opisDozvole) {
		this.opisDozvole = opisDozvole;
	}
	
	
	
}
