package com.my_app.page.company.save;

import com.my_app.model.BaseActionForm;

public class CompanySaveForm extends BaseActionForm {

	private static final long serialVersionUID = 3269397173691017817L;
	
	private Long companyId;
	private String name;
	private String address;
	private Long vat;
	private Long cityId;
	private Long countryId;
	
	private transient boolean formInit = true;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long id) {
		this.companyId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVat() {
		return vat;
	}

	public void setVat(Long vat) {
		this.vat = vat;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public boolean isFormInit() {
		return formInit;
	}

	public void setFormInit(boolean formInit) {
		this.formInit = formInit;
	}
	
	public boolean isNewCompany() {
		return this.companyId == null || this.companyId == 0;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
