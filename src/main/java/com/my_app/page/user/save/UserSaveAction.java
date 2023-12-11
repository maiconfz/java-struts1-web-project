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

/**
 * The UserSaveAction class extends the Struts Action class and handles user save-related actions.
 * It interacts with the UserSaveService to perform form initialization, validation, and user saving.
 */
public class UserSaveAction extends Action {

	/**
     * Executes the user save action based on the specified form action and performs
     * the necessary operations such as form initialization, validation, and saving.
     *
     * @param mapping     The ActionMapping.
     * @param actionForm  The UserSaveForm containing user details.
     * @param req         The HttpServletRequest.
     * @param res         The HttpServletResponse.
     * @return The ActionForward indicating the next step in the user save process.
     * @throws Exception If an error occurs during the execution.
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		final Connection conn = (Connection) req.getAttribute("conn");
		final UserSaveService userSaveService = new UserSaveServiceFactory().create(conn);

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


	/**
     * Executes the form action, which includes form initialization and setting request attributes.
     *
     * @param mapping         The ActionMapping.
     * @param form            The UserSaveForm containing user details.
     * @param req             The HttpServletRequest.
     * @param res             The HttpServletResponse.
     * @param userSaveService The UserSaveService for handling user save operations.
     * @return The ActionForward indicating the next step in the user save process.
     */
	private ActionForward executeFormAction(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		if (form.isFormInit()) {
			userSaveService.formInit(form);
			form.setFormInit(false);
		}

		userSaveService.setRequestAttrs(form, req);

		return mapping.findForward("form");
	}

	/**
     * Executes the validate action, which validates the user input in the form.
     *
     * @param mapping         The ActionMapping.
     * @param form            The UserSaveForm containing user details.
     * @param req             The HttpServletRequest.
     * @param res             The HttpServletResponse.
     * @param userSaveService The UserSaveService for handling user save operations.
     * @return The ActionForward indicating the next step in the user save process.
     */
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

	/**
     * Executes the save action, which saves the user details after validation.
     *
     * @param mapping         The ActionMapping.
     * @param form            The UserSaveForm containing user details.
     * @param req             The HttpServletRequest.
     * @param res             The HttpServletResponse.
     * @param userSaveService The UserSaveService for handling user save operations.
     * @return The ActionForward indicating the next step in the user save process.
     */
	private ActionForward executeSaveAction(ActionMapping mapping, UserSaveForm form, HttpServletRequest req,
			HttpServletResponse res, UserSaveService userSaveService) {

		ActionForward actionForward;

		if (userSaveService.validate(form)) {
			final User user = userSaveService.saveUser(form);

			if (form.isNewUser()) {
				form.getActionMessages().add("topMsgs", new ActionMessage("user.create.success", user.getUsername()));
			} else {
				form.getActionMessages().add("topMsgs", new ActionMessage("user.update.success", user.getUsername()));
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
