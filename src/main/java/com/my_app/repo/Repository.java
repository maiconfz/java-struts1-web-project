package com.my_app.repo;

public interface Repository<T, ID> {
	T findById(ID id);
}
