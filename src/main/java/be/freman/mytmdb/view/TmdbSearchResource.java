package be.freman.mytmdb.view;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.freman.mytmdb.model.TmdbSearchResult;
import be.freman.mytmdb.service.TmdbService;
import be.freman.mytmdb.service.TmdbServiceImpl;

@Path("search/tmdbmovies")
public class TmdbSearchResource {
	
	private TmdbService tmdbService = new TmdbServiceImpl();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response searchForMovies(@QueryParam(value = "title") String title, @QueryParam(value = "page") int page){
		TmdbSearchResult movies = tmdbService.search(title, page);
		
		if(movies == null || movies.getResults().size() <= 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(movies).build();
	}

}
