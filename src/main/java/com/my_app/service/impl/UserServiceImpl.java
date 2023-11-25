package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.User;
import com.my_app.repo.impl.UserRepositoryImpl;
import com.my_app.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepositoryImpl userRepository;

	public UserServiceImpl(UserRepositoryImpl userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		return this.userRepository.create(user);
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public boolean userMatchPassword(String username, String password) {
		final User user = this.findByUsername(username);
		return user.getPassword().equals(password);
	}

	@Override
	public void deleteById(Long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public void delete(User user) {
		this.deleteById(user.getId());
	}

}
