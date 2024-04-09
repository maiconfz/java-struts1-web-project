package com.my_app.utils;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtils {

	private UserUtils() {
	}

	public static String normalizeUsername(String username) {
		return replace(lowerCase(username), " ", "_");
	}
	
	public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_REGEX.matcher(emailStr);
		return matcher.matches();
	}
}
