package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.service.CityService;
import com.my_app.service.impl.CityServiceImpl;

/**
 * The CityServiceFactory class implements the ConnectionBasedServiceFactory interface
 * to create instances of CityService with a provided database connection.
 */
public class CityServiceFactory implements ConnectionBasedServiceFactory<CityService> {

	/**
     * Creates a new instance of CityService with the given database connection.
     *
     * @param conn The database connection.
     * @return A new CityService instance.
     */
	@Override
	public CityService create(Connection conn) {
		return new CityServiceImpl(new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn)));
	}

}
