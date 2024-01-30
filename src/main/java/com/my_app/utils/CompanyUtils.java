package com.my_app.utils;

import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.replace;

public class CompanyUtils {

	private CompanyUtils() {
	}

	public static String normalizeCompanyName(String companyName) {
		return replace(lowerCase(companyName), " ", "_");
	}

	
}
