package be.freman.mytmdb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MovieStar {
	
	private String id;
	
	private String name;
	
	private Movie movie;
	
	public String getId() {
		return id;
	}
	public Movie getMovie() {
		return movie;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
