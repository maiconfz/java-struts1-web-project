package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.repo.impl.CompanyRepositoryImpl;
import com.my_app.service.CompanyService;
import com.my_app.service.impl.CompanyServiceImpl;

/**
 * The UserServiceFactory class implements the ConnectionBasedServiceFactory interface
 * to create instances of the UserService with a given database connection.
 */
public class CompanyServiceFactory implements ConnectionBasedServiceFactory<CompanyService> {

	/**
     * Creates an instance of UserService with the provided database connection.
     *
     * @param conn The database connection.
     * @return An instance of UserService.
     */
	@Override
	public CompanyService create(Connection conn) {
		return new CompanyServiceImpl(
				new CompanyRepositoryImpl(conn, new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn))));
	}

}