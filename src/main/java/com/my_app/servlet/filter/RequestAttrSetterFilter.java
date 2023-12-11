package com.my_app.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * The RequestAttrSetterFilter class is a servlet filter that sets request
 * attributes before passing the request along the filter chain. It sets the
 * "contextPath" attribute to the context path of the servlet context.
 */
public class RequestAttrSetterFilter implements Filter {

	/**
     * Destroys the filter. This method is called by the web container to
     * indicate to the filter that it is being taken out of service.
     */
	@Override
	public void destroy() {
		// Doesn't have to do anything
	}

	/**
     * Filters requests. It sets the "contextPath" attribute to the context path of
     * the servlet context before passing the request along the filter chain.
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

		req.setAttribute("contextPath", req.getServletContext().getContextPath());

		chain.doFilter(req, res);
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
