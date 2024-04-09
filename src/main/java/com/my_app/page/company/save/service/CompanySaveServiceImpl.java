package com.my_app.page.company.save.service;

import javax.servlet.http.HttpServletRequest;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;
import com.my_app.service.CityService;
import com.my_app.service.CountryService;
import com.my_app.service.CompanyService;

public class CompanySaveServiceImpl implements CompanySaveService {
	
	
	final CompanyService companyService;
	final CountryService countryService;
	final CityService cityService;

	public CompanySaveServiceImpl(CompanyService companyService, CountryService countryService, CityService cityService) {
		super();
		this.companyService = companyService;
		this.countryService = countryService;
		this.cityService = cityService;
	}

	@Override
	public boolean validate(CompanySaveForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Company saveCompany(CompanySaveForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void formInit(CompanySaveForm form) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequestAttrs(CompanySaveForm form, HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	

}
