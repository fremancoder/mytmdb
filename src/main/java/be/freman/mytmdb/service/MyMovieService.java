package be.freman.mytmdb.service;

import be.freman.mytmdb.model.MyMovie;

public interface MyMovieService {
	
	MyMovie createMovie(Integer tmdbMovieId);

}
