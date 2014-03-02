package com.alfascompany.utils;

public class StringUtils {

	public static boolean isNullOrEmpty(final String string) {

		if (string == null)
			return true;
		return string.length() == 0;
	}
}
