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
	public Company save(Company company) {
		return this.companyRepository.save(company);
	}

	@Override
	public Company findById(Long id) {
		return this.companyRepository.findById(id);
	}

	@Override
	public List<Company> findAll() {
		return this.companyRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.companyRepository.deleteById(id);
	}

	@Override
	public void delete(Company company) {
		this.companyRepository.delete(company);
	}

	@Override
	public Company findByCompanyName(String name) {
		return this.companyRepository.findByCompanyName(name);
	}

	@Override
	public Company findByCompanyIvaNumber(String ivaNumber) {
		return this.companyRepository.findByCompanyIvaNumber(ivaNumber);
	}

	

}