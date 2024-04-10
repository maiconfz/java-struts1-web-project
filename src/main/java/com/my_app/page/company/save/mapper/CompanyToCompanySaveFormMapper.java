package com.my_app.page.company.save.mapper;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

public class CompanyToCompanySaveFormMapper {
	
	public CompanySaveForm mapTo(Company company, CompanySaveForm form) {
		
		form.setCompanyId(company.getId());
		form.setName(company.getName());
		form.setAddress(company.getAddress());		
		form.setCityId(company.getCity().getId());
		form.setVat(company.getVat());
		form.setCountryId(company.getCity().getCountry().getId());
		
		return form;
	}

}
