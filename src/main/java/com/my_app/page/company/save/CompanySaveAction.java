package com.my_app.page.company.save;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.my_app.model.Company;
import com.my_app.page.company.save.service.CompanySaveService;
import com.my_app.page.company.save.service.CompanySaveServiceFactory;
import com.my_app.utils.LoginUtils;

/**
 * The UserSaveAction class extends the Struts Action class and handles user save-related actions.
 * It interacts with the UserSaveService to perform form initialization, validation, and user saving.
 */
public class CompanySaveAction extends Action {

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
		final CompanySaveService company = new CompanySaveServiceFactory().create(conn);

		final CompanySaveForm form = (CompanySaveForm) actionForm;

		req.setAttribute("form", form);

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("loginRedir");
		} else if ("save".equals(form.getAction())) {
			return executeSaveAction(mapping, form, req, res, company);
		} else if ("validate".equals(form.getAction())) {
			return executeValidateAction(mapping, form, req, res, company);
		} else {
			return this.executeFormAction(mapping, form, req, res, company);
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
	private ActionForward executeFormAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanySaveService companySaveService) {

		if (form.isFormInit()) {
			companySaveService.formInit(form);
			form.setFormInit(false);
		}

		companySaveService.setRequestAttrs(form, req);

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
	private ActionForward executeValidateAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanySaveService companySaveService) {

		if (companySaveService.validate(form)) {
			form.getActionMessages().add("topMsgs", new ActionMessage("form.validation.success", form.getName()));
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

		return this.executeFormAction(mapping, form, req, res, companySaveService);
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
	private ActionForward executeSaveAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanySaveService companySaveService) {

		ActionForward actionForward;

		if (companySaveService.validate(form)) {
			final Company copany = companySaveService.saveCompany(form);

			if (form.isFormInit()) {
				form.getActionMessages().add("topMsgs", new ActionMessage("company.create.success", form.getName()));
			} else {
				form.getActionMessages().add("topMsgs", new ActionMessage("company.update.success", form.getName()));
			}

			actionForward = mapping.findForward("actionCompanies");
		} else {
			form.getActionErrors().add("topMsgs", new ActionMessage("form.validation.error"));
			req.setAttribute("validated", true);

			actionForward = this.executeFormAction(mapping, form, req, res, companySaveService);
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