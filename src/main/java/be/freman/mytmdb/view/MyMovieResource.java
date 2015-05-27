package be.freman.mytmdb.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.repository.MyMovieRepository;
import be.freman.mytmdb.repository.MyMovieRepositoryImpl;
import be.freman.mytmdb.service.MyMovieService;
import be.freman.mytmdb.service.MyMovieServiceImpl;

@Path("movies")
public class MyMovieResource {
	
	private MyMovieRepository movieRepository = new MyMovieRepositoryImpl();

	private MyMovieService myMovieService = new MyMovieServiceImpl();
	
	@DELETE
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam ("movieId") Long movieId){
		movieRepository.delete(movieId);
		return Response.ok().build();
	}
	
	@PUT
	@Path("{movieId}/seen")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateSeen(@PathParam ("movieId") Long movieId){
		MyMovie movie = movieRepository.toggleSeen(movieId);
		return Response.ok().entity(movie).build();
	}	
	
	@GET
	@Path("add/{tmdbMovieId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createMovie(@PathParam ("tmdbMovieId") Integer tmdbMovieId){
		//Should be a post, perhaps I'll modify  it in the future, but it works for now.
		MyMovie myMovie = myMovieService.createMovie(tmdbMovieId);		
		return Response.ok().entity(myMovie).build();		
	}
		
	@GET
	@Path("{movieId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(@PathParam ("movieId") Long movieId){
		MyMovie movie = movieRepository.find(movieId);
		return Response.ok().entity(movie).build();
	}	
}
