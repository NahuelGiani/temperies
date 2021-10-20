package com.temperies.movie.dto;

public class ScreenWriterDTO{
	
	private Integer id;
	private String name;
	private Integer age;
	private GenderDTO gender;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public GenderDTO getGender() {
		return gender;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setGender(GenderDTO gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ScreenWriterDTO [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
}
