package com.my_app.model;

public class User {
	private Long id;
	private String username;
	private String password;
	private String email;
	private City city;

	public User() {
	}

	public User(String username, String password, String email, City city) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
	}

	public User(Long id, String username, String password, String email, City city) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s, city=%s]", id, username, password, email, city);
	}

}
