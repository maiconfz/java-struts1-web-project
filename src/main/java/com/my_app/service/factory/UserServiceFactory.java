package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.repo.impl.UserRepositoryImpl;
import com.my_app.service.UserService;
import com.my_app.service.impl.UserServiceImpl;

/**
 * The UserServiceFactory class implements the ConnectionBasedServiceFactory interface
 * to create instances of the UserService with a given database connection.
 */
public class UserServiceFactory implements ConnectionBasedServiceFactory<UserService> {

	/**
     * Creates an instance of UserService with the provided database connection.
     *
     * @param conn The database connection.
     * @return An instance of UserService.
     */
	@Override
	public UserService create(Connection conn) {
		return new UserServiceImpl(
				new UserRepositoryImpl(conn, new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn))));
	}

}
