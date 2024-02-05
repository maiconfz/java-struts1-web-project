package com.my_app.repo;

import java.util.List;

import com.my_app.model.City;
import com.my_app.model.Company;
import com.my_app.model.Country;

public interface CompanyRepository extends Repository<Company, Long> {
	
	Company findByName(String name);
	

}
