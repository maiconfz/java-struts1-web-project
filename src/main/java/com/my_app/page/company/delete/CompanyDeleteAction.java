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
import com.my_app.utils.CompanyUtils;

/**
 * UserDeleteAction is a Struts action class responsible for handling user deletion requests.
 * It verifies user authentication, deletes the specified user, and handles success or error messages.
 */
public class CompanyDeleteAction extends Action {

	/**
     * Executes the user deletion action based on the provided parameters.
     *
     * @param mapping   The ActionMapping used to select this instance.
     * @param actionForm The optional ActionForm bean for this request.
     * @param req       The HTTP request we are processing.
     * @param res       The HTTP response we are creating.
     * @return The forward name associated with the success or error outcome.
     * @throws Exception if an error occurs during processing.
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}

		final ActionMessages actionMessages = new ActionMessages();
		final ActionErrors actionErrors = new ActionErrors();

		final CompanyService companyService = new CompanyServiceFactory().create((Connection) req.getAttribute("conn"));

		final int totalCompanyCount = companyService.findAll().size();

		if (totalCompanyCount - 1 != 0) {

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