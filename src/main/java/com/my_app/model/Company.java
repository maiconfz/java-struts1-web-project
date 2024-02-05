package com.my_app.model;

public class Company {


	private Long id;
	private String name;
	private String adress;
	private int iva;
	private City city;
	private Long country;
	
	
	//default construct
	public Company(){
		
		
		
	}
		
	
	/*
	 * public Company(Long id, String name, String adress, int iva, City city, Long
	 * country) { super(); this.id = id; this.name = name; this.adress = adress;
	 * this.iva = iva; this.city = city; this.country = country; }
	 */
	
	
	
	public Company(Long id, String name, String adress, int iva, City city, Long country) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.iva = iva;
		this.city = city;
		this.country = country;
	}
	
	




	public Company(String name, String adress, int iva, City city, Long country) {
		super();
		this.name = name;
		this.adress = adress;
		this.iva = iva;
		this.city = city;
		this.country=country;
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


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getIva() {
		return iva;
	}


	public void setIva(int iva) {
		this.iva = iva;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public Long getCountry() {
		return country;
	}


	public void setCountry(Long country) {
		this.country = country;
	}
	
	public boolean isNew() {
		return this.id == null;
	}
	
	
	@Override
	public String toString() {
		return String.format("Company [id=%s, name=%s, adress=%s, iva=%s, city=%s, country=%s]", id, name, adress, iva,
				city, country);
	}	

}
