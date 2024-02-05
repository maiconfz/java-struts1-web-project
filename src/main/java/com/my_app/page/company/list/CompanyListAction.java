package com.my_app.page.company.list;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.my_app.service.CompanyService;
import com.my_app.service.factory.CompanyServiceFactory;
import com.my_app.utils.LoginUtils;

public class CompanyListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		if (LoginUtils.isUserNotLoggedIn(req.getSession())) {
			return mapping.findForward("actionLoginRedir");
		}

		final CompanyService companyService = new CompanyServiceFactory().create((Connection) req.getAttribute("conn"));

		req.setAttribute("companies", companyService.findAll());

		return mapping.getInputForward();
	}

}
