package be.freman.mytmdb.service;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import be.freman.mytmdb.model.TmdbMovieInfo;
import be.freman.mytmdb.model.TmdbSearchResult;

public class TmdbServiceImpl implements TmdbService{

	private Client client;
	
	private final static String FROM_URI =  "https://api.themoviedb.org/3/";

	private final static String SEARCH_PATH =  "search/movie";
	
	private final static String MOVIE_PATH = "movie/";

	private final static String API_KEY =  "the key";

	public TmdbServiceImpl(){
		client = ClientBuilder.newClient();
	}
	
	@Override
	public TmdbSearchResult search(String searchValue) {
		return search(searchValue, 1);
	}

	@Override
	public TmdbSearchResult search(String searchValue, int page) {
		URI uri = UriBuilder.fromUri(FROM_URI)
				.path(SEARCH_PATH)
				.queryParam("api_key", API_KEY)
				.queryParam("query", searchValue)
				.queryParam("page", page)
				.build();
		
		WebTarget target = client.target(uri);

		TmdbSearchResult response = target.request(MediaType.APPLICATION_JSON).get(TmdbSearchResult.class); 
		
		return response;
	}

	@Override
	public TmdbMovieInfo movieDetail(int id) {
		URI uri = UriBuilder.fromUri(FROM_URI)
				.path(MOVIE_PATH + id)
				.queryParam("api_key", API_KEY)
				.build();
		
		WebTarget target = client.target(uri);

		TmdbMovieInfo response = target.request(MediaType.APPLICATION_JSON).get(TmdbMovieInfo.class); 
		
		return response;
	}

}
