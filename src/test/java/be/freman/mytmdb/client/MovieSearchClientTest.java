package be.freman.mytmdb.client;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import be.freman.mytmdb.model.Movie;
import be.freman.mytmdb.model.MovieSearch;
import be.freman.mytmdb.model.MovieSearchType;

public class MovieSearchClientTest {
	
	
	@Test
	public void testSearch(){
		MovieSearchClient client = new MovieSearchClient();
		
		String param = "title";
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("star wars 1");
		searchValues.add("star wars 2");
		searchValues.add("Focus");
		
		String secondParam = "durationFrom";
		int durationFrom = 30;
		
		String thirdParam = "durationTo";
		int durationTo = 60;

		List<Movie> movies = client.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
		
		System.out.println(movies);
		
		assertNotNull(movies);
	}

	@Test
	public void testSearchObject(){
		MovieSearchClient client = new MovieSearchClient();
		
		List<String> searchValues = new ArrayList<String>();
		
		searchValues.add("star wars 1");
		searchValues.add("star wars 2");
		searchValues.add("Focus");
		
		MovieSearch movieSearch = new MovieSearch();
		movieSearch.setTitles(searchValues);
		movieSearch.setDurationFrom(30);
		movieSearch.setDurationTo(60);
		
		movieSearch.setSearchType(MovieSearchType.SEARCH_BY_DESCRIPTION);
		
		List<Movie> movies = client.search(movieSearch);
		
		System.out.println(movies);
		
		assertNotNull(movies);
	}
}
