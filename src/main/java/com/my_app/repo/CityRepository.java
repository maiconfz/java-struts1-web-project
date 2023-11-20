package com.my_app.repo;

import java.util.List;

import com.my_app.model.City;
import com.my_app.model.Country;

public interface CityRepository extends Repository<City, Long> {

	City findByName(String name);

	List<City> findByCountry(Country country);
}
