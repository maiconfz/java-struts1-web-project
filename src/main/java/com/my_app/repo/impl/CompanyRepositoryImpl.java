package com.my_app.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.my_app.exception.AppGenericException;
import com.my_app.model.Company;
import com.my_app.model.User;
import com.my_app.repo.CityRepository;
import com.my_app.repo.CompanyRepository;

public class CompanyRepositoryImpl implements CompanyRepository {
	
	private final Connection conn;
	private final CityRepository cityRepository;
	
	public CompanyRepositoryImpl(Connection conn, CityRepository cityRepository) {
		super();
		this.conn = conn;
		this.cityRepository = cityRepository;
	}

	@Override
	public Company save(Company o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		
		try (final PreparedStatement stmt = this.conn.prepareStatement("SELECT ID, NAME, ADDRESS, CITY_ID, VAT FROM \"COMPANY\"");
				final ResultSet rs = stmt.executeQuery()) {
			final List<Company> companies = new LinkedList<>();
			
			while (rs.next()) {
				companies.add(new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), this.cityRepository.findById(rs.getLong(5))));
			}
			
			return companies;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all companies", e);
		}
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Company o) {
		// TODO Auto-generated method stub
		
	}

}
