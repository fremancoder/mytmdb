package be.freman.mytmdb.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import be.freman.mytmdb.model.TmdbSearchResult;

public class TmdbSearchClient {

	private Client client;
	
	public TmdbSearchClient(){
		client = ClientBuilder.newClient();
	}	
	
	public TmdbSearchResult search(String title, int page){
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/mytmdb/webapi")
				.path("search/tmdbmovies")
				.queryParam("title", title)
				.queryParam("page",page)
				.build();
		
		WebTarget target = client.target(uri);
		
		TmdbSearchResult response = target.request(MediaType.APPLICATION_JSON).get(TmdbSearchResult.class); 

		return response;
	}
	
}
