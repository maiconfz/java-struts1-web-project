package com.my_app.model;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessages;

public class BaseActionForm extends ActionForm {
	private static final long serialVersionUID = -790204658587517103L;

	private String action;
	private ActionMessages actionMessages = new ActionMessages();
	private ActionErrors actionErrors = new ActionErrors();

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public ActionMessages getActionMessages() {
		return actionMessages;
	}

	public void setActionMessages(ActionMessages actionMessages) {
		this.actionMessages = actionMessages;
	}

	public ActionErrors getActionErrors() {
		return actionErrors;
	}

	public void setActionErrors(ActionErrors actionErrors) {
		this.actionErrors = actionErrors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
