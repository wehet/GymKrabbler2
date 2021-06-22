package com.example.GymKrabbler2.model;

import javax.persistence.*;

@Entity
public class Gym {
	@Id
	private long id;

	private String name;
	private String url;
	private String email;
	private String zeiten;
	private String preis;
	private String adresse;
	private String bewertung;
	private long scrapeZeiten;
	private long scrapePreis;
	private long scrapeAdresse;
	private long scrapeEmail;

	public Gym() {
		super();
	}

	public Gym(long id, String name, String url, String email, String zeiten, String preis, String adresse,
			String bewertung, long scrapeZeiten, long scrapePreis, long scrapeAdresse, long scrapeEmail) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.email = email;
		this.adresse = adresse;
		this.bewertung = bewertung;
		this.preis = preis;
		this.zeiten = zeiten;
		this.scrapeZeiten = scrapeZeiten;
		this.scrapePreis = scrapePreis;
		this.scrapeAdresse = scrapeAdresse;
		this.scrapeZeiten = scrapeZeiten;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getZeiten() {
		return zeiten;
	}

	public void setZeiten(String zeiten) {
		this.zeiten = zeiten;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String preis) {
		this.preis = preis;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getBewertung() {
		return bewertung;
	}

	public void setBewertung(String bewertung) {
		this.bewertung = bewertung;
	}

	public long getScrapeZeiten() {
		return scrapeZeiten;
	}

	public void setScrapeZeiten(long scrapeZeiten) {
		this.scrapeZeiten = scrapeZeiten;
	}

	public long getScrapePreis() {
		return scrapePreis;
	}

	public void setScrapePreis(long scrapePreis) {
		this.scrapePreis = scrapePreis;
	}

	public long getScrapeAdresse() {
		return scrapeAdresse;
	}

	public void setScrapeAdresse(long scrapeAdresse) {
		this.scrapeAdresse = scrapeAdresse;
	}

	public long getScrapeEmail() {
		return scrapeEmail;
	}

	public void setScrapeEmail(long scrapeEmail) {
		this.scrapeEmail = scrapeEmail;
	}

}
