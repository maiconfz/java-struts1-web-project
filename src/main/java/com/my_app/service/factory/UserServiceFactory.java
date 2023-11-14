package com.my_app.service.factory;

import java.sql.Connection;

import com.my_app.repo.impl.UserRepositoryImpl;
import com.my_app.service.UserService;
import com.my_app.service.impl.UserServiceImpl;

public class UserServiceFactory implements ServiceFactory<UserService> {

	@Override
	public UserService create(Connection conn) {
		return new UserServiceImpl(new UserRepositoryImpl(conn));
	}

}
