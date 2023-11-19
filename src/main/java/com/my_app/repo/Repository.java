package com.my_app.repo;

import java.util.List;

public interface Repository<T, ID> {
	T findById(ID id);
	
	List<T> findAll();
}
