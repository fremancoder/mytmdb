package be.freman.mytmdb.service;

import be.freman.mytmdb.model.MyMovie;
import be.freman.mytmdb.model.TmdbMovieTrailerResult;
import be.freman.mytmdb.repository.MyMovieRepository;
import be.freman.mytmdb.repository.MyMovieRepositoryImpl;
import be.freman.mytmdb.service.mapper.TmdbToMyMtdbMapper;

public class MyMovieServiceImpl implements MyMovieService{
	
	private TmdbToMyMtdbMapper mapper = new TmdbToMyMtdbMapper();

	private TmdbService tmdbService = new TmdbServiceImpl();
	
	private MyMovieRepository movieRepository = new MyMovieRepositoryImpl();
	
	
	@Override
	public MyMovie createMovie(Integer tmdbMovieId) {
		MyMovie myMovie = mapper.map(tmdbService.movieDetail(tmdbMovieId));
		addMovieTrailer(myMovie, tmdbMovieId);
		movieRepository.create(myMovie);

		return myMovie;
	}

	private void addMovieTrailer(MyMovie myMovie, Integer tmdbMovieId) {
		TmdbMovieTrailerResult tmdbMovieTrailerResult = tmdbService.movieTrailers(tmdbMovieId);
		// TODO if it turns out that there are other sites then yuoutube modify this code based upon type for now just leave it this way
		if(tmdbMovieTrailerResult != null && tmdbMovieTrailerResult.getMovieTrailers() != null && tmdbMovieTrailerResult.getMovieTrailers().size() > 0){
			String youTubeKey = tmdbMovieTrailerResult.getMovieTrailers().get(0).getKey();
//			String youTubeLink = "http//www.youtube.com/embed/"+youTubeKey+"?autoplay=0";
//			myMovie.setYouTubeLink(youTubeLink);
			myMovie.setYouTubeLink(youTubeKey);
		}
	}

}
