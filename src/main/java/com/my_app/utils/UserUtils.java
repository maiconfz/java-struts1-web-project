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

	public static Boolean isValidEmail(String email) {
		String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern pattern = Pattern.compile(emailRegexPattern); 		
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
}
