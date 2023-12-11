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
import com.my_app.repo.CountryRepository;
import com.my_app.repo.CompanyRepository;
import com.my_app.repo.UserRepository;
import com.my_app.utils.CompanyUtils;

public class CompanyRepositoryImpl implements CompanyRepository {

	private final Connection conn;
	private final CityRepository cityRepository;

	public CompanyRepositoryImpl(Connection conn, CityRepository cityRepository) {
		super();
		this.conn = conn;
		this.cityRepository = cityRepository;
	}

	@Override
	public Company save(Company company) {
		if (company.isNew()) {
			return this.create(company);
		} else {
			return this.update(company);
		}
	}
	
	private Company create(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("INSERT INTO \"COMPANY\" (NAME, ADDRESS, IVA, CITY_ID) VALUES (?, ?, ?, ?)")) {
			stmt.setString(1, CompanyUtils.normalizeConpanyName(company.getName()));
			stmt.setString(2, company.getAddress());
			stmt.setString(3, company.getIvaNumber());
			stmt.setLong(4, company.getCity().getId());
			
			stmt.executeUpdate();

			return this.findByCompanyName(company.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while inserting User", e);
		}
	}
	
	private Company update(Company company) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("UPDATE \"COMPANY\" SET NAME = ?, ADDRESS = ?, IVA = ?, CITY_ID = ? WHERE ID = ?")) {

			//COMPANYUTILS
			stmt.setString(1, CompanyUtils.normalizeConpanyName(company.getName()));
			stmt.setString(2, company.getAddress());
			stmt.setString(3, company.getIvaNumber());
			stmt.setLong(4, company.getCity().getId());
			
			stmt.executeUpdate();

			return this.findByCompanyName(company.getName());
		} catch (SQLException e) {
			throw new AppGenericException("Error while inserting User", e);
		}
	}

	@Override
	public Company findById(Long id) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADDRESS, IVA, CITY_ID FROM \"COMPANY\" WHERE ID = ?")) {

			stmt.setLong(1, id);

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							this.cityRepository.findById(rs.getLong(5)));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying by id for User", e);
		}
	}

	@Override
	public List<Company> findAll() {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, NAME, ADDRESS, IVA, CITY_ID FROM \"COMPANY\"");
				final ResultSet rs = stmt.executeQuery()) {

			final List<Company> companies = new LinkedList<>();

			while (rs.next()) {
				companies.add(new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						this.cityRepository.findById(rs.getLong(5))));
			}

			return companies;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying for all users", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		try (final PreparedStatement stmt = this.conn.prepareStatement("DELETE \"COMPANY\" WHERE ID = ?")) {

			stmt.setLong(1, id);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new AppGenericException("Error while deleting for User", e);
		}
	}

	@Override
	public void delete(Company company) {
		this.deleteById(company.getId());
	}

	@Override
	public Company findByCompanyName(String name) {
		try (final PreparedStatement stmt = this.conn
				.prepareStatement("SELECT ID, USERNAME, PASSWORD, EMAIL, CITY_ID FROM \"USER\" WHERE USERNAME = ?")) {

			stmt.setString(1, CompanyUtils.normalizeConpanyName(name));

			try (final ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							this.cityRepository.findById(rs.getLong(5)));
				}
			}

			return null;
		} catch (SQLException e) {
			throw new AppGenericException("Error while querying by username for User", e);
		}
	}

	@Override
	public Company findByCompanyIvaNumber(String ivaNumber) {
		try (final PreparedStatement stmt = this.conn
                .prepareStatement("SELECT ID, USERNAME, PASSWORD, CITY_ID FROM \"USER\" WHERE EMAIL = ?")) {

            stmt.setString(1, ivaNumber);

            try (final ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                	return new Company(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							this.cityRepository.findById(rs.getLong(5)));
                }
            }

            return null;
        } catch (SQLException e) {
            throw new AppGenericException("Error while querying by email for User", e);
        }
	}


}