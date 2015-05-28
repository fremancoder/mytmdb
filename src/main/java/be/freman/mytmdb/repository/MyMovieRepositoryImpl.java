package be.freman.mytmdb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import be.freman.mytmdb.model.MyMovie;

public class MyMovieRepositoryImpl implements MyMovieRepository{

	@Override
	public void create(MyMovie movie) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
	    em.getTransaction().begin();
	    em.persist(movie);
	    em.flush();
	    em.getTransaction().commit();
	    em.close();

	}

	@Override
	public MyMovie toggleSeen(Long movieId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

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
	public MyMovie toggleSubtitle(Long movieId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

		em.getTransaction().begin();
	    MyMovie movie = em.find(MyMovie.class, movieId);
	    movie.setSubtitles(!movie.isSubtitles());
	    movie = em.merge(movie);
	    em.flush();
	    em.getTransaction().commit();
	    em.close();
    
	    return movie;
	}

	
	@Override
	public void delete(Long movieId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
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
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

		Query q = em.createQuery("select m from MyMovie m");
		List<MyMovie> myMovies = (List<MyMovie>) q.getResultList();	    
	    em.close();

	    return myMovies;
	}

	@Override
	public MyMovie find(Long movieId) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
	    MyMovie myMovie = em.find(MyMovie.class, movieId);
	    em.close();

	    return myMovie;
	}

}
