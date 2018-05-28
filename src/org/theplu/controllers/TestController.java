package org.theplu.controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@LocalBean
@Path("/test")
public class TestController {

	
    @POST
    @Produces("text/json")
    @Consumes("application/json")
	public String getAll(TestInput input){
		return "Hello "+input.getMessage();
	}
	
}
