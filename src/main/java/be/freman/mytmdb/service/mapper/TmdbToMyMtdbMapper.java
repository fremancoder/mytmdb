package be.freman.mytmdb.service.mapper;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.model.TmdbMovieInfo;

public class TmdbToMyMtdbMapper {
	
	public MyMovie map(TmdbMovieInfo tmdbMovie){
		MyMovie myMovie = new MyMovie();
		
		myMovie.setBackdropPath("http://image.tmdb.org/t/p/w500/" + tmdbMovie.getBackdropPath());
		myMovie.setHomePage(tmdbMovie.getHomePage());
		myMovie.setImdbId("http://www.imdb.com/title/" + tmdbMovie.getImdbId());
		myMovie.setOriginalTitle(tmdbMovie.getOriginalTitle());
		myMovie.setOverview(tmdbMovie.getOverview());
		myMovie.setPosterPath("http://image.tmdb.org/t/p/w500/" + tmdbMovie.getPosterPath());
		myMovie.setRuntime(tmdbMovie.getRuntime());
		myMovie.setSeen(true);
		myMovie.setTagline(tmdbMovie.getTagline());
		myMovie.setTitle(tmdbMovie.getTitle());
		myMovie.setTmdbId(tmdbMovie.getId());
		
		return myMovie;
	}

}
