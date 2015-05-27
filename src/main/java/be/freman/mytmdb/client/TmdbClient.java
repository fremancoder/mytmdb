package be.freman.mytmdb.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import be.freman.mytmdb.model.TmdbMovieInfo;

public class TmdbClient {
	
	private Client client;
	
	public TmdbClient(){
		client = ClientBuilder.newClient();
	}
	
	public TmdbMovieInfo movieDetail(int movieId){
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/mytmdb/webapi")
				.path("tmdbmovies/" + movieId)
				.build();
		
		WebTarget target = client.target(uri);
		
		TmdbMovieInfo response = target.request(MediaType.APPLICATION_JSON).get(TmdbMovieInfo.class); 

		return response;
	}

}
