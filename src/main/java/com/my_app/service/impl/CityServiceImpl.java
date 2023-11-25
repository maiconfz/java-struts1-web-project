package com.my_app.service.impl;

import java.util.List;

import com.my_app.model.City;
import com.my_app.model.Country;
import com.my_app.repo.CityRepository;
import com.my_app.service.CityService;

public class CityServiceImpl implements CityService {

	private final CityRepository cityRepository;

	public CityServiceImpl(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public City save(City city) {
		return this.cityRepository.save(city);
	}

	@Override
	public City findById(Long id) {
		return this.cityRepository.findById(id);
	}

	@Override
	public City findByName(String name) {
		return this.cityRepository.findByName(name);
	}

	@Override
	public List<City> findAll() {
		return this.cityRepository.findAll();
	}

	@Override
	public List<City> findAllByCountryId(Long countryId) {
		return this.cityRepository.findAllByCountryId(countryId);
	}

	@Override
	public List<City> findAllByCountry(Country country) {
		return this.findAllByCountryId(country.getId());
	}

	@Override
	public void deleteById(Long id) {
		this.cityRepository.deleteById(id);
	}

	@Override
	public void delete(City city) {
		this.deleteById(city.getId());
	}

}
