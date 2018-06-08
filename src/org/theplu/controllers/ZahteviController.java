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
		
	//listanje svih zahteva
    @GET
    @Path("/sviZahtevi")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getZahtevi() {
    	return zahtevBean.getZahtevi();
    }
    
    //listanje svih podnosioca
    @GET
	@Path("/podnosioci")
    @Produces(MediaType.APPLICATION_JSON)
	public List<PodnosiocZahteva> getPodnosioci() {
		return zahtevBean.getPodnosioci();
	}
        
    //svi zahtevi odredjenog podnosioca
    @GET
    @Path("/sviZahtevi/{nazivPodnosioca}")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<ZahtevZaDozvolu> getZahteviPodnosioca(@PathParam("nazivPodnosioca") String nazivPodnosioca) {
    	return zahtevBean.getZahteviPodnosioca(nazivPodnosioca);
    }
    
    //svi zahtevi odredjenog postrojenja
    @GET
    @Path("/sviZahteviPostrojenja/{idPostrojenja}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getSviZahteviPostrojenja(@PathParam("idPostrojenja") int idPostrojenja) {
    	return zahtevBean.getSviZahteviPostrojenja(idPostrojenja);
    }
    
    //kolicina zahteva odredjenog podnosioca
    @GET
    @Path("/brojZahteva/{nazivPodnosioca}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getBrojZahtevaZaPodnosioca(@PathParam("nazivPodnosioca") String nazivPodnosioca) {
    	return zahtevBean.getBrojZahtevaZaPodnosioca(nazivPodnosioca);
    }
        
    //listanje dozvola po kodu
    @GET
    @Path("/dozvolePoKodu/{kodDozvole}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getDozvolePoKodu(@PathParam("kodDozvole") String kodDozvole) {
    	return zahtevBean.getDozvolePoKodu(kodDozvole);
    }
    
    //listanje svih izdavaca
    @GET
    @Path("/izdavaci")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Izdavac> getIzdavac() {
    	return zahtevBean.getIzdavaci();
    }
    
    //listanje svih dozvola
    @GET
    @Path("/dozvole")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dozvola> getDozvole() {
    	return zahtevBean.getDozvole();
    }
    
    //listanje svih postrojenja
    @GET
    @Path("/postrojenje")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Postrojenja> getPostrojenja() {
    	return zahtevBean.getPostrojenja();
    }    

    //odabir specificnog postrojenja
    @GET
    @Path("/postrojenje/{idPostrojenja}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Postrojenja> getPostrojenje(@PathParam("idPostrojenja") int idPostrojenja) {
    	return zahtevBean.getPostrojenje(idPostrojenja);
    }
    
   
	
}
