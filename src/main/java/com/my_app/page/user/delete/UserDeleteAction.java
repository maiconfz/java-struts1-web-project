package com.my_app.page.user.delete;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.service.UserService;
import com.my_app.service.factory.UserServiceFactory;
import com.my_app.utils.LoginUtils;

public class UserDeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}

		final UserService userService = new UserServiceFactory().create((Connection) req.getAttribute("conn"));

		final Long userId = Long.valueOf(req.getParameter("userId"));
		
		userService.deleteById(userId);

		return mapping.findForward("usersRedir");
	}

}
