package com.my_app.page.user.save;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.my_app.model.User;
import com.my_app.page.user.save.service.UserSaveService;
import com.my_app.page.user.save.service.UserSaveServiceFactory;
import com.my_app.utils.LoginUtils;

public class UserSaveAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		final UserSaveService userSaveService = new UserSaveServiceFactory()
				.create((Connection) req.getAttribute("conn"));

		final UserSaveForm form = (UserSaveForm) actionForm;

		req.setAttribute("form", form);

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("loginRedir");
		} else if ("submit".equals(form.getAction())) {
			return performSubmit(mapping, form, req, res, userSaveService);
		} else {
			return this.performUserSave(mapping, form, req, res, userSaveService);
		}
	}

	private ActionForward performUserSave(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		if (form.isFormInit()) {
			userSaveService.formInit(form);
			form.setFormInit(false);
		}

		userSaveService.setRequestAttrs(form, req);

		return mapping.findForward("form");
	}

	private ActionForward performSubmit(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		ActionForward actionForward;

		final ActionMessages actionMessages = new ActionMessages();

		if (userSaveService.validate(form)) {
			final User user = userSaveService.saveUser(form);

			if (form.isNewUser()) {
				actionMessages.add("topMsgs", new ActionMessage("success.user.create.success", user.getUsername()));
			} else {
				actionMessages.add("topMsgs", new ActionMessage("success.user.update.success", user.getUsername()));
			}

			actionForward = mapping.findForward("actionUsers");
		} else {
			form.getActionErrors().add("form", new ActionMessage("error.form.validation"));
			super.saveErrors(req, form.getActionErrors());
			req.setAttribute("actionErrors", form.getActionErrors());
			req.setAttribute("validated", true);

			actionForward = this.performUserSave(mapping, form, req, res, userSaveService);
		}

		if (!actionMessages.isEmpty()) {
			req.setAttribute("actionMessages", actionMessages);
			this.saveMessages(req, actionMessages);
		} else if (!form.getActionErrors().isEmpty()) {
			req.setAttribute("actionErrors", form.getActionErrors());
			this.saveErrors(req, form.getActionErrors());
		}

		return actionForward;
	}
}
