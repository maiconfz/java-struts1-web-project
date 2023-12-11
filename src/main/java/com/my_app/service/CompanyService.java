package com.my_app.service;

import com.my_app.model.Company;

/**
 * The UserService interface extends the BaseService interface
 * and provides additional methods specific to user-related operations.
 */
public interface CompanyService extends BaseService<Company, Long> {

	/**
     * Finds a user by their username.
     *
     * @param username The username of the user.
     * @return The User object if found, otherwise null.
     */
	Company findByCompanyName(String username);

	
	Company findByCompanyIvaNumber(String ivaNumber);


}