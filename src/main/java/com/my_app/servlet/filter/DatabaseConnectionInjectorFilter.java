package com.my_app.servlet.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.my_app.App;
import com.my_app.exception.AppGenericException;

/**
 * The DatabaseConnectionInjectorFilter class is a servlet filter that manages
 * database connections. It injects a database connection into the request
 * attribute "conn" for use by servlets during their processing. It also
 * performs commit and rollback operations based on the success or failure of
 * the servlet processing.
 */
public class DatabaseConnectionInjectorFilter implements Filter {

	 /**
     * Destroys the filter. This method is called by the web container to
     * indicate to the filter that it is being taken out of service.
     */
	@Override
	public void destroy() {
		// Doesn't have to do anything
	}

	/**
     * Filters requests. It obtains a database connection from the application,
     * injects it into the request, and performs commit or rollback operations
     * based on the success or failure of the servlet processing.
     *
     * @param req   The request to be processed.
     * @param res   The response to be created.
     * @param chain The chain of filters to invoke.
     * @throws IOException      if an I/O error occurs during the processing of
     *                          the request.
     * @throws ServletException if the processing fails for any other reason.
     */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// Not the most efficient way to manage connections, but I don't want to make
		// server to manage it for now

		try (final Connection conn = App.get().getConnection(false)) {
			req.setAttribute("conn", conn);

			try {
				chain.doFilter(req, res);
				conn.commit();
			} catch (IOException | ServletException e) {
				conn.rollback();
			}

			req.removeAttribute("conn");
		} catch (SQLException e) {
			throw new AppGenericException("SQL error while trying to do the operation", e);
		} catch (Exception e) {
			throw new AppGenericException("Error while trying to do the operation", e);
		}
	}

	/**
     * Initializes the filter. This method is called by the web container to
     * indicate to the filter that it is being placed into service.
     *
     * @param arg0 The filter configuration object used by a servlet container to
     *             pass information to a filter during initialization.
     * @throws ServletException if an exception occurs that interrupts the filter's
     *                          normal operation.
     */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// Doesn't have to do anything
	}

}
