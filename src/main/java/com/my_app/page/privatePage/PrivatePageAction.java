package com.my_app.page.privatePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.utils.LoginUtils;

public class PrivatePageAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse response) throws Exception {
		
		if (LoginUtils.isUserLoggedIn(req.getSession())) {
			return mapping.findForward("privatePage");
		} else {
			return mapping.findForward("actionLoginRedir");
		}
	}

}
