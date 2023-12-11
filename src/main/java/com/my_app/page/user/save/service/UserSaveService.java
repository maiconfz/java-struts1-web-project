package com.my_app.page.user.save.service;

import javax.servlet.http.HttpServletRequest;

import com.my_app.model.User;
import com.my_app.page.user.save.UserSaveForm;

public interface UserSaveService {
	
	public boolean validate(UserSaveForm form);

	public User saveUser(UserSaveForm form);

	public void formInit(UserSaveForm form);

	public void setRequestAttrs(UserSaveForm form, HttpServletRequest req);
}
