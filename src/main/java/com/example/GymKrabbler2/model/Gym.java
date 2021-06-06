package com.example.GymKrabbler2.model;

import javax.persistence.*;

@Entity
public class Gym {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String url;
	private String email;
	private String zeiten;
	private String preis;
	private String adresse;
	private String bewertung;
	
	

	public Gym() {
		super();
	}
	
	public Gym(String name, String url, String email, String zeiten, String preis, String adresse, String bewertung) {
		this.name = name;
		this.url = url;
		this.email = email;
		this.adresse = adresse;
		this.bewertung = bewertung;
		this.preis = preis;
		this.zeiten = zeiten;
		
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

}
