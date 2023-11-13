package com.my_app.login;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionError;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean validate(LoginForm form) {
		boolean isValid = true;

		if (StringUtils.isBlank(form.getUsername())) {
			isValid = false;
			form.getActionErrors().add("username", new ActionError("error.common.required"));
		}

		if (StringUtils.isBlank(form.getPassword())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionError("error.common.required"));
		}

		return isValid;

	}

}
