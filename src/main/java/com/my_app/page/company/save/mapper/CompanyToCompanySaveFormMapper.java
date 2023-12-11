package com.my_app.page.company.save.mapper;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

/**
 * UserToUserSaveFormMapper is a mapper class responsible for converting a User instance
 * to a UserSaveForm instance. It provides methods for mapping user data to a form for editing
 * or displaying.
 */
public class CompanyToCompanySaveFormMapper {

	/**
     * Converts a User instance to a UserSaveForm instance.
     *
     * @param user The User instance to be converted.
     * @return A UserSaveForm instance populated with data from the provided User.
     */
	public CompanySaveForm toCompanySaveForm(Company company) {
		return this.mapTo(company, new CompanySaveForm());
	}

	/**
     * Maps data from a User instance to a UserSaveForm instance.
     *
     * @param user The User instance as the data source.
     * @param form The UserSaveForm instance to be populated.
     * @return The UserSaveForm instance populated with data from the provided User.
     */
	public CompanySaveForm mapTo(Company company, CompanySaveForm form) {

		form.setCompanyId(company.getId());
		form.setName(company.getName());
		form.setAddress(company.getAddress());
		form.setIvaNumber(company.getIvaNumber());
		form.setCountryId(company.getCity().getCountry().getId());
		form.setCityId(company.getCity().getId());

		return form;
	}

}