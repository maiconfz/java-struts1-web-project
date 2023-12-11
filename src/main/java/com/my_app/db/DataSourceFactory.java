package com.my_app.db;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

/**
 * This class is a custom exception class that extends RuntimeExceptionn
 **/
public class DataSourceFactory {
	
	/**
	 * Creates and returns a DataSource for an H2 in-memory database with specific settings.
	 * The database URL is set to "jdbc:h2:mem:my_app;DB_CLOSE_DELAY=-1".
	 * The default username and password are set to "sa".
	 *
	 * @return A DataSource configured for an H2 in-memory database.
	 */
	
	public DataSource create() {
		final JdbcDataSource ds = new JdbcDataSource();

		ds.setURL("jdbc:h2:mem:my_app;DB_CLOSE_DELAY=-1");
		ds.setUser("sa");
		ds.setPassword("sa");

		return ds;
	}

}
