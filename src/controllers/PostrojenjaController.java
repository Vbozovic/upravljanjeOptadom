package controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import postrojenja.beans.PostrojenjeBean;
import postrojenja.incomingEntities.LokacijaSearch;
import postrojenja.incomingEntities.TypeSearch;
import postrojenja.entities.Postrojenje;
import postrojenja.entities.ZbirniElement;

@Stateless
@LocalBean
@Path("/postrojenja")
public class PostrojenjaController {

	PostrojenjeBean logic=null;
	
	public PostrojenjaController(){
		logic = new PostrojenjeBean();
	}
	
	
	@POST
	@Path("/postrojenjaZaTipOtpada")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/json")
	public List<Postrojenje> getPostrojenjaSaTipom(TypeSearch tip){
		return logic.getPostrojenjaSaTipom(tip);
	}
	
	@GET
	@Path("/svaPostrojenja")
	@Produces("text/json")
	public List<Postrojenje> getsvaPostrojenja(){
		return logic.getPostrojenja();
	}
	
	@POST
	@Path("/postrojenjaGrad")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/json")
	public List<Postrojenje> getPostrojenjaPoGradu(LokacijaSearch sr){
		return logic.getPostrojenjaSaKolonaEquals("NAZIV_GRADA", sr.getNaziv());
	}
	
	@POST
	@Path("/postrojenjaOpstina")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/json")
	public List<Postrojenje> getPostrojenjaPoOpstini(LokacijaSearch sr){
		return logic.getPostrojenjaSaKolonaEquals("NAZIV_OPSTINE", sr.getNaziv());
	}
	
	@GET
	@Path("/inventar/{id}")
	@Produces("text/json")
	public List<ZbirniElement> getinvenarSpecific(@PathParam("id") int id){
		return logic.inventarZaSpecificnoPostrojenje(id);
	}
	
	@GET
	@Path("/inventarG/{grad}")
	@Produces("text/json")
	public List<ZbirniElement> getOtpadGrad(@PathParam("grad") String grad){
		return logic.inventarZaPostrojenjaColumnEqual("NAZIV_GRADA", grad);
	}
	
	
	@GET
	@Path("/inventarO/{opstina}")
	@Produces("text/json")
	public List<ZbirniElement> getOtpadOpstina(@PathParam("opstina") String opstina){
		return logic.inventarZaPostrojenjaColumnEqual("NAZIV_OPSTINE", opstina);
	}
	
}