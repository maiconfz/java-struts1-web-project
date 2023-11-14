package com.my_app.db;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

public class DataSourceFactory {

	public DataSource create() {
		final JdbcDataSource ds = new JdbcDataSource();

		ds.setURL("jdbc:h2:mem:my_app");
		ds.setUser("sa");
		ds.setPassword("sa");

		return ds;
	}

}
