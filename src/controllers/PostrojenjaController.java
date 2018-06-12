package controllers;

import java.lang.reflect.Method;
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

import brokerUtils.ReflectUtils;
import postrojenja.beans.PostrojenjeBean;
import postrojenja.incomingEntities.Grad;
import postrojenja.incomingEntities.Inventar;
import postrojenja.incomingEntities.LokacijaSearch;
import postrojenja.incomingEntities.Opstina;
import postrojenja.incomingEntities.TypeSearch;
import postrojenja.entities.Postrojenje;
import postrojenja.entities.RezultatStatistike;
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
	@Path("/inventar")
	@Produces("text/json")
	public List<ZbirniElement> getinvenarSpecific(Inventar id){
		return logic.inventarZaSpecificnoPostrojenje(id.getId());
	}
	
	@GET
	@Path("/inventarG")
	@Produces("text/json")
	public List<RezultatStatistike> getOtpadGrad(Grad grad){
		return logic.inventarZaPostrojenjaColumnEqual("NAZIV_GRADA", grad.getGrad());
	}
	
	
	@GET
	@Path("/inventarO")
	@Produces("text/json")
	public List<RezultatStatistike> getOtpadOpstina(Opstina opstina){
		return logic.inventarZaPostrojenjaColumnEqual("NAZIV_OPSTINE", opstina.getOpstina());
	}
	
}