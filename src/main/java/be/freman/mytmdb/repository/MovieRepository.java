package be.freman.mytmdb.repository;

import java.util.List;

import be.freman.mytmdb.model.Movie;
import be.freman.mytmdb.model.MovieSearch;

public interface MovieRepository {

	List<Movie> findAllMovies();

	Movie findMovie(String title);

	Movie create(Movie movie);

	Movie update(Movie movie);

	void delete(Long movieId);

	List<Movie> findByTitle(List<String> titles, int durationFrom, int durationTo);

	List<Movie> findByTitle(MovieSearch search);

}