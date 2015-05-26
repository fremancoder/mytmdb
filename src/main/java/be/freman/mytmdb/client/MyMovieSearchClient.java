package be.freman.mytmdb.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import be.freman.mytmdb.model.MyMovie;

public class MyMovieSearchClient {
	
	private Client client;
	
	public MyMovieSearchClient(){
		client = ClientBuilder.newClient();
	}

	public List<MyMovie> search(){
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/mytmdb/webapi")
				.path("search/movies")
				.build();
		
		WebTarget target = client.target(uri);
		
		List<MyMovie> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<MyMovie>>() {}); 

//		Show me the xml that is being returned		
//		String response = target.request().get(String.class);
//		System.out.println(response);

//		Show me the json that is being returned		
//		String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
//		System.out.println(response);
		
		
		return response;
	}

}
