package com.my_app.page.user.save;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

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
		} else if ("save".equals(form.getAction())) {
			return executeSaveAction(mapping, form, req, res, userSaveService);
		} else if ("validate".equals(form.getAction())) {
			return executeValidateAction(mapping, form, req, res, userSaveService);
		} else {
			return this.executeFormAction(mapping, form, req, res, userSaveService);
		}
	}

	private ActionForward executeFormAction(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		if (form.isFormInit()) {
			userSaveService.formInit(form);
			form.setFormInit(false);
		}

		userSaveService.setRequestAttrs(form, req);

		return mapping.findForward("form");
	}

	private ActionForward executeValidateAction(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		if (userSaveService.validate(form)) {
			form.getActionMessages().add("topMsgs", new ActionMessage("form.validation.success", form.getUsername()));
		} else {
			form.getActionErrors().add("topMsgs", new ActionMessage("form.validation.error"));
		}

		if (!form.getActionMessages().isEmpty()) {
			req.setAttribute("actionMessages", form.getActionMessages());
			this.saveMessages(req, form.getActionMessages());
		} else if (!form.getActionErrors().isEmpty()) {
			req.setAttribute("actionErrors", form.getActionErrors());
			this.saveErrors(req, form.getActionErrors());
		}

		req.setAttribute("validated", true);

		return this.executeFormAction(mapping, form, req, res, userSaveService);
	}

	private ActionForward executeSaveAction(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		ActionForward actionForward;

		if (userSaveService.validate(form)) {
			final User user = userSaveService.saveUser(form);

			if (form.isNewUser()) {
				form.getActionMessages().add("topMsgs",
						new ActionMessage("user.create.success", user.getUsername()));
			} else {
				form.getActionMessages().add("topMsgs",
						new ActionMessage("user.update.success", user.getUsername()));
			}

			actionForward = mapping.findForward("actionUsers");
		} else {
			form.getActionErrors().add("topMsgs", new ActionMessage("form.validation.error"));
			req.setAttribute("validated", true);

			actionForward = this.executeFormAction(mapping, form, req, res, userSaveService);
		}

		if (!form.getActionMessages().isEmpty()) {
			req.setAttribute("actionMessages", form.getActionMessages());
			this.saveMessages(req, form.getActionMessages());
		} else if (!form.getActionErrors().isEmpty()) {
			req.setAttribute("actionErrors", form.getActionErrors());
			this.saveErrors(req, form.getActionErrors());
		}

		return actionForward;
	}
}
