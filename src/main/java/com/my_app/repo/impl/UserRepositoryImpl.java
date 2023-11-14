package com.my_app.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			stmt.setString(1, username);
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

}
