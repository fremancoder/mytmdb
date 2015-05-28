package be.freman.mytmdb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TmdbSearchMovieInfo {

	private boolean adult;
	
	@XmlElement(name="backdrop_path")
	private String backdropPath;

	private Integer id;
	
	@XmlElement(name="original_title")
	private String originalTitle;
	
	@XmlElement(name="release_date")
	private String releaseDate;
	
	@XmlElement(name="poster_path")
	private String posterPath;
	
	private Float popularity;
	
	private String title;
	
	private boolean video;
	
	@XmlElement(name="vote_average")
	private Float voteAverage;
	
	@XmlElement(name="vote_count")
	private Integer voteCount;
	
	public String getBackdropPath() {
		return backdropPath;
	}
	public Integer getId() {
		return id;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public Float getPopularity() {
		return popularity;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public String getTitle() {
		return title;
	}
	public Float getVoteAverage() {
		return voteAverage;
	}
	public Integer getVoteCount() {
		return voteCount;
	}
	public boolean isAdult() {
		return adult;
	}
	public boolean isVideo() {
		return video;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public void setPopularity(Float popularity) {
		this.popularity = popularity;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public void setVoteAverage(Float voteAverage) {
		this.voteAverage = voteAverage;
	}
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	

}
