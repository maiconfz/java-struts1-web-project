package com.my_app.page.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.tinylog.Logger;

import com.my_app.AppConstants;
import com.my_app.utils.LoginUtils;

public class ActionPrivate extends Action  {
	
	
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	
		Logger.debug("entrou no action private");
		
		Enumeration<String> param = request.getSession().getAttributeNames();
		Logger.debug("parameter names sessio" + param.asIterator().toString());
		
		if (LoginUtils.isUserLoggedIn(request.getSession())) {
			return mapping.findForward("privatePage");
		} else {
			return mapping.findForward("actionLoginRedir");
		}

		
		//return mapping.findForward("privatePage");
	}

}
