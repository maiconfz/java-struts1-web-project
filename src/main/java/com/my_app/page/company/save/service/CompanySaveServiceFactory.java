package com.my_app.page.company.save.service;

import java.sql.Connection;

import com.my_app.service.factory.CityServiceFactory;
import com.my_app.service.factory.ConnectionBasedServiceFactory;
import com.my_app.service.factory.CountryServiceFactory;
import com.my_app.service.factory.CompanyServiceFactory;

public class CompanySaveServiceFactory implements ConnectionBasedServiceFactory<CompanySaveService> {

	@Override
	public CompanySaveService create(Connection conn) {
		return new CompanySaveServiceImpl(new CompanyServiceFactory().create(conn), new CountryServiceFactory().create(conn),
				new CityServiceFactory().create(conn));
	}
}
