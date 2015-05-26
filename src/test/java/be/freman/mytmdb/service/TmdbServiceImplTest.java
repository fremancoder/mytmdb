package be.freman.mytmdb.service;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import be.freman.mytmdb.model.TmdbMovieInfo;
import be.freman.mytmdb.model.TmdbSearchResult;

public class TmdbServiceImplTest {

	@Test
	public void testSearch() {
		TmdbService tmdbService = new TmdbServiceImpl();

		TmdbSearchResult movies = tmdbService.search("the Matrix Reloaded");

		assertEquals("The Matrix Reloaded", movies.getResults().get(0).getTitle());
		assertEquals("The Matrix Reloaded Revisited", movies.getResults().get(1).getTitle());

	}
		
	@Test
	public void testMovieDetail() {
		TmdbService tmdbService = new TmdbServiceImpl();

		TmdbMovieInfo movieInfo = tmdbService.movieDetail(10138);
		
		assertEquals("Iron Man 2", movieInfo.getTitle());
		assertEquals("Action", movieInfo.getGenres().get(0).getName());
		assertEquals("Adventure", movieInfo.getGenres().get(1).getName());
		assertEquals("Science Fiction", movieInfo.getGenres().get(2).getName());
		
	}

}
