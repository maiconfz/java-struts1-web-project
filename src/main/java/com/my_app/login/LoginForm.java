package com.my_app.login;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	private static final long serialVersionUID = 3648004327226250285L;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
