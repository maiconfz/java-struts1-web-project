package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.Company;
import com.my_app.repo.CompanyRepository;
import com.my_app.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	
	private final CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public Company save(Company o) {
		return companyRepository.save(o);
	}

	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
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
