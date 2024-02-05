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
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}

		req.getSession().setAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN, false);
		req.getSession().setAttribute("username", null);

		return mapping.findForward("actionLoginRedir");
	}

}
