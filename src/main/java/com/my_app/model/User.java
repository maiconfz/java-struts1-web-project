package com.my_app.model;

public class User {
	private Long id;
	private String username;
	private String password;
	private City city;
	private String email;

	public User() {
	}

	public User(String username, String password, City city, String email) {
		super();
		this.username = username;
		this.password = password;
		this.city = city;
		this.email = email;
	}

	public User(Long id, String username, String password, City city, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.city = city;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, city=%s, email=%s]", id, username, password, city, email);
	}

}
