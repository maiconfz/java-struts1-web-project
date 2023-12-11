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

public class LogoutAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		req.getSession().invalidate();
		return mapping.findForward("loginPage");
	}
}