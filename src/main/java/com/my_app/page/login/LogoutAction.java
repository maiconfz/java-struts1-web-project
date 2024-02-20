// Shouldn't technically be here since it's not part of the Login page itself, just for exercise purposes
package com.my_app.page.login;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return mapping.findForward("actionLoginRedir");
    }
}

