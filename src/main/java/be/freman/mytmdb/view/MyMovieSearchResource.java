package be.freman.mytmdb.view;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.repository.MyMovieRepository;
import be.freman.mytmdb.repository.MyMovieRepositoryImpl;

@Path("search/movies")
public class MyMovieSearchResource {

	private MyMovieRepository movieRepository = new MyMovieRepositoryImpl();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAll(){
		List<MyMovie> movies = movieRepository.getAll();
		
		if(movies == null || movies.size() <= 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<MyMovie>>(movies){}).build();
	}
	
}
