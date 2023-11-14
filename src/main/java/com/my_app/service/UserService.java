package com.my_app.service;

import com.my_app.model.User;

public interface UserService {

	User findById(Long id);

	User findByUsername(String username);

}
