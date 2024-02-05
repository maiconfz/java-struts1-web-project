package com.my_app.page.company.save;

import com.my_app.model.BaseActionForm;

public class CompanySaveForm extends BaseActionForm {
	

	private static final long serialVersionUID = 5775129190004388967L;
	private Long companyId;
	private String name;
	private String adress;
	private Long countryId;
	private Long cityId;
	private int iva;

	private String originalUsername;

	private transient boolean formInit = true;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long userId) {
		this.companyId = userId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
	
	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	
	 public String getOriginalUsername() 
	 { return originalUsername; }
	  
	 public void setOriginalUsername(String originalUsername) {
	  this.originalUsername = originalUsername; }
	

	public boolean isFormInit() {
		return formInit;
	}

	public void setFormInit(boolean formInit) {
		this.formInit = formInit;
	}

	public boolean isNewUser() {
		return this.companyId == null || this.companyId == 0;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
