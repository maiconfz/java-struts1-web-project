package com.my_app.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {
	private final LoginService loginService;

	public LoginAction() {
		this.loginService = new LoginServiceImpl();
	}

	@Override
	public ActionForward perform(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException {

		final LoginForm form = (LoginForm) actionForm;

		if ("submit".equals(form.getAction())) {
			return performSubmit(mapping, form, req, res);
		} else {
			return this.performLogin(mapping, form, req, res);
		}
	}

	private ActionForward performLogin(ActionMapping mapping, LoginForm actionForm, HttpServletRequest req,
			HttpServletResponse res) {
		return mapping.findForward("loginPage");
	}

	private ActionForward performSubmit(ActionMapping mapping, LoginForm form, HttpServletRequest req,
			HttpServletResponse res) {

		if (this.loginService.validate(form)) {
			req.getSession().setAttribute("isLogged", Boolean.TRUE);
			req.getSession().setAttribute("username", form.getUsername());

			return mapping.findForward("actionHomeRedir");
		} else {
			super.saveErrors(req, form.getActionErrors());
			return mapping.findForward("loginPage");
		}
	}
}
