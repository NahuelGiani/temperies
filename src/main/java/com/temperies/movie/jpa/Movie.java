package com.temperies.movie.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "MOVIE")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DURATION_IN_MINUTES")
	private Short durationInMinutes;

	@Column(name = "RELEASE_DATE")
	private Date releaseDate;

	@Column(name = "CRITIC_REVIEW")
	private Double criticReview;

	@ManyToMany
	@JoinTable(name = "SCREENWRITER_MOVIE", 
		joinColumns = { @JoinColumn( name = "FK_MOVIE") }, 
		inverseJoinColumns = { @JoinColumn( name = "FK_SCREENWRITER") })
	private List<ScreenWriter> screenWriters;

	@ManyToOne
	@JoinColumn(name="FK_COMPANY", nullable = false)
	private Company company;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_script", nullable = false)
	private Script script;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Short getDurationInMinutes() {
		return durationInMinutes;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public Double getCriticReview() {
		return criticReview;
	}

	public Company getCompany() {
		return company;
	}

	public Script getScript() {
		return script;
	}

	public List<ScreenWriter> getScreenWriters() {
		return screenWriters;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDurationInMinutes(Short durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setCriticReview(Double criticReview) {
		this.criticReview = criticReview;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setScript(Script script) {
		this.script = script;
	}

	public void setScreenWriters(List<ScreenWriter> screenWriters) {
		this.screenWriters = screenWriters;
	}

}
