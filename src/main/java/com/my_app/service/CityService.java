package com.my_app.service;

import java.util.List;

import com.my_app.model.City;
import com.my_app.model.Country;

/**
 * The CityService interface extends the BaseService interface
 * and is specific to city-related operations.
 */
public interface CityService extends BaseService<City, Long> {

	/**
	 * Finds a city by its name.
	 *
	 * @param name The name of the city.
	 * @return The City object if found, otherwise null.
	 */
	City findByName(String name);

	/**
	 * Finds all cities by the ID of the country they belong to.
	 *
	 * @param countryId The ID of the country.
	 * @return A list of City objects that belong to the specified country.
	 */
	List<City> findAllByCountryId(Long countryId);

	/**
	 * Finds all cities by the specified country.
	 *
	 * @param country The Country object.
	 * @return A list of City objects that belong to the specified country.
	 */
	List<City> findAllByCountry(Country country);

}
