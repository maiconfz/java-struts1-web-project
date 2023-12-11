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
import com.my_app.model.Company;
import com.my_app.model.Country;
import com.my_app.model.User;
import com.my_app.repo.CityRepository;
import com.my_app.repo.CountryRepository;
import com.my_app.repo.UserRepository;
import com.my_app.repo.CompanyRepository;
import com.my_app.repo.impl.CityRepositoryImpl;
import com.my_app.repo.impl.CountryRepositoryImpl;
import com.my_app.repo.impl.UserRepositoryImpl;
import com.my_app.repo.impl.CompanyRepositoryImpl;

/**
 * The App class represents the main application singleton responsible for managing the application's context,
 * data source, database initialization, and providing database connections.
 */
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

	/**
     * Retrieves the singleton instance of the App class.
     *
     * @return The App instance.
     */
	public static App get() {
		if (instance == null) {
			synchronized (App.class) {
				instance = new App();
			}
		}

		return instance;
	}

	/**
     * Gets the application context.
     *
     * @return The application context.
     */
	public Context getContext() {
		return context;
	}

	/**
     * Gets the application data source.
     *
     * @return The application data source.
     */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
     * Retrieves a database connection with the specified auto-commit setting.
     *
     * @param autoCommit The auto-commit setting for the connection.
     * @return The database connection.
     * @throws SQLException If a SQL error occurs while creating the connection.
     */
	public Connection getConnection(boolean autoCommit) throws SQLException {
		final Connection conn = this.dataSource.getConnection();
		conn.setAutoCommit(autoCommit);
		return conn;
	}

	/**
     * Retrieves a database connection with auto-commit enabled.
     *
     * @return The database connection.
     * @throws SQLException If a SQL error occurs while creating the connection.
     */
	public Connection getConnection() throws SQLException {
		return this.getConnection(true);
	}

	/**
     * Gets the application random number generator.
     *
     * @return The random number generator.
     */
	public Random getRandom() {
		return random;
	}

	/**
     * Initializes the application's database by creating tables and inserting initial data.
     */
	private void initDb() {

		try (final Connection conn = this.dataSource.getConnection()) {
			initDbCountriesAndCities(conn);
			initDbUsers(conn);
			initDbCompanies(conn);
		} catch (SQLException e) {
			throw new AppGenericException("Error trying to insert initial db data", e);
		}
	}

	/**
     * Initializes the countries and cities tables in the database.
     *
     * @param conn The database connection.
     * @throws SQLException If a SQL error occurs during the initialization.
     */
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

	/**
     * Initializes the users table in the database.
     *
     * @param conn The database connection.
     * @throws SQLException If a SQL error occurs during the initialization.
     */

	
	private void initDbUsers(Connection conn) throws SQLException {
		try (final Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"CREATE TABLE \"USER\" (ID IDENTITY NOT NULL PRIMARY KEY, USERNAME VARCHAR(255) UNIQUE NOT NULL, PASSWORD VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) UNIQUE NOT NULL, CITY_ID BIGINT NOT NULL, FOREIGN KEY (CITY_ID) REFERENCES CITY(ID))");
		}

		final CityRepository cityRepository = new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn));
		final UserRepository userRepository = new UserRepositoryImpl(conn, cityRepository);

		userRepository.save(new User("admin", "admin", "admin@gmail.com", cityRepository.findById((long) this.random.nextInt(49) + 1)));

		for (int i = 1; i < 11; i++) {
			userRepository.save(
					new User("user" + i, "user" + i, "user"+i+"@gmail.com", cityRepository.findById((long) this.random.nextInt(49) + 1)));
		}

		Logger.debug("All users created: {}", userRepository.findAll());
		
	}
	
	private void initDbCompanies(Connection conn) throws SQLException {
		try (final Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(
					"CREATE TABLE \"COMPANY\" (ID IDENTITY NOT NULL PRIMARY KEY, NAME VARCHAR(255) UNIQUE NOT NULL, ADDRESS VARCHAR(255) NOT NULL, IVA VARCHAR(255) UNIQUE NOT NULL, CITY_ID BIGINT NOT NULL, FOREIGN KEY (CITY_ID) REFERENCES CITY(ID))");
		}

		final CityRepository cityRepository = new CityRepositoryImpl(conn, new CountryRepositoryImpl(conn));
		final CompanyRepository companyRepository = new CompanyRepositoryImpl(conn, cityRepository);

		for (int i = 1; i < 11; i++) {
			companyRepository.save(
					new Company("Company" + i, "Adress" + i, "company"+i+"@gmail.com", cityRepository.findById((long) this.random.nextInt(49) + 1)));
			
		}

		Logger.debug("All companies created: {}", companyRepository.findAll());
		
	}
}
