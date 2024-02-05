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

public class UserSaveServiceImpl implements UserSaveService {

	final UserService userService;
	final CountryService countryService;
	final CityService cityService;

	public UserSaveServiceImpl(UserService userService, CountryService countryService, CityService cityService) {
		super();
		this.userService = userService;
		this.countryService = countryService;
		this.cityService = cityService;
	}

	@Override
	public void formInit(UserSaveForm form) {
		if (!form.isNewUser()) {
			final User user = this.userService.findById(form.getUserId());

			new UserToUserSaveFormMapper().mapTo(user, form);
			form.setOriginalUsername(form.getUsername());
		}
	}

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
		
		if (StringUtils.isBlank(form.getEmail())) {
			isValid = false;
			form.getActionErrors().add("email", new ActionMessage("error.common.required"));
		} else if( !UserUtils.emailIsValid( form.getEmail() ) ) {
			isValid = false;
			form.getActionErrors().add("email", new ActionMessage("error.email.wrong"));
		}

		return isValid;
	}

	@Override
	public User saveUser(UserSaveForm form) {
		return this.userService.save(new UserSaveFormToUserMapper().toUser(form));
	}

	@Override
	public void setRequestAttrs(UserSaveForm form, HttpServletRequest req) {
		req.setAttribute("countries", this.countryService.findAll());

		if (form.getCountryId() != null && form.getCountryId() > 0) {
			req.setAttribute("cities", this.cityService.findAllByCountryId(form.getCountryId()));
		}
	}

}
