package postrojenja.entities;

public class Postrojenje {

	private int idPostrojenja;
	private String tipOtpada;
	private String grad;
	private String opstina;
	private String opis;
	private String jmbgZaduzenog;
	private String imeZaduzenog;
	
	
	
	public Postrojenje() {
		super();
	}
	public int getIdPostrojenja() {
		return idPostrojenja;
	}
	public void setIdPostrojenja(int idPostrojenja) {
		this.idPostrojenja = idPostrojenja;
	}
	public String getTipOtpada() {
		return tipOtpada;
	}
	public void setTipOtpada(String tipOtpada) {
		this.tipOtpada = tipOtpada;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getOpstina() {
		return opstina;
	}
	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getJmbgZaduzenog() {
		return jmbgZaduzenog;
	}
	public void setJmbgZaduzenog(String jmbgZaduzenog) {
		this.jmbgZaduzenog = jmbgZaduzenog;
	}
	public String getImeZaduzenog() {
		return imeZaduzenog;
	}
	public void setImeZaduzenog(String imeZaduzenog) {
		this.imeZaduzenog = imeZaduzenog;
	}
	
	
	
}
