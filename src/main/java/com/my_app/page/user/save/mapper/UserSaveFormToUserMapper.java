package com.my_app.page.user.save.mapper;

import com.my_app.model.City;
import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;

/**
* UserSaveFormToUserMapper is a mapper class responsible for converting a UserSaveForm instance
* to a User instance. It facilitates the transformation of form data into a User object for storage
* or further processing.
*/
public class UserSaveFormToUserMapper {

	/**
     * Converts a UserSaveForm instance to a User instance.
     *
     * @param form The UserSaveForm instance containing user input data.
     * @return A User instance created from the provided form data.
     */
	public User toUser(UserSaveForm form) {

		final City city = new City(form.getCityId());

		return new User(Long.valueOf(0).equals(form.getUserId()) ? null : form.getUserId(), form.getUsername(),
				form.getPassword(), form.getEmail(), city);
	}
}
