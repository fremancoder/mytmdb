package be.freman.mytmdb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import be.freman.mytmdb.model.MyMovie;

public class MyMovieRepositoryImpl implements MyMovieRepository{

	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	@Override
	public void create(MyMovie movie) {
		
	    em.getTransaction().begin();
	    em.persist(movie);
	    em.flush();
	    em.getTransaction().commit();
	    em.close();

	}

	@Override
	public MyMovie toggleSeen(Long movieId) {

		em.getTransaction().begin();
	    MyMovie movie = em.find(MyMovie.class, movieId);
	    movie.setSeen(!movie.isSeen());
	    movie = em.merge(movie);
	    em.flush();
	    em.getTransaction().commit();
	    em.close();
    
	    return movie;
	}

	@Override
	public void delete(Long movieId) {
		
	    em.getTransaction().begin();
	    MyMovie myMovie = em.find(MyMovie.class, movieId);
	    em.remove(myMovie);
	    em.flush();
	    em.getTransaction().commit();
	    em.close();

	}

	@Override
    @SuppressWarnings("unchecked")
	public List<MyMovie> getAll() {

		Query q = em.createQuery("select m from MyMovie m");
		List<MyMovie> myMovies = (List<MyMovie>) q.getResultList();	    
	    em.close();

	    return myMovies;
	}

	@Override
	public MyMovie find(Long movieId) {
		
	    MyMovie myMovie = em.find(MyMovie.class, movieId);
	    em.close();

	    return myMovie;
	}

}
