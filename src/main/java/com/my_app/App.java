package com.my_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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
	private final Random random;

	public App() {
		try {
			this.context = new InitialContext();
		} catch (NamingException e) {
			throw new AppGenericException("Error initializing App Context");
		}

		this.dataSource = new DataSourceFactory().create();
		this.random = new Random();
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

	public Connection getConnection(boolean autoCommit) throws SQLException {
		final Connection conn = this.dataSource.getConnection();
		conn.setAutoCommit(autoCommit);
		return conn;
	}

	public Connection getConnection() throws SQLException {
		return this.getConnection(true);
	}

	public Random getRandom() {
		return random;
	}

	private void initDb() {

		try (final Connection conn = this.dataSource.getConnection()) {
			initDbCountriesAndCities(conn);
			initDbUsers(conn);
		} catch (SQLException e) {
			throw new AppGenericException("Error trying to insert initial db data", e);
		}
	}

	private void initDbCountriesAndCities(Connection conn) throws SQLException {
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
			final Country country = countryRepository.save(new Country(String.format("Country %02d", i)));

			for (int j = 1; j < 6; j++) {
				cityRepository.save(new City(String.format("City %02d.%02d", country.getId(), j), country));
			}
		}

		Logger.debug("All countries created: {}", countryRepository.findAll());
		Logger.debug("All cities created: {}", cityRepository.findAll());
	}

	private void initDbUsers(Connection conn) throws SQLException {
		try (final Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"CREATE TABLE \"USER\" (ID IDENTITY NOT NULL PRIMARY KEY, USERNAME VARCHAR(255) UNIQUE NOT NULL, PASSWORD VARCHAR(255) NOT NULL, CITY_ID BIGINT NOT NULL, EMAIL VARCHAR(255) NULL, FOREIGN KEY (CITY_ID) REFERENCES CITY(ID))");
		}

		final CityRepository cityRepository = new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn));
		final UserRepository userRepository = new UserRepositoryImpl(conn, cityRepository);

		userRepository.save(new User("admin", "admin", cityRepository.findById((long) this.random.nextInt(49) + 1)));

		for (int i = 1; i < 11; i++) {
			userRepository.save(
					new User("user" + i, "user" + i, cityRepository.findById((long) this.random.nextInt(49) + 1)));
		}

		Logger.debug("All users created: {}", userRepository.findAll());
	}

}
