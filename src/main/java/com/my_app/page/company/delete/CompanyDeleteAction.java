package com.my_app.page.company.delete;

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

import com.my_app.model.Company;
import com.my_app.service.CompanyService;
import com.my_app.service.factory.CompanyServiceFactory;
import com.my_app.utils.LoginUtils;

public class CompanyDeleteAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}

		final ActionMessages actionMessages = new ActionMessages();
		final ActionErrors actionErrors = new ActionErrors();
		
		final CompanyService companyService = new CompanyServiceFactory().create((Connection) req.getAttribute("conn"));

		final int totalCompaniesCount = companyService.findAll().size();

		if (totalCompaniesCount - 1 != 0) {

			final String companyIdStr = req.getParameter("companyId");

			if (StringUtils.isNotBlank(companyIdStr)) {
				final Long companyId = Long.valueOf(companyIdStr);

				final Company company = companyService.findById(companyId);

				if (company != null) {
					companyService.delete(company);

					actionMessages.add("topMsgs", new ActionMessage("company.delete.success", company.getName()));
				} else {
					actionErrors.add("topErrors", new ActionMessage("company.not-found.error"));
				}
			} else {
				actionErrors.add("topErrors", new ActionMessage("company.not-found.error"));
			}

		} else {
			actionErrors.add("topErrors", new ActionMessage("company.delete.at-least-one.error"));
			this.saveErrors(req, actionErrors);
		}

		if (!actionMessages.isEmpty()) {
			req.setAttribute("actionMessages", actionMessages);
			this.saveMessages(req, actionMessages);
		} else if (!actionErrors.isEmpty()) {
			req.setAttribute("actionErrors", actionErrors);
			this.saveErrors(req, actionErrors);
		}

		return mapping.findForward("actionCompanies");
	}

}
