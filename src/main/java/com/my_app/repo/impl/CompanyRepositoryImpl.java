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
import com.my_app.repo.CountryRepository;
import com.my_app.utils.UserUtils;

public class CompanyRepositoryImpl implements CompanyRepository {
	
	private final Connection conn;
	private final CityRepository cityRepository;
	//private final CountryRepository countryRepository;
	
	
	public CompanyRepositoryImpl(Connection conn, CityRepository cityRepository) {
		
		super();
		this.conn = conn;
		this.cityRepository = cityRepository;
		//this.countryRepository = countryRepository;
		
		
	}

	@Override
	public Company save(Company o) {
			
		if (o.isNew()) {
			return this.create(o);
		} else {
			return this.update(o);
		}
		//return null;
	}
	
	

	@Override
	public Company findById(Long id) {

		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADRESS,IVA, CITY_ID, COUNTRY FROM \"COMPANY\" WHERE ID = ?")) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3),rs.getInt(4),
							this.cityRepository.findById(rs.getLong(5)),rs.getLong(6));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying by id for Company", e);
		}
	}

	@Override
	public List<Company> findAll() {

		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADRESS,IVA, CITY_ID , COUNTRY  FROM \"COMPANY\"");
				final ResultSet rs = stmt.executeQuery()) {

			final List<Company> companies = new LinkedList<>();

			while (rs.next()) {
				companies.add(new Company(rs.getLong(1), rs.getString(2), rs.getString(3),rs.getInt(4),
						this.cityRepository.findById(rs.getLong(4)),rs.getLong(5)));
			}

			return companies;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all companies", e);
		}
	}
	
	@Override
	public void deleteById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("DELETE \"COMPANY\" WHERE ID = ?")) {

			stmt.setLong(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppGenericException("Error while deleting for COMPANY", e);
		}
	}

	@Override
	public void delete(Company o) {
		this.deleteById(o.getId());
		
	}

	@Override
	public Company findByName(String name) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADRESS,IVA, CITY_ID , COUNTRY FROM \"COMPANY\" WHERE NAME = ?")) {

			stmt.setString(1, name);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3),rs.getInt(4),
							this.cityRepository.findById(rs.getLong(4)),rs.getLong(5));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying by name for Company", e);
		}
	}
	
	
	private Company create(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("INSERT INTO \"COMPANY\" (NAME, ADRESS,IVA, CITY_ID, COUNTRY) VALUES (?, ?, ?,?,?)")) {

			stmt.setString(1,company.getName());
			stmt.setString(2, company.getAdress());
			stmt.setInt(3, company.getIva());
			stmt.setLong(4, company.getCity().getId());
			stmt.setLong(5, company.getCountry());


			stmt.executeUpdate();

			return this.findByName(company.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while inserting Company", e);
		}
	}

	private Company update(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("UPDATE \"COMPANY\" SET NAME = ?, ADRESS = ?,IVA=?, CITY_ID = ? , COUNTRY = ? WHERE ID = ?")) {

		
			stmt.setString(1,company.getName());
			stmt.setString(2, company.getAdress());
			stmt.setInt(3, company.getIva());
			stmt.setLong(4, company.getCity().getId());
			stmt.setLong(5, company.getCountry());
			stmt.setLong(6, company.getId());
			

			stmt.executeUpdate();

			return this.findByName(company.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while updating Company", e);
		}
	}

}
