package com.my_app.page.user.save.mapper;

import com.my_app.model.City;
import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;

public class UserSaveFormToUserMapper {

	public User toUser(UserSaveForm form) {

		final City city = new City(form.getCityId());

		return new User(Long.valueOf(0).equals(form.getUserId()) ? null : form.getUserId(), form.getUsername(),
				form.getPassword(), city, form.getEmail());
	}
}
