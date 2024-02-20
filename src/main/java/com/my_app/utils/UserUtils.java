package com.my_app.utils;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

public class UserUtils {

	private UserUtils() {
	}

	public static String normalizeUsername(String username) {
		return replace(lowerCase(username), " ", "_");
	}

    public static boolean emailValidator(String email) {
        return Pattern.compile("^(\\S+)@(\\S+)\\.(\\S+)$").matcher(email).matches();
    }

}
