package com.my_app.repo;

import com.my_app.model.User;

/**
 * The UserRepository interface extends the base Repository interface and
 * defines additional methods specific to User entities.
 */
public interface UserRepository extends Repository<User, Long> {

	/**
     * Finds a user by their username.
     *
     * @param username The username of the user to be found.
     * @return The user with the specified username, or null if not found.
     */
	User findByUsername(String username);
	
	User findByEmail(String email);

}
