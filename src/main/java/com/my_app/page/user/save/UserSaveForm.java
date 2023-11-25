package com.my_app.page.user.save;

import com.my_app.model.BaseActionForm;

public class UserSaveForm extends BaseActionForm {
	private static final long serialVersionUID = 3648004327226250285L;

	private Long userId;
	private String username;
	private String password;

	private transient boolean formInit = true;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public boolean isFormInit() {
		return formInit;
	}

	public void setFormInit(boolean formInit) {
		this.formInit = formInit;
	}

	public boolean isNewUser() {
		return this.userId == null || this.userId == 0;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
