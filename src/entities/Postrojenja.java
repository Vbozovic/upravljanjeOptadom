package entities;

public class Postrojenja {

	private int idPostrojenja;
	private int idTipa2;
	private String jmbg;
	private String imeLica;
	private int ukupanKapacitet;
	
	public Postrojenja() {
		
	}
	
	public Postrojenja(int idPostrojenja, int idTipa2, String jmbg, String imeLica, int ukupanKapacitet) {
		this.idPostrojenja = idPostrojenja;
		this.idTipa2 = idTipa2;
		this.jmbg = jmbg;
		this.imeLica = imeLica;
		this.ukupanKapacitet = ukupanKapacitet;
	}
	
	public int getIdPostrojenja() {
		return idPostrojenja;
	}
	public void setIdPostrojenja(int idPostrojenja) {
		this.idPostrojenja = idPostrojenja;
	}
	public int getIdTipa2() {
		return idTipa2;
	}
	public void setIdTipa2(int idTipa2) {
		this.idTipa2 = idTipa2;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getImeLica() {
		return imeLica;
	}
	public void setImeLica(String imeLica) {
		this.imeLica = imeLica;
	}
	public int getUkupanKapacitet() {
		return ukupanKapacitet;
	}
	public void setUkupanKapacitet(int ukupanKapacitet) {
		this.ukupanKapacitet = ukupanKapacitet;
	}
	
	
	
}
