package be.freman.mytmdb.view.mapper;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.model.TmdbMovieInfo;

public class TmdbToMyMtdbMapper {
	
	public MyMovie map(TmdbMovieInfo tmdbMovie){
		MyMovie myMovie = new MyMovie();
		
		myMovie.setBackdropPath(tmdbMovie.getBackdropPath());
		myMovie.setHomePage(tmdbMovie.getHomePage());
		myMovie.setImdbId(tmdbMovie.getImdbId());
		myMovie.setOriginalTitle(tmdbMovie.getOriginalTitle());
		myMovie.setOverview(tmdbMovie.getOverview());
		myMovie.setPosterPath(tmdbMovie.getPosterPath());
		myMovie.setRuntime(tmdbMovie.getRuntime());
		myMovie.setSeen(false);
		myMovie.setTagline(tmdbMovie.getTagline());
		myMovie.setTitle(tmdbMovie.getTitle());
		myMovie.setTmdbId(tmdbMovie.getId());
		
		return myMovie;
	}

}
