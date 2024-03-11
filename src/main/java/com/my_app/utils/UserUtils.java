package com.my_app.utils;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtils {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	private UserUtils() {
	}

	public static String normalizeUsername(String username) {
		return replace(lowerCase(username), " ", "_");
	}

	public static boolean validarEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
