package be.freman.mytmdb.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.model.TmdbMovieInfo;

public class MyMovieClient {
	
	private Client client;
	
	public MyMovieClient(){
		client = ClientBuilder.newClient();
	}

	public MyMovie create(TmdbMovieInfo movie) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movie").request(MediaType.APPLICATION_JSON).post(Entity.entity(movie, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(MyMovie.class);
	}

	public MyMovie find(Long movieId) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movie/" + movieId).request(MediaType.APPLICATION_JSON).get();
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(MyMovie.class);		
	}
	

	public void delete(Long movieId) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movie/" + movieId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
	}
	
	public MyMovie update(MyMovie movie) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movie/" + movie.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(movie, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(MyMovie.class);
	}

}
