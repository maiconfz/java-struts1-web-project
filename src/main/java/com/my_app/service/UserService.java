package com.my_app.service;

import com.my_app.model.User;

public interface UserService extends BaseService<User, Long> {

	User findByUsername(String username);

	boolean userMatchPassword(String username, String password);

}
