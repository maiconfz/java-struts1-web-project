package com.my_app.service;

import javax.servlet.http.HttpServletRequest;

import com.my_app.model.Company;
import com.my_app.page.company.save.CompanySaveForm;

public interface CompanyService extends BaseService<Company, Long> {

	Company findByName(String name);
	
	boolean hasCompanies();
	
	public boolean validate(CompanySaveForm form);

	public Company saveCompany(CompanySaveForm form);

	public void formInit(CompanySaveForm form);

	public void setRequestAttrs(CompanySaveForm form, HttpServletRequest req);
	
}
