package be.freman.mytmdb.client;

import java.util.List;

import org.junit.Test;

import be.freman.mytmdb.model.TmdbGenMovieInfo;

public class TmdbClientTest {

	@Test
	public void testSearch() {
		TmdbClient client = new TmdbClient();

		List<TmdbGenMovieInfo> movies = client.search("starwars");

		for (TmdbGenMovieInfo tmdbGenMovieInfo : movies) {
			System.out.println(tmdbGenMovieInfo.getTitle());
		}
	}
	
}
