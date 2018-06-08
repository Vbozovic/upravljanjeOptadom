package entities;

public class StatistikaKapacitetPostrojenja {

	private int idPostrojenja;
	private int kapacitetPostrojenja;
	
	public StatistikaKapacitetPostrojenja() {
		
	}
	
	public StatistikaKapacitetPostrojenja(int idPostrojenja, int kapacitetPostrojenja) {
		this.idPostrojenja = idPostrojenja;
		this.kapacitetPostrojenja = kapacitetPostrojenja;
	}

	public int getIdPostrojenja() {
		return idPostrojenja;
	}

	public void setIdPostrojenja(int idPostrojenja) {
		this.idPostrojenja = idPostrojenja;
	}

	public int getKapacitetPostrojenja() {
		return kapacitetPostrojenja;
	}

	public void setKapacitetPostrojenja(int kapacitetPostrojenja) {
		this.kapacitetPostrojenja = kapacitetPostrojenja;
	}
	
	
	
}
