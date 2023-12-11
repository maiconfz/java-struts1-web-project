package com.my_app.page.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.utils.LoginUtils;

public class HomeAction extends Action {
	
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
