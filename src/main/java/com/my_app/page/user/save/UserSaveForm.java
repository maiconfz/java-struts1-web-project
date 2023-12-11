package com.my_app.page.user.save;

import com.my_app.model.BaseActionForm;

/**
 * The UserSaveForm class extends the BaseActionForm and represents the form for
 * saving or updating user details. It holds user-related input fields and flags
 * for form initialization and user status.
 */
public class UserSaveForm extends BaseActionForm {
	private static final long serialVersionUID = 3648004327226250285L;

	/*Fields*/
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
	
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
	public boolean isNewUser() {
		return this.userId == null || this.userId == 0;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
