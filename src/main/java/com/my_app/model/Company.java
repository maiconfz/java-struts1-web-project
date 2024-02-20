package com.my_app.model;

public class Company {
	private Long id;
	private String name;
	private String address;
	private City city;
	private String vat;

	public Company() {
	}

	public Company(String name, String address, City city, String vat) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.vat = vat;
	}

	public Company(Long id, String name, String address, City city, String vat) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.vat = vat;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, city=%s, vat=%s]", id, name, address, city, vat);
	}

}
