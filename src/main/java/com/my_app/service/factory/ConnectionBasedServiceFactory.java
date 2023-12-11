package com.my_app.service.factory;

import java.sql.Connection;

/**
 * The ConnectionBasedServiceFactory interface provides a contract for creating instances
 * of a service (T) based on a provided database connection.
 *
 * @param <T> The type of service to be created.
 */
public interface ConnectionBasedServiceFactory<T> {
	
	/**
     * Creates an instance of the specified service type with the given database connection.
     *
     * @param conn The database connection.
     * @return An instance of the specified service type.
     */
	T create(final Connection conn);
}
