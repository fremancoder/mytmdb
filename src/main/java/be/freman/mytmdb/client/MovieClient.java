package be.freman.mytmdb.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.freman.mytmdb.model.Movie;

public class MovieClient {
	
	private Client client;
	
	public MovieClient(){
		client = ClientBuilder.newClient();
	}

	public Movie get(String title){
		WebTarget target = client.target("http://localhost:8080/mytmdb/webapi/");
		
		Response response = target.path("movies/" + title).request(MediaType.APPLICATION_JSON).get(Response.class);
		
//		Show me the xml that is being returned		
//		String response = target.path("movies/" + title).request().get(String.class);
//		System.out.println(response);

//		Show me the json that is being returned		
//		String response = target.path("movies/" + title).request(MediaType.APPLICATION_JSON).get(String.class);
//		System.out.println(response);
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(Movie.class);
	}
	
	public List<Movie> get(){
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		List<Movie> response = target.path("movies").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Movie>>() {});
		
		return response;
	}

	public Movie create(Movie movie) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		// the post method does not return a Response but a movie !!!! why does it work
		Response response = target.path("movies/movie").request(MediaType.APPLICATION_JSON).post(Entity.entity(movie, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(Movie.class);
	}

	public Movie update(Movie movie) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movies/" + movie.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(movie, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(Movie.class);
	}

	public void delete(Long movieId) {
		WebTarget target = client.target("htTp://localhost:8080/mytmdb/webapi/");

		Response response = target.path("movies/" + movieId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
	}
	
}
