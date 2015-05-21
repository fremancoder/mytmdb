package be.freman.mytmdb.view;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.freman.mytmdb.model.Movie;
import be.freman.mytmdb.model.MovieSearch;
import be.freman.mytmdb.repository.MovieRepository;
import be.freman.mytmdb.repository.MovieRepositoryStub;

@Path("search/movies")
public class MovieSearchResource {

	private MovieRepository movieRepository = new MovieRepositoryStub();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response searchForMovies(@QueryParam(value = "title") List<String> titles, @QueryParam(value = "durationFrom") int durationFrom, @QueryParam(value = "durationTo") int durationTo){
		System.out.println(titles + ", " + durationFrom + ", " + durationTo);
		
		List<Movie> movies = movieRepository.findByTitle(titles, durationFrom, durationTo);
		
		if(movies == null || movies.size() <= 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Movie>>(movies){}).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response searchForMovies(MovieSearch search){
		System.out.println(search.getTitles() + ", " + search.getDurationTo());
		
		List<Movie> movies = movieRepository.findByTitle(search);
		
		if(movies == null || movies.size() <= 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Movie>>(movies){}).build();
	}
}
