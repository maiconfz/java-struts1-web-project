package com.my_app.repo;

import java.util.List;

/**
 * The Repository interface defines the basic contract for CRUD (Create, Read, Update, Delete)
 * operations on entities in the database.
 *
 * @param <T>  The entity type.
 * @param <ID> The type of the entity's primary key (ID).
 */
public interface Repository<T, ID> {

	/**
     * Saves an entity to the database.
     *
     * @param o The entity to be saved.
     * @return The saved entity.
     */
	T save(T o);

	/**
     * Finds an entity by its primary key (ID).
     *
     * @param id The primary key of the entity.
     * @return The entity with the specified ID, or null if not found.
     */
	T findById(ID id);

	/**
     * Retrieves all entities of the specified type from the database.
     *
     * @return A list of all entities.
     */
	List<T> findAll();

	/**
     * Deletes an entity from the database by its primary key (ID).
     *
     * @param id The primary key of the entity to be deleted.
     */
	void deleteById(ID id);

	/**
     * Deletes an entity from the database.
     *
     * @param o The entity to be deleted.
     */
	void delete(T o);
}
