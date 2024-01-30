package com.my_app.page.company.save;

import com.my_app.model.BaseActionForm;

public class CompanySaveForm extends BaseActionForm {
	private static final long serialVersionUID = 3648004327226250285L;
	
	private Long companyId;
	private String companyName;
	private String companyAddress;
	private Integer iva;
	private Long countryId;
	private Long cityId;

	private String originalCompanyName;

	private transient boolean formInit = true;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public String getOriginalCompanyName() {
		return originalCompanyName;
	}

	public void setOriginalCompanyName(String originalCompanyName) {
		this.originalCompanyName = originalCompanyName;
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

	public String getOriginalUsername() {
		return originalCompanyName;
	}

	public void setOriginalUsername(String originalCompanyName) {
		this.originalCompanyName = originalCompanyName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
