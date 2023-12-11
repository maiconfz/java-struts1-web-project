package com.my_app.model;

/**
 * Represents a country with an identifier and name.
 */
public class Country {
	
	/*Fields*/
	private Long id;
	private String name;

	
	/*Constructors*/
	public Country() {
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public Country(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	/*ToString*/
	@Override
	public String toString() {
		return String.format("Country [id=%s, name=%s]", id, name);
	}

}
