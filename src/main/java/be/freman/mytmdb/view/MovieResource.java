package be.freman.mytmdb.view;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.freman.mytmdb.model.Movie;
import be.freman.mytmdb.model.MovieStar;
import be.freman.mytmdb.repository.MovieRepository;
import be.freman.mytmdb.repository.MovieRepositoryStub;

@Path("movies")
public class MovieResource {

	private MovieRepository movieRepository = new MovieRepositoryStub();
	
	@DELETE
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam ("movieId") Long movieId){
		System.out.println(movieId);
		movieRepository.delete(movieId);
		return Response.ok().build();
	}
	
	
	@PUT
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Movie movie){
		System.out.println(movie.getId());
		movie = movieRepository.update(movie);
		return Response.ok().entity(movie).build();
	}

	@POST
	@Path("movie")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Movie createMovie(Movie movie){
		return movieRepository.create(movie);
	}
	
	@POST
	@Path("movie")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Movie createMovieParams(MultivaluedMap<String, String> formParams){
		
		Movie movie = new Movie();
		movie.setTitle(formParams.getFirst("title"));
		movie.setSeen(Boolean.parseBoolean(formParams.getFirst("seen")));
		
		return movieRepository.create(movie);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Movie> getAllMovies(){
		return movieRepository.findAllMovies();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{movieTitle}")
	public Response getMovie(@PathParam ("movieTitle") String title){
		if(title == null || title.length() < 2){
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Movie movie = movieRepository.findMovie(title);
		
		if(movie  == null){
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().entity(movie).build();
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{movieTitle}/moviestar")
	public MovieStar getMovieStar(@PathParam ("movieTitle") String title){
		return movieRepository.findMovie(title).getMovieStars().get(0);
	}

}
