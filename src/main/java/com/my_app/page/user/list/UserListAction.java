package com.my_app.page.user.list;

import static java.lang.Boolean.TRUE;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.AppConstants;
import com.my_app.service.UserService;
import com.my_app.service.factory.UserServiceFactory;

public class UserListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (!TRUE.equals(req.getSession().getAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN))) {
			return mapping.findForward("actionLoginRedir");
		}

		final UserService userService = new UserServiceFactory().create((Connection) req.getAttribute("conn"));

		req.setAttribute("users", userService.findAll());

		return mapping.getInputForward();
	}

}
