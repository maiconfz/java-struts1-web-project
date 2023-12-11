package com.my_app.page.user.save.mapper;

import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;

/**
 * UserToUserSaveFormMapper is a mapper class responsible for converting a User instance
 * to a UserSaveForm instance. It provides methods for mapping user data to a form for editing
 * or displaying.
 */
public class UserToUserSaveFormMapper {

	/**
     * Converts a User instance to a UserSaveForm instance.
     *
     * @param user The User instance to be converted.
     * @return A UserSaveForm instance populated with data from the provided User.
     */
	public UserSaveForm toUserSaveForm(User user) {
		return this.mapTo(user, new UserSaveForm());
	}

	/**
     * Maps data from a User instance to a UserSaveForm instance.
     *
     * @param user The User instance as the data source.
     * @param form The UserSaveForm instance to be populated.
     * @return The UserSaveForm instance populated with data from the provided User.
     */
	public UserSaveForm mapTo(User user, UserSaveForm form) {

		form.setUserId(user.getId());
		form.setUsername(user.getUsername());
		form.setPassword(user.getPassword());
		form.setEmail(user.getEmail());
		form.setCountryId(user.getCity().getCountry().getId());
		form.setCityId(user.getCity().getId());

		return form;
	}

}
