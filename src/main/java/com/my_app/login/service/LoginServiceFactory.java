package com.my_app.login.service;

import java.sql.Connection;

import com.my_app.service.factory.ConnectionBasedServiceFactory;
import com.my_app.service.factory.UserServiceFactory;

public class LoginServiceFactory implements ConnectionBasedServiceFactory<LoginService> {

	@Override
	public LoginService create(Connection conn) {
		return new LoginServiceImpl(new UserServiceFactory().create(conn));
	}
}
