package com.my_app.page.login.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.my_app.page.login.LoginForm;
import com.my_app.service.UserService;

public class LoginServiceImpl implements LoginService {

	final UserService userService;
	
	public LoginServiceImpl(UserService userService) {
		this.userService = userService;
	}

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
