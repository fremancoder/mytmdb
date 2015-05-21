package be.freman.mytmdb.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	
	private long id;
	
	private String title;
	
	private boolean seen;
	
	private List<MovieStar> movieStars = new ArrayList<MovieStar>();
	
	public long getId() {
		return id;
	}
	public List<MovieStar> getMovieStars() {
		return movieStars;
	}
	@XmlElement(name="title")
	public String getTitle() {
		return title;
	}
	@XmlElement(name="seen")
	public boolean isSeen() {
		return seen;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setMovieStars(List<MovieStar> movieStars) {
		this.movieStars = movieStars;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
