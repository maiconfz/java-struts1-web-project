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

public class DatabaseConnectionInjectorFilter implements Filter {

	@Override
	public void destroy() {
		// Doesn't have to do anything
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// Not the most efficient way to manage connections, but I don't want to make
		// server to manage it for now

		Connection conn;

		try {
			conn = App.get().getDataSource().getConnection();
		} catch (SQLException e) {
			throw new AppGenericException("Couldn't get db connection", e);
		}

		req.setAttribute("conn", conn);

		try {
			chain.doFilter(req, res);
		} catch (IOException | ServletException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new AppGenericException("Couldn't rollback db connection", e);
			}

			throw e;
		} finally {
			req.removeAttribute("conn");
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new AppGenericException("Couldn't close db connection", e);
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// Doesn't have to do anything
	}

}
