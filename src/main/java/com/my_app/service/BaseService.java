package com.my_app.service;

import java.util.List;

/**
 * The BaseService interface defines common operations for CRUD (Create, Read, Update, Delete)
 * functionality for entities. Specific service interfaces for different entities can extend this
 * interface to inherit these common operations.
 *
 * @param <T>  The entity type.
 * @param <ID> The type of the entity's ID.
 */
public interface BaseService<T, ID> {

	/**
	 * Saves the given entity.
	 *
	 * @param o The entity to be saved.
	 * @return The saved entity.
	 */
	T save(T o);

	/**
	 * Finds an entity by its ID.
	 *
	 * @param id The ID of the entity.
	 * @return The found entity if it exists, otherwise null.
	 */
	T findById(ID id);

	/**
	 * Finds all entities of the given type.
	 *
	 * @return A list of all entities.
	 */
	List<T> findAll();

	/**
	 * Deletes an entity by its ID.
	 *
	 * @param id The ID of the entity to be deleted.
	 */
	void deleteById(ID id);

	/**
	 * Deletes the given entity.
	 *
	 * @param o The entity to be deleted.
	 */
	void delete(T o);
}
