package be.freman.mytmdb.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import be.freman.mytmdb.model.TmdbGenMovieInfo;

public class TmdbClient {

	private Client client;

	public TmdbClient(){

//		to be continued fucking proxy at my fucking work!!!
//		ClientConfig config = new ClientConfig();
//		config.property(ApacheClientProperties.PROXY_URI, "http://proxynlb.atomium.local:8080"); 
//		config.property(ApacheClientProperties.PROXY_USERNAME, "mangelsf"); 
//		config.property(ApacheClientProperties.PROXY_PASSWORD, "Fodmob1402"); 
//		Connector connector = new ApacheConnector(config); 
//		config.connector(connector);
//		
//		client = ClientBuilder.newClient(config);

		client = ClientBuilder.newClient();
	}
	
	public static void main(String[] args){
		TmdbClient client = new TmdbClient();
		client.search("test");
	}
	
	public List<TmdbGenMovieInfo> search(String searchValue){
		
		URI uri = UriBuilder.fromUri("http://api.themoviedb.org/3/")
				.path("search/movie")
				.queryParam("api_key", "660f8a1104d6fb5ca6057ab7340dfa74")
				.queryParam("query", searchValue)
				.build();
		
		WebTarget target = client.target(uri);

//		List<TmdbGenMovieInfo> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<TmdbGenMovieInfo>>() {}); 

		String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
		
//		return response;
		return null;
	}
	
}
