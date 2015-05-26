package be.freman.mytmdb.client;

import javax.persistence.EntityManager;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.repository.PersistenceManager;

public class TestPersistenceManager {

	public static void main(String[] args) {
	    MyMovie myMovie = new MyMovie();
	    myMovie.setTitle("test");
	 
	    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	    em.getTransaction()
	        .begin();
	    em.persist(myMovie);
	    em.getTransaction()
	        .commit();
	 
	    em.close();
	    PersistenceManager.INSTANCE.close();
	  }
	
}
