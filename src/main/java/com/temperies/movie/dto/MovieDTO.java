package com.temperies.movie.dto;

import java.util.Date;
import java.util.List;

public class MovieDTO {

	private String name;
	private Short durationInMinutes;
	private Date releaseDate;
	private Double criticReview;
	private List<ScreenWriterDTO> screenWriters;
	private CompanyDTO company;
	private ScriptDTO script;

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

	public List<ScreenWriterDTO> getScreenWriters() {
		return screenWriters;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public ScriptDTO getScript() {
		return script;
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

	public void setScreenWriters(List<ScreenWriterDTO> screenWriters) {
		this.screenWriters = screenWriters;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public void setScript(ScriptDTO script) {
		this.script = script;
	}

	@Override
	public String toString() {
		return "MovieDTO [name=" + name + ", durationInMinutes=" + durationInMinutes + ", releaseDate=" + releaseDate
				+ ", criticReview=" + criticReview + ", screenWriters=" + screenWriters
				+ ", " + company + ", " + script + "]";
	}
	
	

}
