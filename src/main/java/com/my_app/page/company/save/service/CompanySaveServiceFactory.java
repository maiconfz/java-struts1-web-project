package com.my_app.page.company.save.service;

import java.sql.Connection;

import com.my_app.service.factory.CityServiceFactory;
import com.my_app.service.factory.ConnectionBasedServiceFactory;
import com.my_app.service.factory.CountryServiceFactory;
import com.my_app.service.factory.CompanyServiceFactory;

/**
 * The UserSaveServiceFactory class implements the ConnectionBasedServiceFactory
 * to create instances of UserSaveService, initializing them with necessary dependencies.
 */
public class CompanySaveServiceFactory implements ConnectionBasedServiceFactory<CompanySaveService> {

	/**
     * Creates a new instance of UserSaveService, initializing it with UserService,
     * CountryService, and CityService instances based on the provided Connection.
     *
     * @param conn The database Connection used to create dependent services.
     * @return A new UserSaveService instance with initialized dependencies.
     */
	@Override
	public CompanySaveService create(Connection conn) {
		return new CompanySaveServiceImpl(new CompanyServiceFactory().create(conn), new CountryServiceFactory().create(conn),
				new CityServiceFactory().create(conn));
	}
}