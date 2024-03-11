package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.Company;
import com.my_app.repo.CompanyRepository;
import com.my_app.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companiesRepository;

	public CompanyServiceImpl(CompanyRepository companiesRepository) {
		this.companiesRepository = companiesRepository;
	}

	@Override
	public Company save(Company companies) {
		return companiesRepository.save(companies);
	}

	@Override
	public Company findById(Long id) {
		return companiesRepository.findById(id);
	}

	@Override
	public List<Company> findAll() {
		return companiesRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		companiesRepository.deleteById(id);
	}

	@Override
	public void delete(Company companies) {
		companiesRepository.delete(companies);
	}

	@Override
	public Company findByName(String name) {
		return companiesRepository.findByName(name);
	}

}
