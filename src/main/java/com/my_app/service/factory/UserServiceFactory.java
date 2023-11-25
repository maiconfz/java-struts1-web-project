package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.repo.impl.UserRepositoryImpl;
import com.my_app.service.UserService;
import com.my_app.service.impl.UserServiceImpl;

public class UserServiceFactory implements ConnectionBasedServiceFactory<UserService> {

	@Override
	public UserService create(Connection conn) {
		return new UserServiceImpl(
				new UserRepositoryImpl(conn, new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn))));
	}

}
