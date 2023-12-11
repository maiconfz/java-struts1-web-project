package com.my_app.service;

import com.my_app.model.User;

/**
 * The UserService interface extends the BaseService interface
 * and provides additional methods specific to user-related operations.
 */
public interface UserService extends BaseService<User, Long> {

	/**
     * Finds a user by their username.
     *
     * @param username The username of the user.
     * @return The User object if found, otherwise null.
     */
	User findByUsername(String username);

	
	User findByEmail(String email);
	
	/**
     * Checks if the provided username and password match a user's credentials.
     *
     * @param username The username of the user.
     * @param password The password to check.
     * @return true if the username and password match, false otherwise.
     */
	boolean userMatchPassword(String username, String password);

}
