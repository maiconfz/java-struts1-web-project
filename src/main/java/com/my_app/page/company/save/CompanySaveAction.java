package com.my_app.page.company.save;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.page.company.save.service.CompanySaveService;
import com.my_app.page.company.save.service.CompanySaveServiceFactory;
import com.my_app.utils.LoginUtils;

public class CompanySaveAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		final Connection conn = (Connection) req.getAttribute("conn");
		
		final CompanySaveService companySaveService = new CompanySaveServiceFactory().create(conn);

		final CompanySaveForm form = (CompanySaveForm) actionForm;

		req.setAttribute("form", form);

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("loginRedir");
		} else if ("save".equals(form.getAction())) {
			return executeSaveAction(mapping, form, req, res, companySaveService);
		} else if ("validate".equals(form.getAction())) {
			return executeValidateAction(mapping, form, req, res, companySaveService);
		} else {
			return this.executeFormAction(mapping, form, req, res, companySaveService);
		}
	}

	private ActionForward executeFormAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanySaveService companySaveService) {
		if (form.isFormInit()) {
			companySaveService.formInit(form);
			form.setFormInit(false);
		}
		companySaveService.setRequestAttrs(form, req);
		return mapping.findForward("form");
	}

	private ActionForward executeValidateAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanySaveService companySaveService) {
		// TODO Auto-generated method stub
		return null;
	}

	private ActionForward executeSaveAction(ActionMapping mapping, CompanySaveForm form, HttpServletRequest req,
			HttpServletResponse res, CompanySaveService companySaveService) {
		// TODO Auto-generated method stub
		return null;
	}

}
