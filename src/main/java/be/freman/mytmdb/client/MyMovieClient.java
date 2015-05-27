package be.freman.mytmdb.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.freman.mytmdb.model.MyMovie;

public class MyMovieClient {
	
	private Client client;
	
	public MyMovieClient(){
		client = ClientBuilder.newClient();
	}

	public MyMovie create(Integer tmdbSearchMovieInfoId) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movies/add/" + tmdbSearchMovieInfoId).request(MediaType.APPLICATION_JSON).get();
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(MyMovie.class);
	}

	public MyMovie find(Long movieId) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movies/" + movieId).request(MediaType.APPLICATION_JSON).get();
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(MyMovie.class);		
	}
	

	public void delete(Long movieId) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movies/" + movieId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
	}
	
	public MyMovie update(MyMovie movie) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movies/" + movie.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(movie, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(MyMovie.class);
	}

}
