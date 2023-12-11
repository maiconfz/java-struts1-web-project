package com.my_app.model;

/**
 * Represents a city with an identifier, name, and associated country.
 */
public class City {
	
	/*Fields*/
	private Long id;
	private String name;

	private Country country;

	
	/*Constructors*/
	public City() {
	}

	public City(Long id) {
		super();
		this.id = id;
	}

	public City(String name, Country country) {
		super();
		this.name = name;
		this.country = country;
	}

	public City(Long id, String name, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	
	/*Getters & Setters*/
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	/*ToString*/
	@Override
	public String toString() {
		return String.format("City [id=%s, name=%s, country=%s]", id, name, country);
	}

}
