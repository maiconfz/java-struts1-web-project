package com.my_app.repo;

import com.my_app.model.Country;

public interface CountryRepository extends Repository<Country, Long> {

	Country findByName(String name);

}
