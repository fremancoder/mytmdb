package be.freman.mytmdb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TmdbProductionCompanies {

	private String name;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
