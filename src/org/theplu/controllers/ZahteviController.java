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
import entities.Dozvola;
import entities.Izdavac;
import entities.PodnosiocZahteva;
import entities.Postrojenja;
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
    public List<ZahtevZaDozvolu> getZahteviPodnosioca(@PathParam("nazivPodnosioca") String nazivPodnosioca) {
    	return zahtevBean.getZahteviPodnosioca(nazivPodnosioca);
    }
    
    @GET
    @Path("/sviZahteviPostrojenja/{idPostrojenja}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Postrojenja> getZahteviPostrojenja(@PathParam("idPostrojenja") int idPostrojenja) {
    	return zahtevBean.getZahteviPostrojenja(idPostrojenja);
    }
    
    @GET
    @Path("/brojZahteva/{nazivPodnosioca}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getBrojZahtevaZaPodnosioca(@PathParam("nazivPodnosioca") String nazivPodnosioca) {
    	return zahtevBean.getBrojZahtevaZaPodnosioca(nazivPodnosioca);
    }
        
    
    @GET
    @Path("/dozvolePoKodu/{kodDozvole}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getDozvolePoKodu(@PathParam("kodDozvole") String kodDozvole) {
    	return zahtevBean.getDozvolePoKodu(kodDozvole);
    }
    
    @GET
    @Path("/izdavaci")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Izdavac> getIzdavac() {
    	return zahtevBean.getIzdavaci();
    }
    
    @GET
    @Path("/dozvole")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dozvola> getDozvole() {
    	return zahtevBean.getDozvole();
    }
    
    @GET
    @Path("/postrojenja")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Postrojenja> getPostrojenja() {
    	return zahtevBean.getPostrojenja();
    }
    
    /*
    @GET
    @Path("/postrojenja/kapacitet/{idPostrojenja}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getKapacitetPostrojenja(@PathParam("idPostrojenja") int idPostrojenja) {
    	return zahtevBean.getKapacitetPostrojenja(idPostrojenja);
    }
	*/
}
