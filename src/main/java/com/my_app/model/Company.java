package com.my_app.model;

public class Company {

	private Long id;
	private String name;
	private Long vat;
	private City city;
	
	public Company() {
		super();
	}
	
	public Company(String name, Long vat, City city) {
		super();
		this.name = name;
		this.vat = vat;
		this.city = city;
	}
	public Company(Long id, String name, Long vat, City city) {
		super();
		this.id = id;
		this.name = name;
		this.vat = vat;
		this.city = city;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVat() {
		return vat;
	}

	public void setVat(Long vat) {
		this.vat = vat;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return String.format("Company [id=%s, name=%s, vat=%s, city=%s ]", id, name, vat, city);
	}
}
