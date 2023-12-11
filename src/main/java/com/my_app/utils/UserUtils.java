package com.my_app.utils;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

public class UserUtils {

	private UserUtils() {
	}

	public static String normalizeUsername(String username) {
		return replace(lowerCase(username), " ", "_");
	}

}
