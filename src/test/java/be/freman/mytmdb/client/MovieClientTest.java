package be.freman.mytmdb.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import be.freman.mytmdb.model.Movie;

public class MovieClientTest {

	@Test
	public void testDelete() {
		MovieClient client = new MovieClient();

		client.delete(5l);
	}

	@Test
	public void testPut() {
		MovieClient client = new MovieClient();

		Movie movie = new Movie();
		movie.setId(4l);
		movie.setTitle("dit is een test");
		movie.setSeen(true);
		
		movie = client.update(movie);
		
		assertNotNull(movie);
	}

	@Test
	public void testCreate() {
		MovieClient client = new MovieClient();

		Movie movie = new Movie();
		movie.setTitle("dit is een test");
		movie.setSeen(true);
		
		movie = client.create(movie);
		
		assertNotNull(movie);
	}

	@Test
	public void testGet() {
		MovieClient client = new MovieClient();

		Movie movie = client.get("test");
		System.out.println(movie);
		
		assertNotNull(movie);
	}

	@Test
	public void testGetList() {
		MovieClient client = new MovieClient();

		List<Movie> movies = client.get();
		System.out.println(movies);
		
		assertNotNull(movies);
	}

	@Test (expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		MovieClient client = new MovieClient();
		client.get("b");
	}

	@Test (expected=RuntimeException.class)
	public void testGetWithNotFound() {
		MovieClient client = new MovieClient();
		client.get("damn");
	}

}
