package com.my_app.login;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.login.service.LoginService;
import com.my_app.login.service.LoginServiceFactory;

public class LoginAction extends Action {
	private LoginService loginService;

	private void init(HttpServletRequest req) {
		this.loginService = new LoginServiceFactory().create((Connection) req.getAttribute("conn"));
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		this.init(req);

		final LoginForm form = (LoginForm) actionForm;

		req.setAttribute("form", form);

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
			req.setAttribute("actionErrors", form.getActionErrors());
			req.setAttribute("validated", true);
			return mapping.findForward("loginPage");
		}
	}
}
