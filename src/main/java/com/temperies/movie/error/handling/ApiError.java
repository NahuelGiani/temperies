package com.temperies.movie.error.handling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime date;
	private HttpStatus status;
	private String description;
	private String debugDescription;

	public ApiError(HttpStatus status) {
		this.date = LocalDateTime.now();
		this.status = status;
	}

	public ApiError(HttpStatus status, String description, Throwable ex) {
		this.date = LocalDateTime.now();
		this.status = status;
		this.description = description;
		this.debugDescription = ex.getLocalizedMessage();
	}

	public ApiError(HttpStatus status, String description, String debugDescription) {
		this.date = LocalDateTime.now();
		this.status = status;
		this.description = description;
		this.debugDescription = debugDescription;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDebugDescription() {
		return debugDescription;
	}

	public void setDebugDescription(String debugDescription) {
		this.debugDescription = debugDescription;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
