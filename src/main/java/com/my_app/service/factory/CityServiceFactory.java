package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.service.CityService;
import com.my_app.service.impl.CityServiceImpl;

public class CityServiceFactory implements ConnectionBasedServiceFactory<CityService> {

	@Override
	public CityService create(Connection conn) {
		return new CityServiceImpl(new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn)));
	}

}
