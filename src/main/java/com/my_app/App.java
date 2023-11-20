package com.my_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.tinylog.Logger;

import com.my_app.db.DataSourceFactory;
import com.my_app.exception.AppGenericException;
import com.my_app.model.City;
import com.my_app.model.Country;
import com.my_app.model.User;
import com.my_app.repo.CityRepository;
import com.my_app.repo.CountryRepository;
import com.my_app.repo.UserRepository;
import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.repo.impl.UserRepositoryImpl;

public class App {

	private static App instance;

	private final Context context;
	private final DataSource dataSource;

	public App() {
		try {
			this.context = new InitialContext();
		} catch (NamingException e) {
			throw new AppGenericException("Error initializing App Context");
		}

		this.dataSource = new DataSourceFactory().create();
		this.initDb();
	}

	public static App get() {
		if (instance == null) {
			synchronized (App.class) {
				instance = new App();
			}
		}

		return instance;
	}

	public Context getContext() {
		return context;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	private void initDb() {
		Connection conn;

		try {
			conn = this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new AppGenericException("Couldn't get db connection", e);
		}

		try {

			try (final Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(
						"CREATE TABLE \"USER\" (ID IDENTITY NOT NULL PRIMARY KEY, USERNAME VARCHAR(255) UNIQUE NOT NULL, PASSWORD VARCHAR(255) NOT NULL)");
			}

			final UserRepository userRepository = new UserRepositoryImpl(conn);

			userRepository.create(new User("admin", "admin"));
			userRepository.create(new User("user", "user"));

			Logger.debug("All users created: {}", userRepository.findAll());

			try (final Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(
						"CREATE TABLE COUNTRY (ID IDENTITY NOT NULL PRIMARY KEY, NAME VARCHAR(255) UNIQUE NOT NULL)");
			}

			try (final Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(
						"CREATE TABLE CITY (ID IDENTITY NOT NULL PRIMARY KEY, NAME VARCHAR(255) UNIQUE NOT NULL, COUNTRY_ID BIGINT NOT NULL, FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY(ID))");
			}

			final CountryRepository countryRepository = new CountryRepositoryImpl(conn);
			final CityRepository cityRepository = new CityRepositoryImpl(conn, countryRepository);

			for (int i = 1; i < 11; i++) {
				final Country country = countryRepository.create(new Country(String.format("Country %s", i)));

				for (int j = 1; j < 6; j++) {
					cityRepository.create(new City(String.format("City %s.%s", country.getId(), j), country));
				}
			}

			Logger.debug("All countries created: {}", countryRepository.findAll());
			Logger.debug("All cities created: {}", cityRepository.findAll());

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new AppGenericException("Couldn't rollback db connection", e);
			}

			throw new AppGenericException("Couldn't insert initial db data", e);
		} finally {
			try {
				if (!conn.isClosed()) {
					conn.commit();
					conn.close();
				}
			} catch (SQLException e) {
				throw new AppGenericException("Couldn't close db connection", e);
			}
		}
	}

}
