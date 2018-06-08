package controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import klasifikacija.beans.TestBean;
import klasifikacija.entities.TestEntity;

@Stateless
@LocalBean
@Path("/test")
public class TestController {

	private TestBean logic;
	
	public TestController(){
		//
		logic = new TestBean();
		
	}
	
    @POST
    @Produces("text/json")
    @Consumes("application/json")
	public String getAll(TestEntity input){
		return "Hello "+input.getMessage()+" "+logic.testLogic();
	}
	
}
