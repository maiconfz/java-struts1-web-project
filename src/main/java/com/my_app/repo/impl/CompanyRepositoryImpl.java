package com.my_app.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my_app.exception.AppGenericException;
import com.my_app.model.Company;
import com.my_app.repo.CityRepository;
import com.my_app.repo.CompanyRepository;

public class CompanyRepositoryImpl implements CompanyRepository {
	
	private static final String COUNT_STATEMENT = ""
			+ "SELECT count(*) FROM \"COMPANY\"";

	private static final String DELETE_STATEMENT = "DELETE \"COMPANY\" WHERE ID = ?";

	private static final String SELECT_ALL_STATEMENT = ""
			+ "SELECT ID, NAME, ADDRESS, VAT, CITY_ID "
			+ "FROM \"COMPANY\" ";

	private static final String SELECT_BY_NAME = ""
			+ "SELECT ID, NAME, ADDRESS, VAT, CITY_ID "
			+ "FROM \"COMPANY\" "
			+ "WHERE NAME = ?";

	private static final String SELECT_BY_ID_STATEMENT = ""
			+ "SELECT ID, NAME, ADDRESS, VAT, CITY_ID "
			+ "FROM \"COMPANY\" "
			+ "WHERE ID = ?";

	private static final String UPDATE_STATEMENT = ""
			+ "UPDATE \"COMPANY\" "
			+ "SET NAME = ?, ADDRESS = ?, VAT = ?, CITY_ID = ? "
			+ "WHERE ID = ?";

	private static final String INSERT_STATMENT = ""
			+ "INSERT INTO \"COMPANY\" "
			+ "(NAME, ADDRESS, VAT, CITY_ID ) "
			+ "VALUES "
			+ "(?, ?, ?, ?)";
	
	private final Connection conn;
	private final CityRepository cityRepository;
	
	public CompanyRepositoryImpl(Connection conn, CityRepository cityRepository) {
		super();
		this.conn = conn;
		this.cityRepository = cityRepository;
	}

	@Override
	public Company save(Company company) {
		if( null == company.getId() ) {
			return this.create(company);
		}
		return this.update(company);
	}
	
	private Company create(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement(INSERT_STATMENT)) {
			
			stmt.setString(1, company.getName());
			stmt.setString(2, company.getAddress());
			stmt.setString(3, company.getVat());
			stmt.setLong(4, company.getCity().getId());
			
			stmt.executeUpdate();
			
			return this.findByName(company.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while inserting company", e);
		}
	}
	
	private Company update(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement(UPDATE_STATEMENT)) {
			
			stmt.setString(1, company.getName());
			stmt.setString(2, company.getAddress());
			stmt.setString(3, company.getVat());
			stmt.setLong(4, company.getCity().getId());
			stmt.setLong(5, company.getId());
			
			stmt.executeUpdate();
			
			return this.findByName(company.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while updating company", e);
		}
	}

	@Override
	public Company findById(Long id) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement(SELECT_BY_ID_STATEMENT)) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3),
							rs.getString(4), this.cityRepository.findById(rs.getLong(5)));
				}
			}
			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying by id for company", e);
		}
	}

	@Override
	public List<Company> findAll() {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement(SELECT_ALL_STATEMENT);
				final ResultSet rs = stmt.executeQuery()) {

			final List<Company> companies = new ArrayList<>();

			while (rs.next()) {
				companies.add(new Company(rs.getLong(1), rs.getString(2), rs.getString(3),
						rs.getString(4), this.cityRepository.findById(rs.getLong(5))));
			}

			return companies;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all companies", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement(DELETE_STATEMENT)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppGenericException("Error while deleting for company", e);
		}
	}
	
	@Override
	public void delete(Company company) {
		this.deleteById(company.getId());
	}

	@Override
	public Company findByName(String name) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement(SELECT_BY_NAME)) {

			stmt.setString(1, name);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3),
							rs.getString(4), this.cityRepository.findById(rs.getLong(5)));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying by name for company", e);
		}
	}

	@Override
	public boolean hasCompanies() {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement(COUNT_STATEMENT);
				final ResultSet rs = stmt.executeQuery()) {

			boolean result = false;

			while (rs.next()) {
				result = rs.getLong(1) > 0;
			}

			return result;
		} catch (SQLException e) {
			throw new AppGenericException("Error while counting all companies", e);
		}
	}

}
