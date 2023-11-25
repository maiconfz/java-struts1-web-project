package com.my_app.repo;

import java.util.List;

public interface Repository<T, ID> {

	T create(T o);

	T findById(ID id);

	List<T> findAll();

	void deleteById(ID id);

	void delete(T o);
}
