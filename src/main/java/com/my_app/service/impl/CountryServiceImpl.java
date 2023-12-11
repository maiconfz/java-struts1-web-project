package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.Country;
import com.my_app.repo.CountryRepository;
import com.my_app.service.CountryService;

/**
 * The CountryServiceImpl class implements the CountryService interface and provides
 * the implementation for CRUD operations related to the Country entity.
 */
public class CountryServiceImpl implements CountryService {

	private final CountryRepository countryRepository;

	/**
     * Constructs a CountryServiceImpl with the specified CountryRepository.
     *
     * @param countryRepository The CountryRepository to be used for database operations.
     */
	public CountryServiceImpl(CountryRepository userRepository) {
		this.countryRepository = userRepository;
	}

	@Override
	public Country save(Country country) {
		return this.countryRepository.save(country);
	}

	@Override
	public Country findById(Long id) {
		return this.countryRepository.findById(id);
	}

	@Override
	public List<Country> findAll() {
		return this.countryRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.countryRepository.deleteById(id);
	}

	@Override
	public void delete(Country country) {
		this.deleteById(country.getId());
	}

}
