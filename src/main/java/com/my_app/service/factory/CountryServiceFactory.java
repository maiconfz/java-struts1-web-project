package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.service.CountryService;
import com.my_app.service.impl.CountryServiceImpl;

/**
 * The CountryServiceFactory class implements the ConnectionBasedServiceFactory interface
 * to create instances of the CountryService with a given database connection.
 */
public class CountryServiceFactory implements ConnectionBasedServiceFactory<CountryService> {

	/**
     * Creates an instance of CountryService with the provided database connection.
     *
     * @param conn The database connection.
     * @return An instance of CountryService.
     */
	@Override
	public CountryService create(Connection conn) {
		return new CountryServiceImpl(new CountryRepositoryImpl(conn));
	}

}
