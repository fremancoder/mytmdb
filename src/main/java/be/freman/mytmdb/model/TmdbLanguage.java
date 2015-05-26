package be.freman.mytmdb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TmdbLanguage {
	
	@XmlElement(name="iso_639_1")
	private String isoNorm;
	
	private String name;

	public String getIsoNorm() {
		return isoNorm;
	}

	public String getName() {
		return name;
	}

	public void setIsoNorm(String isoNorm) {
		this.isoNorm = isoNorm;
	}

	public void setName(String name) {
		this.name = name;
	}

}
