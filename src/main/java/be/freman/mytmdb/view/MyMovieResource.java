package be.freman.mytmdb.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.model.TmdbMovieInfo;
import be.freman.mytmdb.repository.MyMovieRepository;
import be.freman.mytmdb.repository.MyMovieRepositoryImpl;
import be.freman.mytmdb.view.mapper.TmdbToMyMtdbMapper;

@Path("movie")
public class MyMovieResource {
	
	private MyMovieRepository movieRepository = new MyMovieRepositoryImpl();

	private TmdbToMyMtdbMapper mapper = new TmdbToMyMtdbMapper();
	
	@DELETE
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam ("movieId") Long movieId){
		movieRepository.delete(movieId);
		return Response.ok().build();
	}
	
	@PUT
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(MyMovie movie){
		movie = movieRepository.update(movie);
		return Response.ok().entity(movie).build();
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createMovie(TmdbMovieInfo movie){
		movieRepository.create(mapper.map(movie));
		return Response.ok().entity(movie).build();		
	}
		
	@GET
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(@PathParam ("movieId") Long movieId){
		MyMovie movie = movieRepository.find(movieId);
		return Response.ok().entity(movie).build();
	}	
}
