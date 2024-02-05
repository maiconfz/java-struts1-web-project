package com.my_app.page.company.save.mapper;

import com.my_app.model.City;
import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

public class CompanySaveFormToCompanyMapper {

	public Company toCompany(CompanySaveForm form) {

		final City city = new City(form.getCityId());

		return new Company(Long.valueOf(0).equals(form.getCompanyId()) ? null : form.getCompanyId(), form.getName(),
				form.getAddress(), form.getVat(), city);
	}
}
