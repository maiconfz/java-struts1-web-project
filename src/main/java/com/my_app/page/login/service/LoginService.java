package com.my_app.page.login.service;

import com.my_app.page.login.LoginForm;

/**
 * LoginService interface defines methods for validating login credentials.
 * Implementing classes should provide the logic to validate user login information.
 */
public interface LoginService {
	
	/**
     * Validates the login credentials based on the provided login form.
     *
     * @param form The LoginForm containing user credentials.
     * @return True if the credentials are valid, otherwise false.
     */
	public boolean validate(LoginForm form);
}
