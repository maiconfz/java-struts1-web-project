package com.my_app.repo;

import com.my_app.model.Company;

public interface CompanyRepository extends Repository<Company, Long> {

	Company findByCompanyName(String name);
	
	Company findByCompanyIvaNumber(String ivaNumber);

}