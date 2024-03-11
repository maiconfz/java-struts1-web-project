package com.my_app.page.user.save.mapper;

import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;

public class UserToUserSaveFormMapper {

	public UserSaveForm toUserSaveForm(User user) {
		return this.mapTo(user, new UserSaveForm());
	}

	public UserSaveForm mapTo(User user, UserSaveForm form) {

		form.setUserId(user.getId());
		form.setUsername(user.getUsername());
		form.setCountryId(user.getCity().getCountry().getId());
		form.setCityId(user.getCity().getId());
		form.setEmail(user.getEmail());// cahango
		return form;
	}

}
