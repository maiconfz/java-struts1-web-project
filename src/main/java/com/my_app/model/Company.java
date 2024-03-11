package com.my_app.model;

public class Company {
	private Long id;
	private String name;
	private String address;
	private String vatNumber;
	private City city;
	
	public Company() {
	}

	public Company( String name,String address, String vatNumber, City city) {
		super();
		this.name = name;
		this.address=address;
		this.vatNumber = vatNumber;
		this.city = city;
	}
	
	public Company(Long id, String name,String address, String vatNumber, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address=address;
		this.vatNumber = vatNumber;
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
	
	public void setAddress(String endereco) {
		this.address = endereco;
	}
	
	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
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
		return String.format("Companies [id=%s, name=%s,address=%s, vatNumber=%s, city=%s]", id, name,address, vatNumber, city);
	}
	
}
