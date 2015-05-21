package be.freman.mytmdb.repository;

import java.util.ArrayList;
import java.util.List;

import be.freman.mytmdb.model.Movie;
import be.freman.mytmdb.model.MovieSearch;
import be.freman.mytmdb.model.MovieStar;


public class MovieRepositoryStub implements MovieRepository {

	/* (non-Javadoc)
	 * @see be.freman.mytmdb.repository.MovieResource#findAllMovies()
	 */
	@Override
	public List<Movie> findAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		
		Movie movie1 = new Movie();
		movie1.setId(1l);
		movie1.setTitle("Star wars 1");
		movie1.setSeen(true);
		
		Movie movie2 = new Movie();
		movie2.setId(2l);
		movie2.setTitle("Star wars 2");
		movie2.setSeen(false);

		movies.add(movie1);
		movies.add(movie2);
		
		return movies;
	}

	@Override
	public Movie findMovie(String title) {
		
		if(title.equals("damn")){
			return null;
		}
		
		Movie movie1 = new Movie();

		movie1.setId(1l);
		movie1.setTitle("Star wars 1");
		movie1.setSeen(true);
		
		MovieStar movieStar = new MovieStar();
		movieStar.setId("1");
		movieStar.setName("Freddy");
		
		
		
		movie1.getMovieStars().add(movieStar);
		
		return movie1;
	}

	@Override
	public Movie create(Movie movie) {
		// insert into the db
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		// search and update, if not found create.
		return movie;
	}

	@Override
	public void delete(Long movieId) {
		// delete movie.
		return;
	}

	@Override
	public List<Movie> findByTitle(List<String> titles, int durationFrom, int durationTo) {
		// select * from movies where title in (titles)
		List<Movie> movies = new ArrayList<Movie>();
		
		Movie movie1 = new Movie();
		movie1.setId(1l);
		movie1.setTitle("Star wars 1");
		movie1.setSeen(true);
		
		Movie movie2 = new Movie();
		movie2.setId(2l);
		movie2.setTitle("Star wars 2");
		movie2.setSeen(false);

		movies.add(movie1);
		movies.add(movie2);
		
		return movies;
	}

	@Override
	public List<Movie> findByTitle(MovieSearch search) {
		// select * from movies where title in (titles)
		
		System.out.println(search.getSearchType());
		List<Movie> movies = new ArrayList<Movie>();
		
		Movie movie1 = new Movie();
		movie1.setId(1l);
		movie1.setTitle("Star wars 1");
		movie1.setSeen(true);
		
		Movie movie2 = new Movie();
		movie2.setId(2l);
		movie2.setTitle("Star wars 2");
		movie2.setSeen(false);

		movies.add(movie1);
		movies.add(movie2);
		
		return movies;
	}
	
	
}
