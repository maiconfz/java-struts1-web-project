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
	public Company findByName(String name) {
		return this.companyRepository.findByName(name);
	}

	@Override
	public List<Company> findAll() {
		return this.companyRepository.findAll();
	}

	/*@Override
	public boolean userMatchPassword(String username, String password) {
		final Company user = this.findByUsername(username);
		return user.getPassword().equals(password);
	} */

	@Override
	public void deleteById(Long id) {
		this.companyRepository.deleteById(id);
	}

	@Override
	public void delete(Company company) {
		this.deleteById(company.getId());
	}

}
