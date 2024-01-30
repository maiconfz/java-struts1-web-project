package com.my_app.model;

public class Company {
	private Long id;
	private String name;
	private String address;
	private Integer iva;
	private Country country;
	private City city;

	public Company() {
	}

	public Company(String name, String address, Integer iva, Country country, City city) {
		super();
		this.name = name;
		this.address = address;
		this.iva = iva;
		this.country = country;
		this.city = city;
	}

	public Company(Long id, String name, String address, Integer iva, Country country, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.iva = iva;
		this.country = country;
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

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", iva=" + iva + ", country=" + country
				+ ", city=" + city + "]";
	}

		
}
