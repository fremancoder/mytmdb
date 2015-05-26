package be.freman.mytmdb.client;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import be.freman.mytmdb.model.TmdbSearchResult;

public class TmdbSearchClientTest {

	@Test
	public void testGet() {
		TmdbSearchClient client = new TmdbSearchClient();

		TmdbSearchResult movies = client.search("the Matrix Reloaded", 1);

		assertEquals("The Matrix Reloaded", movies.getResults().get(0).getTitle());
		assertEquals("The Matrix Reloaded Revisited", movies.getResults().get(1).getTitle());
		
	}

}
