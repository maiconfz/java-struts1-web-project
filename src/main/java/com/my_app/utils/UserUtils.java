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
	
	
	public static boolean validaEmailTopLevel(String email) {
		
		String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);
	
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches() ;
	}

}
