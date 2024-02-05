package com.my_app.utils;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

import java.util.regex.Pattern;

public class UserUtils {

	private UserUtils() {
	}
	
	private static Pattern emailPattern = Pattern.compile("^(.+)@(\\S+)$");

	public static String normalizeUsername(String username) {
		return replace(lowerCase(username), " ", "_");
	}
	
	public static boolean emailIsValid( String email ) {
		return emailPattern.matcher(email).matches();
	}

}
