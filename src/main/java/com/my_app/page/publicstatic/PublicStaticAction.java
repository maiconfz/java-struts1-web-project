package com.my_app.page.publicstatic;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
// Dangerous name, just for exercise purposes haha
//
public class PublicStaticAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {
        return mapping.findForward("publicPage");
    }
}
