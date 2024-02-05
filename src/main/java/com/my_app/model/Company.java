package com.my_app.model;

import java.io.Serializable;

public class Company implements Serializable {
	
	private static final long serialVersionUID = 5540957701837095980L;

	private Long id;
	
	private String name;
	
	private String address;
	
	private String vat;
	
	private City city;

	public Company() {
		super();
	}

	public Company(String name, String address, String vat, City city) {
		super();
		this.name = name;
		this.address = address;
		this.vat = vat;
		this.city = city;
	}

	public Company(Long id, String name, String address, String vat, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
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
		return String.format("Company [id=%s, name=%s, address=%s, vat=%s, city=%s]", id, name, address, vat,
				city);
	}
	
}
