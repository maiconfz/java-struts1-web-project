package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.User;
import com.my_app.repo.UserRepository;
import com.my_app.service.UserService;

/**
 * The UserServiceImpl class implements the UserService interface and provides
 * the implementation for CRUD operations related to the User entity.
 */
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	/**
     * Constructs a UserServiceImpl with the specified UserRepository.
     *
     * @param userRepository The UserRepository to be used for database operations.
     */
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
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
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
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
