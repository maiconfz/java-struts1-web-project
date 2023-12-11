package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.service.CountryService;
import com.my_app.service.impl.CountryServiceImpl;

public class CountryServiceFactory implements ConnectionBasedServiceFactory<CountryService> {

	@Override
	public CountryService create(Connection conn) {
		return new CountryServiceImpl(new CountryRepositoryImpl(conn));
	}

}
