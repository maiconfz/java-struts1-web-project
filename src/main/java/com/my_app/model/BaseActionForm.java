package com.my_app.model;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;

public class BaseActionForm extends ActionForm {
	private static final long serialVersionUID = -790204658587517103L;

	private String action;
	private ActionErrors actionErrors = new ActionErrors();

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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
