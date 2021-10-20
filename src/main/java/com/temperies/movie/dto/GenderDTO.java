package com.temperies.movie.dto;

public class GenderDTO {

	private Integer id;
	private String description;

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GenderDTO [id=" + id + ", description=" + description + "]";
	}
	
}
