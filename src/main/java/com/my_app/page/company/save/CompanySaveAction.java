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
import com.my_app.service.CompanyService;
import com.my_app.service.factory.CompanyServiceFactory;
import com.my_app.utils.LoginUtils;

public class CompanySaveAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		final Connection conn = (Connection) req.getAttribute("conn");
		final CompanyService companyService = new CompanyServiceFactory().create(conn);

		final CompanySaveForm form = (CompanySaveForm) actionForm;

		req.setAttribute("form", form);

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("loginRedir");
		} else if ("save".equals(form.getAction())) {
			return executeSaveAction(mapping, form, req, res, companyService);
		} else if ("validate".equals(form.getAction())) {
			return executeValidateAction(mapping, form, req, res, companyService);
		} else {
			return this.executeFormAction(mapping, form, req, res, companyService);
		}
	}

	private ActionForward executeFormAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanyService companyService) {

		if (form.isFormInit()) {
			companyService.formInit(form);
			form.setFormInit(false);
		}

		companyService.setRequestAttrs(form, req);

		return mapping.findForward("form");
	}

	private ActionForward executeValidateAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanyService companyService) {

		if (companyService.validate(form)) {
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

		return this.executeFormAction(mapping, form, req, res, companyService);
	}

	private ActionForward executeSaveAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanyService companyService) {

		ActionForward actionForward;

		if (companyService.validate(form)) {
			final Company company = companyService.saveCompany(form);

			if (form.isNewCompany()) {
				form.getActionMessages().add("topMsgs", new ActionMessage("company.create.success", company.getName()));
			} else {
				form.getActionMessages().add("topMsgs", new ActionMessage("company.update.success", company.getName()));
			}

			actionForward = mapping.findForward("actionCompanies");
		} else {
			form.getActionErrors().add("topMsgs", new ActionMessage("form.validation.error"));
			req.setAttribute("validated", true);

			actionForward = this.executeFormAction(mapping, form, req, res, companyService);
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
