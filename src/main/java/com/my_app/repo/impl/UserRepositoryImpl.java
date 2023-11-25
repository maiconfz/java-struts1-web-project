package com.my_app.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.my_app.exception.AppGenericException;
import com.my_app.model.User;
import com.my_app.repo.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private final Connection conn;

	public UserRepositoryImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public User save(User user) {
		if (user.isNew()) {
			return this.create(user);
		} else {
			return this.update(user);
		}
	}

	private User create(User user) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("INSERT INTO \"USER\" (USERNAME, PASSWORD) VALUES (?, ?)")) {

			stmt.setString(1, StringUtils.lowerCase(user.getUsername()));
			stmt.setString(2, user.getPassword());

			stmt.executeUpdate();

			return this.findByUsername(user.getUsername());
		} catch (SQLException e) {
			throw new AppGenericException("Error while inserting User", e);
		}
	}

	private User update(User user) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("UPDATE \"USER\" SET USERNAME = ?, PASSWORD = ? WHERE ID = ?")) {

			stmt.setString(1, StringUtils.lowerCase(user.getUsername()));
			stmt.setString(2, user.getPassword());
			stmt.setLong(3, user.getId());

			stmt.executeUpdate();

			return this.findByUsername(user.getUsername());
		} catch (SQLException e) {
			throw new AppGenericException("Error while updating User", e);
		}
	}

	@Override
	public User findById(Long id) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, USERNAME, PASSWORD FROM \"USER\" WHERE ID = ?")) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new User(rs.getLong(1), rs.getString(2), rs.getString(3));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for User", e);
		}
	}

	@Override
	public User findByUsername(String username) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, USERNAME, PASSWORD FROM \"USER\" WHERE USERNAME = ?")) {

			stmt.setString(1, StringUtils.lowerCase(username));

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new User(rs.getLong(1), rs.getString(2), rs.getString(3));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for User", e);
		}
	}

	@Override
	public List<User> findAll() {
		try (final PreparedStatement stmt = this.conn.prepareStatement("SELECT ID, USERNAME, PASSWORD FROM \"USER\"");
				final ResultSet rs = stmt.executeQuery()) {

			final List<User> users = new LinkedList<>();

			while (rs.next()) {
				users.add(new User(rs.getLong(1), rs.getString(2), rs.getString(3)));
			}

			return users;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all users", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("DELETE \"USER\" WHERE ID = ?")) {

			stmt.setLong(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for User", e);
		}
	}

	@Override
	public void delete(User user) {
		this.deleteById(user.getId());
	}

}
