package com.my_app.model;

public class Company {
	
	private Long id;
	private String name;
	private String address;
	private String ivaNumber;
	private City city;
	
	public Company() {
		
	}

	public Company(String name, String address, String ivaNumber, City city) {
		super();
		this.name = name;
		this.address = address;
		this.ivaNumber = ivaNumber;
		this.city = city;
	}



	public Company(Long id, String name, String adress, String ivaNumber, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = adress;
		this.ivaNumber = ivaNumber;
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



	public void setAddress(String adress) {
		this.address = adress;
	}



	public String getIvaNumber() {
		return ivaNumber;
	}



	public void setIvaNumber(String ivaNumber) {
		this.ivaNumber = ivaNumber;
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
		return "Company [id=" + id + ", name=" + name + ", adress=" + address + ", ivaNumber=" + ivaNumber + ", coutry="
			 + ", city=" + city + "]";
	}
}