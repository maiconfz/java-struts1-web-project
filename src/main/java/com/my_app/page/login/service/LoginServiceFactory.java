package com.my_app.page.login.service;

import java.sql.Connection;

import com.my_app.service.factory.ConnectionBasedServiceFactory;
import com.my_app.service.factory.UserServiceFactory;

/**
 * LoginServiceFactory is a factory class responsible for creating instances of the LoginService interface.
 * It utilizes a Connection to create a LoginServiceImpl, which, in turn, relies on a UserService instance.
 */
public class LoginServiceFactory implements ConnectionBasedServiceFactory<LoginService> {

	/**
     * Creates and returns a LoginService instance based on the provided Connection.
     * It initializes a LoginServiceImpl with a UserService instance created using a UserServiceFactory.
     *
     * @param conn The Connection to be used in the creation of the LoginService.
     * @return A LoginService instance ready for use.
     */
	@Override
	public LoginService create(Connection conn) {
		return new LoginServiceImpl(new UserServiceFactory().create(conn));
	}
}
