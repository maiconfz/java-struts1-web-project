package com.my_app.page.company.save;

import com.my_app.model.BaseActionForm;

public class CompanySaveForm extends BaseActionForm {
	private static final long serialVersionUID = 3648004327226250285L;

	private Long companyId;
	private String name;
	private String address;
	private String vat;
	private Long countryId;
	private Long cityId;

	private String originalName;

	private transient boolean formInit = true;
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
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

}
