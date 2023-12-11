package com.my_app.page.company.save.mapper;

import com.my_app.model.City;
import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

/**
* UserSaveFormToUserMapper is a mapper class responsible for converting a UserSaveForm instance
* to a User instance. It facilitates the transformation of form data into a User object for storage
* or further processing.
*/
public class CompanySaveFormToCompanyMapper {

	/**
     * Converts a UserSaveForm instance to a User instance.
     *
     * @param form The UserSaveForm instance containing user input data.
     * @return A User instance created from the provided form data.
     */
	public Company toCompany(CompanySaveForm form) {

		final City city = new City(form.getCityId());

		return new Company(Long.valueOf(0).equals(form.getCompanyId()) ? null : form.getCompanyId(), form.getName(),
				form.getAddress(), form.getIvaNumber(), city);
	}
}