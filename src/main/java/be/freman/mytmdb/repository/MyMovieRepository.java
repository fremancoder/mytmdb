package be.freman.mytmdb.repository;

import java.util.List;

import be.freman.mytmdb.model.MyMovie;

public interface MyMovieRepository {
	
	void create(MyMovie movie);	

	MyMovie toggleSeen(Long movieId);	

	void delete(Long movieId);	
	
	List<MyMovie> getAll();	

	MyMovie find(Long movieId);	

}
