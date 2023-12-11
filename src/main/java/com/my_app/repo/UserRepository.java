package com.my_app.repo;

import com.my_app.model.User;

public interface UserRepository extends Repository<User, Long> {

	User findByUsername(String username);
	
	User findByEmail(String email);

}
