package com.my_app.page.user.save.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;
import com.my_app.page.user.save.mapper.UserSaveFormToUserMapper;
import com.my_app.page.user.save.mapper.UserToUserSaveFormMapper;
import com.my_app.service.CityService;
import com.my_app.service.CountryService;
import com.my_app.service.UserService;
import com.my_app.utils.UserUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The UserSaveServiceImpl class implements the UserSaveService interface
 * to provide user save-related functionality, including form initialization,
 * validation, user saving, and setting request attributes.
 */
public class UserSaveServiceImpl implements UserSaveService {

	/*Field Instances for managing user-related, country-related, city-related operations.*/
	final UserService userService;
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
	public UserSaveServiceImpl(UserService userService, CountryService countryService, CityService cityService) {
		super();
		this.userService = userService;
		this.countryService = countryService;
		this.cityService = cityService;
	}

	/**
     * Initializes the user save form based on the existing user details if it's not a new user.
     *
     * @param form The UserSaveForm to be initialized.
     */
	@Override
	public void formInit(UserSaveForm form) {
		if (!form.isNewUser()) {
			final User user = this.userService.findById(form.getUserId());

			new UserToUserSaveFormMapper().mapTo(user, form);
			form.setOriginalUsername(form.getUsername());
		}
	}

	/**
     * Validates the user save form, checking for required fields and uniqueness constraints.
     *
     * @param form The UserSaveForm to be validated.
     * @return True if the form is valid; otherwise, false.
     */
	@Override
	public boolean validate(UserSaveForm form) {
		boolean isValid = true;

		if (StringUtils.isBlank(form.getUsername())) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("error.common.required"));
		} else if ((form.isNewUser() || (!form.isNewUser()
				&& !form.getOriginalUsername().equals(UserUtils.normalizeUsername(form.getUsername()))))
				&& userService.findByUsername(form.getUsername()) != null) {
			isValid = false;
			form.getActionErrors().add("username", new ActionMessage("user.username-taken.error"));
		}

		if (StringUtils.isBlank(form.getPassword())) {
			isValid = false;
			form.getActionErrors().add("password", new ActionMessage("error.common.required"));
		}
		
		if (StringUtils.isBlank(form.getEmail())) {
            isValid = false;
            form.getActionErrors().add("email", new ActionMessage("error.common.required"));
        } else {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(form.getEmail());

            if (!matcher.matches()) {
                isValid = false;
                form.getActionErrors().add("email", new ActionMessage("error.email.invalid"));
            }
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
	public User saveUser(UserSaveForm form) {
		return this.userService.save(new UserSaveFormToUserMapper().toUser(form));
	}

	/**
     * Sets request attributes needed for rendering the user save form.
     *
     * @param form The UserSaveForm.
     * @param req  The HttpServletRequest.
     */
	@Override
	public void setRequestAttrs(UserSaveForm form, HttpServletRequest req) {
		req.setAttribute("countries", this.countryService.findAll());

		if (form.getCountryId() != null && form.getCountryId() > 0) {
			req.setAttribute("cities", this.cityService.findAllByCountryId(form.getCountryId()));
		}
	}

}
