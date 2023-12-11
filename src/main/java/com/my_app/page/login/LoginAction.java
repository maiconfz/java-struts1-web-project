package com.my_app.page.login;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.AppConstants;
import com.my_app.page.login.service.LoginService;
import com.my_app.page.login.service.LoginServiceFactory;
import com.my_app.utils.LoginUtils;

/**
 * LoginAction is a Struts Action class responsible for handling login-related requests.
 * It performs login validation using the LoginService, redirects users based on login status,
 * and manages the navigation between login and home pages.
 */
public class LoginAction extends Action {

	/**
     * Executes the login action based on the provided parameters.
     * It utilizes the LoginService for validation and redirects users accordingly.
     *
     * @param mapping   The ActionMapping used to select this instance.
     * @param actionForm The ActionForm bean associated with this request.
     * @param req       The HttpServletRequest object.
     * @param res       The HttpServletResponse object.
     * @return An ActionForward instance indicating the result of the action execution.
     * @throws Exception if an error occurs during execution.
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		final LoginService loginService = new LoginServiceFactory().create((Connection) req.getAttribute("conn"));

		final LoginForm form = (LoginForm) actionForm;

		req.setAttribute("form", form);
		
		if (LoginUtils.isUserLoggedIn(req.getSession())) {
			return mapping.findForward("actionHomeRedir");
		}  else if ("submit".equals(form.getAction())) {
			return performSubmit(mapping, form, req, res, loginService);
		} else {
			return this.performLogin(mapping, form, req, res);
		}
	}
	
	/**
     * Performs the login action and redirects to the login page.
     *
     * @param mapping   The ActionMapping used to select this instance.
     * @param actionForm The ActionForm bean associated with this request.
     * @param req       The HttpServletRequest object.
     * @param res       The HttpServletResponse object.
     * @return An ActionForward instance indicating the result of the action execution.
     */
	private ActionForward performLogin(ActionMapping mapping, LoginForm actionForm, HttpServletRequest req,
			HttpServletResponse res) {
		return mapping.findForward("loginPage");
	}
	

	/**
     * Performs the submit action, validates the login, and redirects users accordingly.
     *
     * @param mapping      The ActionMapping used to select this instance.
     * @param form         The LoginForm bean associated with this request.
     * @param req          The HttpServletRequest object.
     * @param res          The HttpServletResponse object.
     * @param loginService The LoginService used for login validation.
     * @return An ActionForward instance indicating the result of the action execution.
     */
	private ActionForward performSubmit(ActionMapping mapping, LoginForm form, HttpServletRequest req,
			HttpServletResponse res, LoginService loginService) {

		if (loginService.validate(form)) {
			req.getSession().setAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN, true);
			req.getSession().setAttribute("username", form.getUsername());

			return mapping.findForward("actionHomeRedir");
		} else {
			super.saveErrors(req, form.getActionErrors());
			req.setAttribute("actionErrors", form.getActionErrors());
			req.setAttribute("validated", true);
			return mapping.findForward("loginPage");
		}
	}
}
