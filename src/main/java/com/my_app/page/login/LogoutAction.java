package com.my_app.page.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.AppConstants;

public class LogoutAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		req.getSession().setAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN, false);
		req.getSession().invalidate();
		
		return mapping.findForward("actionLoginRedir");
	}
}
