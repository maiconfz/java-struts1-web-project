package com.my_app.page.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.tinylog.Logger;

import com.my_app.AppConstants;

public class ActionLogout extends Action  {
	
	
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// pegar a sessão e invalidar
		HttpSession sessao = request.getSession();
		Logger.debug("sessão antes do invalidate", sessao.toString());
		sessao.invalidate();
		//talvez seja redundante, testar
		request.getSession().setAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN, false);
		
		Logger.debug("sessão apos o invalidate", sessao.toString());
		
		
		return mapping.findForward("logoutPage");
	}

}
