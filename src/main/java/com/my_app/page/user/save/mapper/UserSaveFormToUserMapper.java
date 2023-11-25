package com.my_app.page.user.save.mapper;

import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;

public class UserSaveFormToUserMapper {

	public User toUser(UserSaveForm form) {
		return new User(form.getUsername(), form.getPassword());
	}
}
