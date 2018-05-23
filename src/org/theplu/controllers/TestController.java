package org.theplu.controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@LocalBean
@Path("/test")
public class TestController {

	
    @GET
    @Produces("text/json")
	public String getAll(){
		return "Hello";
	}
	
}
