package com.temperies.movie.dto;

import java.util.Date;

public class ScriptDTO {

	private Integer timesModified;
	private Date lastModified;

	public Integer getTimesModified() {
		return timesModified;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setTimesModified(Integer timesModified) {
		this.timesModified = timesModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "ScriptDTO [timesModified=" + timesModified + ", lastModified=" + lastModified + "]";
	}

}
