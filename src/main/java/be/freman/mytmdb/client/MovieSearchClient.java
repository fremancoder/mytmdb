package be.freman.mytmdb.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import be.freman.mytmdb.model.Movie;
import be.freman.mytmdb.model.MovieSearch;

public class MovieSearchClient {
	
	private Client client;
	
	public MovieSearchClient(){
		client = ClientBuilder.newClient();
	}

	public List<Movie> search(String param, List<String> searchValues, String secondParam, int durationFrom, String thirdParam, int durationTo){
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/mytmdb/webapi")
				.path("search/movies")
				.queryParam(param, searchValues)
				.queryParam(secondParam, durationFrom)
				.queryParam(thirdParam, durationTo)
				.build();
		
		WebTarget target = client.target(uri);
		
		List<Movie> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Movie>>() {}); 

		System.out.println(response);
		
		return response;
	}

	public List<Movie> search(MovieSearch movieSearch) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/mytmdb/webapi")
				.path("search/movies")
				.build();

		WebTarget target = client.target(uri);
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(movieSearch, MediaType.APPLICATION_JSON)); 

		if(response.getStatus() != 200){
			throw new RuntimeException(response.getStatus() + "Error");
		}
		
		return response.readEntity(new GenericType<List<Movie>>() {});
	}
	
}
