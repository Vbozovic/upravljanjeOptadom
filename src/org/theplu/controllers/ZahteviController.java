package org.theplu.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.ZahtevBean;
import entities.Izdavac;
import entities.PodnosiocZahteva;
import entities.ZahtevZaDozvolu;

@Stateless
@LocalBean
@Path("/zahtevi")
public class ZahteviController {

	private ZahtevBean zahtevBean;
	
	public ZahteviController(){
		
		zahtevBean = new ZahtevBean();
		
	}
	
	/*
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ZahtevZaDozvolu dodajZahtev(ZahtevZaDozvolu zahtev){    	
    	return zahtevBean.dodajZahtev(zahtev);
	}
    */
	
	
    @GET
    @Path("/sviZahtevi")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getZahtevi() {
    	return zahtevBean.getZahtevi();
    }
    
    @GET
	@Path("/podnosioci")
    @Produces(MediaType.APPLICATION_JSON)
	public List<PodnosiocZahteva> getPodnosioci() {
		return zahtevBean.getPodnosioci();
	}
        
    @GET
    @Path("/sviZahtevi/{nazivPodnosioca}")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<ZahtevZaDozvolu> getZahteviPodnosioc(@PathParam("nazivPodnosioca") String nazivPodnosioca) {
    	return zahtevBean.getZahteviPodnosioc(nazivPodnosioca);
    }
    
    @GET
    @Path("/izdavaci")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Izdavac> getIzdavac() {
    	return zahtevBean.getIzdavaci();
    }
}
