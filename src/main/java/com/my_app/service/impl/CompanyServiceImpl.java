package com.my_app.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;
import com.my_app.page.company.save.mapper.CompanySaveFormToCompanyMapper;
import com.my_app.page.company.save.mapper.CompanyToCompanySaveFormMapper;
import com.my_app.repo.CompanyRepository;
import com.my_app.service.CityService;
import com.my_app.service.CompanyService;
import com.my_app.service.CountryService;

public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;
	private CountryService countryService;
	private CityService cityService;
	
	public CompanyServiceImpl(CompanyRepository companyRepository, CountryService countryService, CityService cityService) {
		this.companyRepository = companyRepository;
		this.countryService = countryService;
		this.cityService = cityService;
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

	@Override
	public void deleteById(Long id) {
		this.companyRepository.deleteById(id);
	}
	
	@Override
	public void delete(Company company) {
		this.deleteById(company.getId());
	}

	@Override
	public boolean hasCompanies() {
		return this.companyRepository.hasCompanies();
	}
	
	@Override
	public void formInit(CompanySaveForm form) {
		if (!form.isNewCompany()) {
			final Company company = this.findById(form.getCompanyId());

			new CompanyToCompanySaveFormMapper().mapTo(company, form);
			form.setOriginalName(form.getName());
		}
	}

	@Override
	public boolean validate(CompanySaveForm form) {
		boolean isValid = true;

		if (StringUtils.isBlank(form.getName())) {
			isValid = false;
			form.getActionErrors().add("name", new ActionMessage("error.common.required"));
		}

		if (StringUtils.isBlank(form.getAddress())) {
			isValid = false;
			form.getActionErrors().add("address", new ActionMessage("error.common.required"));
		}

		if (form.getCountryId() == null || form.getCountryId() == 0) {
			isValid = false;
			form.getActionErrors().add("country", new ActionMessage("error.common.required"));
		}

		if (form.getCityId() == null || form.getCityId() == 0) {
			isValid = false;

			if (form.getCountryId() == null || form.getCountryId() == 0) {
				form.getActionErrors().add("city", new ActionMessage("form.field.pre-choose", "Country"));
			} else {
				form.getActionErrors().add("city", new ActionMessage("error.common.required"));
			}
		}
		
		if (StringUtils.isBlank(form.getVat())) {
			isValid = false;
			form.getActionErrors().add("vat", new ActionMessage("error.common.required"));
		}

		return isValid;
	}

	@Override
	public Company saveCompany(CompanySaveForm form) {
		return this.save(new CompanySaveFormToCompanyMapper().toCompany(form));
	}

	@Override
	public void setRequestAttrs(CompanySaveForm form, HttpServletRequest req) {
		req.setAttribute("countries", this.countryService.findAll());

		if (form.getCountryId() != null && form.getCountryId() > 0) {
			req.setAttribute("cities", this.cityService.findAllByCountryId(form.getCountryId()));
		}
	}

}
