package com.my_app.page.user.save.service;

import java.sql.Connection;

import com.my_app.service.factory.CityServiceFactory;
import com.my_app.service.factory.ConnectionBasedServiceFactory;
import com.my_app.service.factory.CountryServiceFactory;
import com.my_app.service.factory.UserServiceFactory;

/**
 * The UserSaveServiceFactory class implements the ConnectionBasedServiceFactory
 * to create instances of UserSaveService, initializing them with necessary dependencies.
 */
public class UserSaveServiceFactory implements ConnectionBasedServiceFactory<UserSaveService> {

	/**
     * Creates a new instance of UserSaveService, initializing it with UserService,
     * CountryService, and CityService instances based on the provided Connection.
     *
     * @param conn The database Connection used to create dependent services.
     * @return A new UserSaveService instance with initialized dependencies.
     */
	@Override
	public UserSaveService create(Connection conn) {
		return new UserSaveServiceImpl(new UserServiceFactory().create(conn), new CountryServiceFactory().create(conn),
				new CityServiceFactory().create(conn));
	}
}
