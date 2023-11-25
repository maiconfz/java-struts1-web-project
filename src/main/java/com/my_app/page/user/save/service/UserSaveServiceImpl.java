package com.my_app.page.user.save.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;
import com.my_app.page.user.save.mapper.UserSaveFormToUserMapper;
import com.my_app.page.user.save.mapper.UserToUserSaveFormMapper;
import com.my_app.service.UserService;

public class UserSaveServiceImpl implements UserSaveService {

	final UserService userService;

	public UserSaveServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void formInit(UserSaveForm form) {
		if (!form.isNewUser()) {
			final User user = this.userService.findById(form.getUserId());

			new UserToUserSaveFormMapper().mapTo(user, form);
		}
	}

	@Override
	public boolean validate(UserSaveForm form) {
		boolean isValid = true;

		if (StringUtils.isBlank(form.getUsername())) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("error.common.required"));
		} else if (userService.findByUsername(form.getUsername()) != null) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("error.user.username-taken"));
		}

		if (StringUtils.isBlank(form.getPassword())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionMessage("error.common.required"));
		}

		return isValid;
	}

	@Override
	public User saveUser(UserSaveForm form) {
		return this.userService.save(new UserSaveFormToUserMapper().toUser(form));
	}

}
