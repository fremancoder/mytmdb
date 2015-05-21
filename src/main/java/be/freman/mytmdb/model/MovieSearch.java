package be.freman.mytmdb.model;

import java.util.List;

public class MovieSearch {
	
	private List<String> titles;
	
	private int durationFrom;
	private int durationTo;
	
	private MovieSearchType searchType;
	
	
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	public int getDurationFrom() {
		return durationFrom;
	}
	public void setDurationFrom(int durationFrom) {
		this.durationFrom = durationFrom;
	}
	public int getDurationTo() {
		return durationTo;
	}
	public void setDurationTo(int durationTo) {
		this.durationTo = durationTo;
	}
	public MovieSearchType getSearchType() {
		return searchType;
	}
	public void setSearchType(MovieSearchType searchType) {
		this.searchType = searchType;
	}

	
}
