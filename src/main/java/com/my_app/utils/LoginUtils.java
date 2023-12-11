package com.my_app.utils;

import static java.lang.Boolean.TRUE;

import javax.servlet.http.HttpSession;

import com.my_app.AppConstants;

public class LoginUtils {

	private LoginUtils() {
	}

	public static boolean isUserLoggedIn(final HttpSession session) {
		return TRUE.equals(session.getAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN));
	}

	public static boolean isUserNotLoggedIn(final HttpSession session) {
		return !isUserLoggedIn(session);
	}

}
