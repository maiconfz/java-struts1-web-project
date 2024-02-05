package com.my_app.page.company.save.mapper;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

public class CompanyToCompanySaveFormMapper {

	public CompanySaveForm toCompanySaveForm(Company company) {
		return this.mapTo(company, new CompanySaveForm());
	}

	public CompanySaveForm mapTo(Company company, CompanySaveForm form) {

		form.setCompanyId(company.getId());
		form.setname(company.getName());
		form.setAdress(company.getAdress());
		form.setCountryId(company.getCity().getCountry().getId());
		form.setCityId(company.getCity().getId());
		form.setIva(company.getIva());

		return form;
	}

}
