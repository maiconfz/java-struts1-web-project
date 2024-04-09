package com.my_app.repo.impl;

import java.sql.Connection;
import java.util.List;

import com.my_app.model.Company;
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
		// TODO Auto-generated method stub
		return null;
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
