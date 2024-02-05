package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.Company;
import com.my_app.repo.CompanyRepository;
import com.my_app.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository userRepository) {
		this.companyRepository = userRepository;
	}

	@Override
	public Company save(Company o) {
		return this.companyRepository.save(o);
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
	public void delete(Company o) {

		this.companyRepository.delete(o);
		//this.companyRepository.deleteById(o.getId());
	}

	@Override
	public Company findByName(String name) {
		return this.companyRepository.findByName(name);
	}


}
