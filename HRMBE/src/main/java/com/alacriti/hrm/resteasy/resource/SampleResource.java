package com.alacriti.hrm.resteasy.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.hrm.biz.delegate.SampleDelegate;

@Path("/message")
public class SampleResource {

	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_XML)
	public Response sampleResourceGet(@PathParam("param") String msg) {

		SampleDelegate delegate = new SampleDelegate();
		
		String result = "<RestfulExample><H1>" + delegate.getMessage() + "</H1></RestfulExample>";

			
		return Response.status(200).entity(result).build();

	}
	
	@POST
	@Path("/{param}")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_XML)
	public Response sampleResourcePost(@PathParam("param") String msg) {
		SampleDelegate delegate = new SampleDelegate();
		String result = "<RestfulExample><H1>" + delegate.getMessage() + "</H1></RestfulExample>";

		return Response.status(200).entity(result).build();

	}
}
