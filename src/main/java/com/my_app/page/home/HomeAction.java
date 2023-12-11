package com.my_app.page.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.utils.LoginUtils;

public class HomeAction extends Action {

	/**
	 * Executes the home action, redirecting to the home page if the user is logged in,
	 * otherwise redirects to the login page.
	 * 
	 * @param mapping     The ActionMapping used to select this instance.
	 * @param actionForm  The optional ActionForm bean for this request (not used in this method).
	 * @param req         The HttpServletRequest object.
	 * @param res         The HttpServletResponse object.
	 * @return            The ActionForward for the next view based on the user's login status.
	 * @throws Exception  If an error occurs during execution.
	 */
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (LoginUtils.isUserLoggedIn(req.getSession())) {
			return mapping.findForward("homePage");
		} else {
			return mapping.findForward("actionLoginRedir");
		}
	}

}
