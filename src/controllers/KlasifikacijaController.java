package controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import beans.KlasifikacijaBean;
import entities.Aktivnost;
import entities.Proces;
import entities.ZbirniElement;

@Stateless
@LocalBean
@Path("/klasifikacija")
public class KlasifikacijaController {

	private KlasifikacijaBean logic;
	
	
	public KlasifikacijaController() {
		// TODO Auto-generated constructor stub
		logic = new KlasifikacijaBean();
	}
	
	
	@GET
	@Path("/aktivnosti")
	@Produces("text/json")
	public List<Aktivnost> getAktivnosti(){
		return logic.getAktivnosti();
	}
	
	
	
	@GET
	@Path("/procesi")
	@Produces("text/json")
	public List<Proces> getProcesi(){
		return logic.getProcesi();
	}
	
	
	@GET
	@Path("/zbirniKatalog")
	@Produces("text/json")
	public List<ZbirniElement> getElemes(){
		return logic.getZbirnaLista();
	}
	
}
