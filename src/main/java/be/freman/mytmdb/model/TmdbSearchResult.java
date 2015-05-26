package be.freman.mytmdb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TmdbSearchResult {
	
	private Integer page;
	
	private List<TmdbSearchMovieInfo> results;
	
	@XmlElement(name="total_pages")
	private Integer totalPages;
	
	@XmlElement(name="total_results")
	private Integer totalResults;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<TmdbSearchMovieInfo> getResults() {
		return results;
	}

	public void setResults(List<TmdbSearchMovieInfo> results) {
		this.results = results;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	
}
