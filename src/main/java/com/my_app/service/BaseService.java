package com.my_app.service;

import java.util.List;

public interface BaseService<T, ID> {

	T create(T o);

	T findById(ID id);

	List<T> findAll();

	void deleteById(ID id);

	void delete(T o);
}
