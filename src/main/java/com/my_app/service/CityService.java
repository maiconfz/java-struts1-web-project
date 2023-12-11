package com.my_app.service;

import java.util.List;

import com.my_app.model.City;
import com.my_app.model.Country;

public interface CityService extends BaseService<City, Long> {

	City findByName(String name);

	List<City> findAllByCountryId(Long countryId);

	List<City> findAllByCountry(Country country);

}
