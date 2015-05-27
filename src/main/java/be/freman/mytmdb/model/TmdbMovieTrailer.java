package be.freman.mytmdb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TmdbMovieTrailer {
	
	private Integer id;
	
	@XmlElement(name = "iso_639_1")
	private String isoNorm;
	
	private String key; 
	
	private String name;
	
	private String site;
	
	private Integer size;
	
	private String type;

	public Integer getId() {
		return id;
	}

	public String getIsoNorm() {
		return isoNorm;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getSite() {
		return site;
	}

	public Integer getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsoNorm(String isoNorm) {
		this.isoNorm = isoNorm;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
