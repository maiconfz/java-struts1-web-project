package com.my_app.utils;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

/**
 * The UserUtils class provides utility methods related to user operations.
 */
public class CompanyUtils {

	private CompanyUtils() {
	}

	/**
     * Normalizes a username by converting it to lowercase and replacing spaces with underscores.
     *
     * @param username The username to normalize.
     * @return The normalized username.
     */
	public static String normalizeConpanyName(String name) {
		return replace(lowerCase(name), " ", "_");
	}

}