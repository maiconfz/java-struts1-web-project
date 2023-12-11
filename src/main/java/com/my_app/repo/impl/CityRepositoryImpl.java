package com.my_app.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.my_app.exception.AppGenericException;
import com.my_app.model.City;
import com.my_app.model.Country;
import com.my_app.repo.CityRepository;
import com.my_app.repo.CountryRepository;

public class CityRepositoryImpl implements CityRepository {

	private final Connection conn;

	private final CountryRepository countryRepository;

	public CityRepositoryImpl(Connection conn, CountryRepository countryRepository) {
		super();
		this.conn = conn;
		this.countryRepository = countryRepository;
	}

	@Override
	public City save(City city) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("INSERT INTO CITY (NAME, COUNTRY_ID) VALUES (?, ?)")) {

			stmt.setString(1, city.getName());
			stmt.setLong(2, city.getCountry().getId());

			stmt.executeUpdate();

			return this.findByName(city.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while creating City", e);
		}
	}

	@Override
	public City findById(Long id) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, COUNTRY_ID FROM CITY WHERE ID = ?")) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new City(rs.getLong(1), rs.getString(2), this.countryRepository.findById(rs.getLong(3)));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for City", e);
		}
	}

	@Override
	public City findByName(String name) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, COUNTRY_ID FROM CITY WHERE NAME = ?")) {

			stmt.setString(1, name);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new City(rs.getLong(1), rs.getString(2), this.countryRepository.findById(rs.getLong(3)));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for City", e);
		}
	}

	@Override
	public List<City> findAll() {
		try (final PreparedStatement stmt = this.conn.prepareStatement("SELECT ID, NAME, COUNTRY_ID FROM CITY");
				final ResultSet rs = stmt.executeQuery()) {

			final List<City> cities = new LinkedList<>();

			final Map<Long, Country> idCountryMap = new HashMap<>();

			while (rs.next()) {

				final Long countryId = rs.getLong(3);

				if (!idCountryMap.containsKey(countryId)) {
					idCountryMap.put(countryId, this.countryRepository.findById(countryId));
				}

				cities.add(new City(rs.getLong(1), rs.getString(2), idCountryMap.get(countryId)));
			}

			return cities;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all Countries", e);
		}
	}

	@Override
	public List<City> findAllByCountryId(Long countryId) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME FROM CITY WHERE COUNTRY_ID = ?")) {

			stmt.setLong(1, countryId);

			final List<City> cities = new LinkedList<>();
			final Country country = this.countryRepository.findById(countryId);

			try (final ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					cities.add(new City(rs.getLong(1), rs.getString(2), country));
				}
			}

			return cities;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all Countries", e);
		}
	}

	@Override
	public List<City> findAllByCountry(Country country) {
		return this.findAllByCountryId(country.getId());
	}

	@Override
	public void deleteById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("DELETE CITY WHERE ID = ?")) {

			stmt.setLong(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppGenericException("Error while deleting User", e);
		}
	}

	@Override
	public void delete(City city) {
		this.deleteById(city.getId());
	}

}
