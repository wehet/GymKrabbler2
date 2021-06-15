package com.example.GymKrabbler2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScrapeData {
	@Id
	private long id;

	private String url;
	private String xpath;
	private String start;
	private String end;

	public ScrapeData() {
		super();
	}

	public ScrapeData(long id, String url, String xpath, String start, String end) {
		this.id = id;
		this.setUrl(url);
		this.setXpath(xpath);
		this.setStart(start);
		this.setEnd(end);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
