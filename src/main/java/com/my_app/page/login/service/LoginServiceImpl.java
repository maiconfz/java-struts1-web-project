package com.my_app.page.login.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.my_app.page.login.LoginForm;
import com.my_app.service.UserService;


/**
 * LoginServiceImpl is an implementation of the LoginService interface.
 * It provides logic to validate user login credentials and interacts with the UserService.
 */
public class LoginServiceImpl implements LoginService {

	 /**
     * The UserService used for checking user credentials.
     */
	final UserService userService;

	/**
     * Constructs a LoginServiceImpl with the specified UserService.
     *
     * @param userService The UserService to be used for credential validation.
     */
	
	public LoginServiceImpl(UserService userService) {
		this.userService = userService;
	}

	/**
     * Validates the login credentials based on the provided login form.
     * Checks if the username and password are not blank, and if the password matches the stored password for the user.
     * Adds appropriate error messages to the login form for validation failures.
     *
     * @param form The LoginForm containing user credentials.
     * @return True if the credentials are valid, otherwise false.
     */
	@Override
	public boolean validate(LoginForm form) {
		boolean isValid = true;

		if (StringUtils.isBlank(form.getUsername())) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("error.common.required"));
		}

		if (StringUtils.isBlank(form.getPassword())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionMessage("error.common.required"));
		} else if (!this.userService.userMatchPassword(form.getUsername(), form.getPassword())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionMessage("error.password.wrong"));
		}

		return isValid;
	}

}
