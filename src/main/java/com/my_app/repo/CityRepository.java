package com.my_app.repo;

import java.util.List;

import com.my_app.model.City;
import com.my_app.model.Country;

/**
 * The CityRepository interface defines the contract for accessing and managing
 * City entities in the database. It extends the generic Repository interface
 * and includes specific query methods for City entities.
 */
public interface CityRepository extends Repository<City, Long> {

	/**
     * Finds a City by its name.
     *
     * @param name The name of the City.
     * @return The City with the specified name, or null if not found.
     */
	City findByName(String name);
	
	/**
     * Finds all cities by the ID of the associated Country.
     *
     * @param countryId The ID of the associated Country.
     * @return A list of City entities associated with the given Country ID.
     */
	List<City> findAllByCountryId(Long countryId);
	
	/**
     * Finds all cities associated with a specific Country.
     *
     * @param country The Country entity.
     * @return A list of City entities associated with the given Country.
     */
	List<City> findAllByCountry(Country country);
}
