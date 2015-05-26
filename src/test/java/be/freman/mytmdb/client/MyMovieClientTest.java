package be.freman.mytmdb.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.model.TmdbMovieInfo;
import be.freman.mytmdb.repository.PersistenceManager;

public class MyMovieClientTest {
	
	List<MyMovie> myMovies = new ArrayList<MyMovie>();

	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		MyMovie myMovie1 = new MyMovie();
		myMovie1.setTitle("test 1");
		
		MyMovie myMovie2 = new MyMovie();
		myMovie2.setTitle("test 2");
		
		MyMovie myMovie3 = new MyMovie();
		myMovie3.setTitle("test 3");
		
		MyMovie myMovie4 = new MyMovie();
		myMovie4.setTitle("test 4");

		em.getTransaction().begin();
		em.persist(myMovie1);
		em.persist(myMovie2);
		em.persist(myMovie3);
		em.persist(myMovie4);
		
		Query q = em.createQuery("select m from MyMovie m");
		myMovies = (List<MyMovie>) q.getResultList();	    

		em.getTransaction().commit();

		em.close();
	}

	@Test
	public void testDelete() {
		MyMovieClient client = new MyMovieClient();
		client.delete(myMovies.get(0).getId());
	}

	@Test
	public void testPut() {
		MyMovieClient client = new MyMovieClient();

		MyMovie movie = new MyMovie();
		movie.setId(myMovies.get(1).getId());
		movie.setTitle("dit is de update test");
		movie.setSeen(true);

		movie = client.update(movie);

		assertNotNull(movie);
	}

	@Test
	public void testCreate() {
		MyMovieClient client = new MyMovieClient();

		TmdbMovieInfo movieInfo = new TmdbMovieInfo();
		movieInfo.setTitle("Dit is de creatie test");

		MyMovie myMovie = client.create(movieInfo);

		assertNotNull(myMovie);
	}

	@Test
	public void testFind() {
		MyMovieClient client = new MyMovieClient();

		MyMovie movie = client.find(myMovies.get(0).getId());

		assertNotNull(movie);
	}

}
