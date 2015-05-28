package be.freman.mytmdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="MOVIE" )
public class MyMovie {
	
	@Id
	@GeneratedValue
	private Long id; 
	
	private String backdropPath;
	
	private String homePage;

	private Integer tmdbId;

	private String imdbId;
	
	private String originalTitle;
	
	@Column(length=2500)
	private String overview;
	
	private String posterPath;
	
	private Integer runtime;
	
	private String tagline;
	
	private String title;
	
	private boolean seen;
	
	private boolean subtitles;

	private String youTubeLink;

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getHomePage() {
		return homePage;
	}

	public Long getId() {
		return id;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public String getTagline() {
		return tagline;
	}

	public String getTitle() {
		return title;
	}

	public Integer getTmdbId() {
		return tmdbId;
	}

	public String getYouTubeLink() {
		return youTubeLink;
	}

	public boolean isSeen() {
		return seen;
	}

	public boolean isSubtitles() {
		return subtitles;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setSubtitles(boolean subtitles) {
		this.subtitles = subtitles;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTmdbId(Integer tmdbId) {
		this.tmdbId = tmdbId;
	}

	public void setYouTubeLink(String youTubeLink) {
		this.youTubeLink = youTubeLink;
	}
	
}
