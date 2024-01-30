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
import com.my_app.model.Company;
import com.my_app.model.Country;
import com.my_app.repo.CityRepository;
import com.my_app.repo.CompanyRepository;
import com.my_app.repo.CountryRepository;

public class CompanyRepositoryImpl implements CompanyRepository {

	private final Connection conn;

	private final CountryRepository countryRepository;
	private final CityRepository cityRepository;

	public CompanyRepositoryImpl(Connection conn, CountryRepository countryRepository, CityRepository cityRepository) {
		super();
		this.conn = conn;
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
	}

	@Override
	public Company save(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("INSERT INTO COMPANY (NAME, ADDRESS, IVA, COUNTRY_ID, CITY_ID) VALUES (?, ?, ?, ?, ?)")) {

			stmt.setString(1, company.getName());
			stmt.setString(2, company.getAddress());
			stmt.setInt(3, company.getIva());
			stmt.setLong(4, company.getCountry().getId());
			stmt.setLong(5, company.getCity().getId());

			stmt.executeUpdate();

			return this.findByName(company.getName());
			
		} catch (SQLException e) {
			throw new AppGenericException("Error while creating Company", e);
		}
	}

	@Override
	public Company findById(Long id) {
		
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADDRESS, IVA, COUNTRY_ID, CITY_ID FROM COMPANY WHERE ID = ?")) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2),rs.getString(3), rs.getInt(4), 
							this.countryRepository.findById(rs.getLong(5)), this.cityRepository.findById(rs.getLong(6))   );
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for Company", e);
		}
	}

	@Override
	public Company findByName(String name) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADDRESS, IVA, COUNTRY_ID, CITY_ID FROM COMPANY WHERE NAME = ?")) {

			stmt.setString(1, name);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
							this.countryRepository.findById(rs.getLong(5)), this.cityRepository.findById(rs.getLong(6))   );
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for Company", e);
		}
	}

	@Override
	public List<Company> findAll() {
		try (final PreparedStatement stmt = 
				this.conn.prepareStatement("SELECT ID, NAME, ADDRESS, IVA, COUNTRY_ID, CITY_ID FROM COMPANY");
				final ResultSet rs = stmt.executeQuery()) {

			final List<Company> companies = new LinkedList<>();
			
			final Map<Long, Country> idCountryMap = new HashMap<>();

			final Map<Long, City> idCityMap = new HashMap<>();
			
			while (rs.next()) {

				final Long countryId = rs.getLong(4);
				
				final Long cityId = rs.getLong(5);

				if (!idCountryMap.containsKey(countryId)) {
					idCountryMap.put(countryId, this.countryRepository.findById(countryId));
				}
				
				if (!idCityMap.containsKey(cityId)) {
					idCityMap.put(cityId, this.cityRepository.findById(cityId));
				}

				companies.add(new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), idCountryMap.get(countryId), idCityMap.get(cityId)));
			}

			return companies;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all Companies", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("DELETE COMPANY WHERE ID = ?")) {

			stmt.setLong(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppGenericException("Error while deleting Company", e);
		}
	}

	@Override
	public void delete(Company company) {
		this.deleteById(company.getId());
		
	}

}
