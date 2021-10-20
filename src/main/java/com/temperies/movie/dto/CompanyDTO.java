package com.temperies.movie.dto;

public class CompanyDTO {
	
	private Integer id;
	private String name;
	private String address;
	private Double value;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Double getValue() {
		return value;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", address=" + address + ", value=" + value + "]";
	}
	
	

}