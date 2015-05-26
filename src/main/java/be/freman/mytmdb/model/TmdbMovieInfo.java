package be.freman.mytmdb.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TmdbMovieInfo {
	
	private Integer id; 
	
	private boolean adult;
	
	@XmlElement(name="backdrop_path")
	private String backdropPath;
	
	@XmlElement(name="belongs_to_collection")
	private TmdbMovieCollection collection;
	
	private Long budget;
	
	private List<TmdbGenres> genres;
	
	@XmlElement(name="homepage") 
	private String homePage;

	@XmlElement(name="imdb_id")
	private String imdbId;
	
	@XmlElement(name="original_language")
	private String originalLanguage;
	
	@XmlElement(name="original_title")
	private String originalTitle;
	
	private String overview;
	
	private float popularity;
	
	@XmlElement(name="poster_path")
	private String posterPath;
	
	@XmlElement(name="production_companies")
	private List<TmdbProductionCompanies> productionCompanies;
	
	@XmlElement(name="production_countries")
	private List<TmdbProductionCountries> productionCountries;
	
	@XmlElement(name="release_date")
	private Date releaseDate; 
	
	private Long revenue;
	
	private Integer runtime;
	
	@XmlElement(name="spoken_languages")
	private List<TmdbLanguage> spokenLanguages;	
	
	private String status;

	private String tagline;
	
	private String title;
	
	private boolean video;
	
	@XmlElement(name="vote_average")
	private float voteAverage;
	
	@XmlElement(name="vote_count")
	private Integer voteCount;

	public String getBackdropPath() {
		return backdropPath;
	}

	public Long getBudget() {
		return budget;
	}

	public TmdbMovieCollection getCollection() {
		return collection;
	}

	public List<TmdbGenres> getGenres() {
		return genres;
	}

	public String getHomePage() {
		return homePage;
	}

	public Integer getId() {
		return id;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	public float getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public List<TmdbProductionCompanies> getProductionCompanies() {
		return productionCompanies;
	}

	public List<TmdbProductionCountries> getProductionCountries() {
		return productionCountries;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public Long getRevenue() {
		return revenue;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public List<TmdbLanguage> getSpokenLanguages() {
		return spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public String getTagline() {
		return tagline;
	}

	public String getTitle() {
		return title;
	}

	public float getVoteAverage() {
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

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public void setCollection(TmdbMovieCollection collection) {
		this.collection = collection;
	}

	public void setGenres(List<TmdbGenres> genres) {
		this.genres = genres;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public void setProductionCompanies(
			List<TmdbProductionCompanies> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}

	public void setProductionCountries(
			List<TmdbProductionCountries> productionCountries) {
		this.productionCountries = productionCountries;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public void setSpokenLanguages(List<TmdbLanguage> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public void setVoteAverage(float voteAverage) {
		this.voteAverage = voteAverage;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	
}
