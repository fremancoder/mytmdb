package be.freman.mytmdb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TmdbMovieCollection {
	
	private Integer id;
	
	private String name;
	
	@XmlElement(name="poster_path")
	private String posterPath;
	
	@XmlElement(name="backdrop_path")
	private String backdropPath;

	public String getBackdropPath() {
		return backdropPath;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
}
