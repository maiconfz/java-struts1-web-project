package com.my_app.page.user.save.service;

import java.sql.Connection;

import com.my_app.service.factory.ConnectionBasedServiceFactory;
import com.my_app.service.factory.UserServiceFactory;

public class UserSaveServiceFactory implements ConnectionBasedServiceFactory<UserSaveService> {

	@Override
	public UserSaveService create(Connection conn) {
		return new UserSaveServiceImpl(new UserServiceFactory().create(conn));
	}
}
