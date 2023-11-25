package com.my_app.page.user.delete;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.my_app.model.User;
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

		final ActionMessages actionMessages = new ActionMessages();
		final ActionErrors actionErrors = new ActionErrors();

		final UserService userService = new UserServiceFactory().create((Connection) req.getAttribute("conn"));

		final int totalUsersCount = userService.findAll().size();

		if (totalUsersCount - 1 != 0) {

			final String userIdStr = req.getParameter("userId");

			if (StringUtils.isNotBlank(userIdStr)) {
				final Long userId = Long.valueOf(userIdStr);

				final User user = userService.findById(userId);

				if (user != null) {
					userService.delete(user);

					actionMessages.add("topMsgs", new ActionMessage("success.user.delete.success", user.getUsername()));
				} else {
					actionErrors.add("topErrors", new ActionMessage("error.user.not-found"));
				}
			} else {
				actionErrors.add("topErrors", new ActionMessage("error.user.not-found"));
			}

		} else {
			actionErrors.add("topErrors", new ActionMessage("error.user.delete.at-least-one"));
			this.saveErrors(req, actionErrors);
		}

		if (!actionMessages.isEmpty()) {
			req.setAttribute("actionMessages", actionMessages);
			this.saveMessages(req, actionMessages);
		} else if (!actionErrors.isEmpty()) {
			req.setAttribute("actionErrors", actionErrors);
			this.saveErrors(req, actionErrors);
		}

		return mapping.findForward("actionUsers");
	}

}
