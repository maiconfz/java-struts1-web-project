package com.my_app.page.company.save.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;
import com.my_app.page.company.save.mapper.CompanySaveFormToCompanyMapper;
import com.my_app.page.company.save.mapper.CompanyToCompanySaveFormMapper;
import com.my_app.service.CityService;
import com.my_app.service.CountryService;
import com.my_app.service.CompanyService;
import com.my_app.utils.CompanyUtils;

/**
 * The UserSaveServiceImpl class implements the UserSaveService interface
 * to provide user save-related functionality, including form initialization,
 * validation, user saving, and setting request attributes.
 */
public class CompanySaveServiceImpl implements CompanySaveService {

	/*Field Instances for managing user-related, country-related, city-related operations.*/
	final CompanyService companyService;
	final CountryService countryService;
	final CityService cityService;

	/**
     * Constructs a UserSaveServiceImpl with the specified UserService, CountryService,
     * and CityService instances.
     *
     * @param userService    The UserService instance.
     * @param countryService The CountryService instance.
     * @param cityService    The CityService instance.
     */
	public CompanySaveServiceImpl(CompanyService companyService, CountryService countryService, CityService cityService) {
		super();
		this.companyService = companyService;
		this.countryService = countryService;
		this.cityService = cityService;
	}

	/**
     * Initializes the user save form based on the existing user details if it's not a new user.
     *
     * @param form The UserSaveForm to be initialized.
     */
	@Override
	public void formInit(CompanySaveForm form) {
		if (!form.isNewCompany()) {
			final Company company = this.companyService.findById(form.getCompanyId());

			new CompanyToCompanySaveFormMapper().mapTo(company, form);
			form.setOriginalUsername(form.getName());
		}
	}

	/**
     * Validates the user save form, checking for required fields and uniqueness constraints.
     *
     * @param form The UserSaveForm to be validated.
     * @return True if the form is valid; otherwise, false.
     */
	@Override
	public boolean validate(CompanySaveForm form) {
		boolean isValid = true;

		if (StringUtils.isBlank(form.getName())) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("error.common.required"));
		} else if ((form.isNewCompany() || (!form.isNewCompany())
				&& !form.getOriginalUsername().equals(CompanyUtils.normalizeConpanyName(form.getName())))
				&& companyService.findByCompanyName(form.getName()) != null) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("user.username-taken.error"));
		}

		if (StringUtils.isBlank(form.getAddress())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionMessage("error.common.required"));
		}
		
		if (StringUtils.isBlank(form.getIvaNumber())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionMessage("error.common.required"));
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

		return isValid;
	}

	 /**
     * Saves the user based on the provided user save form.
     *
     * @param form The UserSaveForm containing user details.
     * @return The saved User entity.
     */
	@Override
	public Company saveCompany(CompanySaveForm form) {
		return this.companyService.save(new CompanySaveFormToCompanyMapper().toCompany(form));
	}

	/**
     * Sets request attributes needed for rendering the user save form.
     *
     * @param form The UserSaveForm.
     * @param req  The HttpServletRequest.
     */
	@Override
	public void setRequestAttrs(CompanySaveForm form, HttpServletRequest req) {
		req.setAttribute("countries", this.countryService.findAll());

		if (form.getCountryId() != null && form.getCountryId() > 0) {
			req.setAttribute("cities", this.cityService.findAllByCountryId(form.getCountryId()));
		}
	}

}