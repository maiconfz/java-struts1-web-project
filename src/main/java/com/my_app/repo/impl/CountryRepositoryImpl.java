package com.my_app.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.my_app.exception.AppGenericException;
import com.my_app.model.Country;
import com.my_app.repo.CountryRepository;

public class CountryRepositoryImpl implements CountryRepository {

	private final Connection conn;

	public CountryRepositoryImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Country save(Country country) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO COUNTRY (NAME) VALUES (?)")) {

			stmt.setString(1, country.getName());

			stmt.executeUpdate();

			return this.findByName(country.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while creating Country", e);
		}
	}

	@Override
	public Country findById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("SELECT ID, NAME FROM COUNTRY WHERE ID = ?")) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Country(rs.getLong(1), rs.getString(2));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for Country", e);
		}
	}

	@Override
	public Country findByName(String name) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("SELECT ID, NAME FROM COUNTRY WHERE NAME = ?")) {

			stmt.setString(1, name);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Country(rs.getLong(1), rs.getString(2));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for Country", e);
		}
	}

	@Override
	public List<Country> findAll() {
		try (final PreparedStatement stmt = this.conn.prepareStatement("SELECT ID, NAME FROM COUNTRY");
				final ResultSet rs = stmt.executeQuery()) {

			final List<Country> countries = new LinkedList<>();

			while (rs.next()) {
				countries.add(new Country(rs.getLong(1), rs.getString(2)));
			}

			return countries;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all Countries", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Country o) {
		// TODO Auto-generated method stub

	}

}
