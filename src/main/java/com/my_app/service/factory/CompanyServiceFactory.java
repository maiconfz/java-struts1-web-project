package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CompanyRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.service.CompanyService;
import com.my_app.service.impl.CompanyServiceImpl;

public class CompanyServiceFactory implements ConnectionBasedServiceFactory<CompanyService> {

	@Override
	public CompanyService create(Connection conn) {
		CountryRepositoryImpl countryRepository = new CountryRepositoryImpl(conn);
		return new CompanyServiceImpl(new CompanyRepositoryImpl(conn, countryRepository , new CityRepositoryImpl(conn, countryRepository)));
	}

}