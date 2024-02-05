package com.my_app.page.company.save.mapper;

import com.my_app.model.City;
import com.my_app.model.Company;
import com.my_app.model.Country;
import com.my_app.model.User;
import com.my_app.page.company.save.CompanySaveForm;
import com.my_app.page.user.save.UserSaveForm;

public class CompanySaveFormToCompanyMapper {

	public Company toCompany(CompanySaveForm form) {

		final City city = new City(form.getCityId());
		Country country = new Country();
		country.setId(form.getCountryId());

		return new Company(Long.valueOf(0).equals(form.getCompanyId()) ? null : form.getCompanyId(), form.getname(),
				form.getAdress(),form.getIva(), city, form.getCountryId());
	}
}
