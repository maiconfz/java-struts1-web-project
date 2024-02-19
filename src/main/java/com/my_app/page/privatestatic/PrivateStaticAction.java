package com.my_app.page.privatestatic;

import com.my_app.utils.LoginUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
// Dangerous name, just for exercise purposes haha
//
public class PrivateStaticAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {
        if (LoginUtils.isUserLoggedIn(req.getSession())) {
            return mapping.findForward("privatePage");
        } else {
            return mapping.findForward("actionLoginRedir");
        }
    }
}
