package com.my_app.page.user.save;

import com.my_app.model.BaseActionForm;

public class UserSaveForm extends BaseActionForm {
	private static final long serialVersionUID = 3648004327226250285L;

	private Long userId;
	private String username;
	private String password;
	private String email;
	private Long countryId;
	private Long cityId;

	private String originalUsername;

	private transient boolean formInit = true;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isFormInit() {
		return formInit;
	}

	public void setFormInit(boolean formInit) {
		this.formInit = formInit;
	}

	public boolean isNewUser() {
		return this.userId == null || this.userId == 0;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
