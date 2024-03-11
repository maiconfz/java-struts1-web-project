package com.my_app.page.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.AppConstants;
import com.my_app.utils.LoginUtils;

public class LogoutAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		return performLogout(mapping, req, res);

	}

	/**
	 * cahango limpar o user da sessão limpar a chave da sessão invalidar a
	 * sessão
	 */
	private ActionForward performLogout(ActionMapping mapping, HttpServletRequest req, HttpServletResponse res) {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}
		req.getSession().removeAttribute("username");
		req.getSession().setAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN, false);
		req.getSession().invalidate();
		
		return mapping.findForward("loginPage");
	}
}
