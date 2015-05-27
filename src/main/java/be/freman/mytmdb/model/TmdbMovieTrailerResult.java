package be.freman.mytmdb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TmdbMovieTrailerResult {

	private Integer id;
	
	@XmlElement(name="results")
	private List<TmdbMovieTrailer> movieTrailers;

	public Integer getId() {
		return id;
	}

	public List<TmdbMovieTrailer> getMovieTrailers() {
		return movieTrailers;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMovieTrailers(List<TmdbMovieTrailer> movieTrailers) {
		this.movieTrailers = movieTrailers;
	}
	
	
}
