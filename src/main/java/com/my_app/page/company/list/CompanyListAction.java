package com.my_app.page.company.list;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.service.CompanyService;
import com.my_app.service.factory.CompanyServiceFactory;
import com.my_app.utils.LoginUtils;

/**
 * UserListAction is a Struts action class responsible for handling requests to retrieve and display
 * a list of users. It ensures user authentication and populates the request attribute with the list of users.
 */
public class CompanyListAction extends Action {

	/**
     * Executes the user list action, retrieving and displaying a list of users.
     *
     * @param mapping   The ActionMapping used to select this instance.
     * @param actionForm The optional ActionForm bean for this request.
     * @param req       The HTTP request we are processing.
     * @param res       The HTTP response we are creating.
     * @return The forward name associated with the user list display.
     * @throws Exception if an error occurs during processing.
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}

		final CompanyService companyService = new CompanyServiceFactory().create((Connection) req.getAttribute("conn"));

		req.setAttribute("companies", companyService.findAll());

		return mapping.getInputForward();
	}

}