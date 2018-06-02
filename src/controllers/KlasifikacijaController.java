package controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import klasifikacija.beans.KlasifikacijaBean;
import klasifikacija.entities.Aktivnost;
import klasifikacija.entities.Proces;
import klasifikacija.entities.ZbirniElement;
import klasifikacija.incomingEntities.KarakterCheckRequest;

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
	
	//Prikazuje procese koji proizvode otpad
	@GET
	@Path("/procesi")
	@Produces("text/json")
	public List<Proces> getProcesi(){
		return logic.getProcesi();
	}
	
	//prikazuje kompletan zbirni katalog
	@GET
	@Path("/zbirniKatalog")
	@Produces("text/json")
	public List<ZbirniElement> getElemes(){
		return logic.getZbirnaLista();
	}
	
	//Vraca karakter trazenog otpada
	@POST
	@Path("/proveriKarakter")
	@Consumes("application/json")
	@Produces("text/json")
	public List<String> statusCheck(List<KarakterCheckRequest> check){
		return logic.checkStatus(check);
	}
	
	
	//Sav otpad sa karakterom
	
	@POST
	@Path("/otpadSaKarakterom")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("text/json")
	public List<ZbirniElement> karakterCheck(String karakter){
		System.out.println(karakter);
		return logic.otpadSaKarakterom(karakter,"KARAKTER");
	}
	
	
	//Sav otpad od aktivnosti

	@POST
	@Path("/otpadIzAktivnosti")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("text/json")
	public List<ZbirniElement> otpadIzAktivnosti(String aktivnost){
		return logic.otpadSaKarakterom(aktivnost,"INDEKS_A");
	}
	
	//sav otpad od procesa nastajanja
	@POST
	@Path("/otpadIzProcesaNastajanja")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("text/json")
	public List<ZbirniElement> otpadIzProcesaNastajanja(String proces){
		return logic.otpadSaKarakterom(proces,"INDEKS_PNO");
	}
	
	
	//sav otpad iz dela procesa nastajanja
	@POST
	@Path("/otpadIzDelaProcesaNastajanja")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("text/json")
	public List<ZbirniElement> otpadIzDelaProcesaNastajanja(String deoProcesa){
		return logic.otpadSaKarakterom(deoProcesa,"INJDEKS_DPN");
	}
}
