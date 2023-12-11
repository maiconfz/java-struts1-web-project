package com.my_app.page.company.save;

import com.my_app.model.BaseActionForm;

/**
 * The UserSaveForm class extends the BaseActionForm and represents the form for
 * saving or updating user details. It holds user-related input fields and flags
 * for form initialization and user status.
 */
public class CompanySaveForm extends BaseActionForm {
	private static final long serialVersionUID = 3648004327226250285L;

	/*Fields*/
	private Long companyId;
	private String name;
	private String address;
	private String ivaNumber;
	private Long countryId;
	private Long cityId;
	
	private String originalUsername;

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

	public String getIvaNumber() {
		return ivaNumber;
	}

	public void setIvaNumber(String ivaNumber) {
		this.ivaNumber = ivaNumber;
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
		return originalUsername;
	}

	public void setOriginalUsername(String originalUsername) {
		this.originalUsername = originalUsername;
	}

	/**
     * Checks if the form is in the initialization state.
     *
     * @return True if the form is in the initialization state; false otherwise.
     */
	public boolean isFormInit() {
		return formInit;
	}

	/**
     * Sets the form initialization state.
     *
     * @param formInit The form initialization state to set.
     */
	public void setFormInit(boolean formInit) {
		this.formInit = formInit;
	}

	 /**
     * Checks if the user is new.
     *
     * @return True if the user is new; false otherwise.
     */
	public boolean isNewCompany() {
		return this.companyId == null || this.companyId == 0;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}