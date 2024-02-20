package com.my_app.service;

import com.my_app.model.Company;

public interface CompanyService extends BaseService<Company, Long> {

	Company findByName(String name);

}
