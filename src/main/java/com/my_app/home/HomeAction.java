package com.my_app.home;

import static java.lang.Boolean.TRUE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.AppConstants;

public class HomeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (TRUE.equals(req.getSession().getAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN))) {
			return mapping.findForward("homePage");
		} else {
			return mapping.findForward("actionLoginRedir");
		}
	}

}
