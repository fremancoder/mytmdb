package be.freman.mytmdb.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.freman.mytmdb.model.TmdbMovieInfo;
import be.freman.mytmdb.service.TmdbService;
import be.freman.mytmdb.service.TmdbServiceImpl;

@Path("tmdbmovies")
public class TmdbResource {

	private TmdbService tmdbService = new TmdbServiceImpl();

	@GET
	@Path("{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response movieDetail(@PathParam ("movieId") Integer movieId){
		TmdbMovieInfo tmdbMovieInfo  = tmdbService.movieDetail(movieId);
		
		if(tmdbMovieInfo  == null){
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().entity(tmdbMovieInfo).build();
	}	
}
