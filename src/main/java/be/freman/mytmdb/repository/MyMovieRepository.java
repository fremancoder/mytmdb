package be.freman.mytmdb.repository;

import java.util.List;

import be.freman.mytmdb.model.MyMovie;

public interface MyMovieRepository {
	
	void create(MyMovie movie);	

	MyMovie update(MyMovie movie);	

	void delete(Long movieId);	
	
	List<MyMovie> getAll();	

	MyMovie find(Long movieId);	

}
