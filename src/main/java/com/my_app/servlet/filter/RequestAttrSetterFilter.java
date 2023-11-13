package com.my_app.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestAttrSetterFilter implements Filter {

	@Override
	public void destroy() {
		// Doesn't have to do anything
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		req.setAttribute("contextPath", req.getServletContext().getContextPath());

		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// Doesn't have to do anything
	}

}
