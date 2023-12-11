package com.my_app.utils;

import static java.lang.Boolean.TRUE;

import javax.servlet.http.HttpSession;

import com.my_app.AppConstants;

/**
 * The LoginUtils class provides utility methods related to user login status.
 */
public class LoginUtils {

	private LoginUtils() {
	}

	 /**
     * Checks if a user is logged in based on the presence of the "isLoggedIn"
     * attribute in the session.
     *
     * @param session The HttpSession object.
     * @return {@code true} if the user is logged in, {@code false} otherwise.
     */
	public static boolean isUserLoggedIn(final HttpSession session) {
		return TRUE.equals(session.getAttribute(AppConstants.SESSION_ATTR_KEY_IS_LOGGED_IN));
	}

	/**
     * Checks if a user is not logged in based on the absence of the "isLoggedIn"
     * attribute in the session.
     *
     * @param session The HttpSession object.
     * @return {@code true} if the user is not logged in, {@code false} otherwise.
     */
	public static boolean isUserNotLoggedIn(final HttpSession session) {
		return !isUserLoggedIn(session);
	}

}
