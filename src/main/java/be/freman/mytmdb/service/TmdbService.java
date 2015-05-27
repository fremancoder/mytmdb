package be.freman.mytmdb.service;

import be.freman.mytmdb.model.TmdbMovieInfo;
import be.freman.mytmdb.model.TmdbMovieTrailerResult;
import be.freman.mytmdb.model.TmdbSearchResult;

public interface TmdbService {

	TmdbSearchResult search(String searchValue);

	TmdbSearchResult search(String searchValue, int page);
	
	TmdbMovieInfo movieDetail(Integer id);
	
	TmdbMovieTrailerResult movieTrailers(Integer id);	
	
}
