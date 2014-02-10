package com.alfascompany.utils;

public class StringUtils {

	public static boolean isNull(final String string) {

		if (string == null)
			return true;
		return string.length() == 0;
	}
}
