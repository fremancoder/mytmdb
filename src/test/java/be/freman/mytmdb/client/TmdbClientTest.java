package be.freman.mytmdb.client;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import be.freman.mytmdb.model.TmdbMovieInfo;

public class TmdbClientTest {

	@Test
	public void testGet() {
		TmdbClient client = new TmdbClient();

		TmdbMovieInfo movieInfo = client.movieDetail(10138);
		
		assertEquals("Iron Man 2", movieInfo.getTitle());
		assertEquals("Action", movieInfo.getGenres().get(0).getName());
		assertEquals("Adventure", movieInfo.getGenres().get(1).getName());
		assertEquals("Science Fiction", movieInfo.getGenres().get(2).getName());
		
	}

}
