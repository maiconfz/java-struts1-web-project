package com.my_app.page.company.save.mapper;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

public class CompanyToCompanySaveFormMapper {

	public CompanySaveForm toUserSaveForm(Company company) {
		return this.mapTo(company, new CompanySaveForm());
	}

	public CompanySaveForm mapTo(Company company, CompanySaveForm form) {

		form.setCompanyId(company.getId());
		form.setName(company.getName());
		form.setAddress(company.getAddress());
		form.setVatNumber(company.getVatNumber());
		form.setCountryId(company.getCity().getCountry().getId());
		form.setCityId(company.getCity().getId());

		return form;
	}

}
