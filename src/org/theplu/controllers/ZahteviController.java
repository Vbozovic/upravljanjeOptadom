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
import entities.IdPostrojenja;
import entities.Izdavac;
import entities.KodDozvole;
import entities.NazivPodnosioca;
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
    @Path("/sviZahtevi")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<ZahtevZaDozvolu> getZahteviPodnosioca(NazivPodnosioca nazivPodnosioca) {
    	return zahtevBean.getZahteviPodnosioca(nazivPodnosioca.getNazivPodnosioca());
    }
    
    //svi zahtevi odredjenog postrojenja
    @GET
    @Path("/sviZahteviPostrojenja")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getSviZahteviPostrojenja(IdPostrojenja idPostrojenja) {
    	return zahtevBean.getSviZahteviPostrojenja(idPostrojenja.getId());
    }
    
    //kolicina zahteva odredjenog podnosioca
    @GET
    @Path("/brojZahteva")
    @Produces(MediaType.APPLICATION_JSON)
    public int getBrojZahtevaZaPodnosioca(NazivPodnosioca nazivPodnosioca) {
    	return zahtevBean.getBrojZahtevaZaPodnosioca(nazivPodnosioca.getNazivPodnosioca());
    }
        
    //listanje dozvola po kodu
    @GET
    @Path("/dozvolePoKodu")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZahtevZaDozvolu> getDozvolePoKodu(KodDozvole kodDozvole) {
    	return zahtevBean.getDozvolePoKodu(kodDozvole.getKod());
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
    @Path("/postrojenje")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Postrojenja> getPostrojenje(IdPostrojenja idPostrojenja) {
    	return zahtevBean.getPostrojenje(idPostrojenja.getId());
    }
    
   
	
}
