package com.my_app.utils;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

public class StringUtils {

	private StringUtils() {
	}

	public static String normalizeString(String stringToNormalize) {
		return replace(lowerCase(stringToNormalize), " ", "_");
	}

    public static boolean emailValidator(String email) {
        return Pattern.compile("^(\\S+)@(\\S+)\\.(\\S+)$").matcher(email).matches();
    }

}
