package com.my_app.page.company.save.service;

import javax.servlet.http.HttpServletRequest;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

public interface CompanySaveService {
	public boolean validate(CompanySaveForm form);

	public Company saveCompany(CompanySaveForm form);

	public void formInit(CompanySaveForm form);

	public void setRequestAttrs(CompanySaveForm form, HttpServletRequest req);
}
