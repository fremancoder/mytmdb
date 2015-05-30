package be.freman.mytmdb.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.freman.mytmdb.model.Credentials;

@Path("authenticate")
public class AuthenticationResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response authenticate(Credentials credentials){
		if(!"fred".equals(credentials.getUsername()) || !"pwd".equals(credentials.getPassword()) ){
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		return Response.ok().entity(credentials).build();
	}	
	
}
