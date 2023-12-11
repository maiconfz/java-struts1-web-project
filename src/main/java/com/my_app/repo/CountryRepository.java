package com.my_app.repo;

import com.my_app.model.Country;

/**
 * The CountryRepository interface defines the contract for accessing and managing
 * Country entities in the database. It extends the generic Repository interface
 * and includes specific query methods for Country entities.
 */
public interface CountryRepository extends Repository<Country, Long> {

	/**
     * Finds a Country by its name.
     *
     * @param name The name of the Country.
     * @return The Country with the specified name, or null if not found.
     */
	Country findByName(String name);

}
