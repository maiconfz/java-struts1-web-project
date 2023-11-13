package com.my_app.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HomeAction extends Action {

	@Override
	public ActionForward perform(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException {

		if (Boolean.TRUE.equals(req.getSession().getAttribute("isLogged"))) {
			return mapping.findForward("homePage");
		} else {
			return mapping.findForward("actionLoginRedir");
		}
	}

}
