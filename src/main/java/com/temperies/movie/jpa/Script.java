package com.temperies.movie.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "SCRIPT")
public class Script {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TIMES_MODIFIED")
	private Integer timesModified;

	@Column(name = "LAST_MODIFIED")
	private Date lastModified;

	
	public Integer getId() {
		return id;
	}

	public Integer getTimesModified() {
		return timesModified;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTimesModified(Integer timesModified) {
		this.timesModified = timesModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
