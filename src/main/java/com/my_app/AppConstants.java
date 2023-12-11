package com.my_app;

/**
 * The `AppConstants` class provides constant values used throughout the application.
 * It contains a key for the session attribute to check whether a user is logged in.
 * This class is final with a private constructor to prevent instantiation or subclassing.
 */
public class AppConstants {

	private AppConstants() {
	}

	public static final String SESSION_ATTR_KEY_IS_LOGGED_IN = "isLoggedIn";
}
