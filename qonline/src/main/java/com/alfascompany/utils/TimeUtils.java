package com.alfascompany.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.alfascompany.persistence.PersistenceEntity;

public class TimeUtils {

	public static final String DATE_FORMAT = "yyMMddHHmmssSSS";

	public static String getCurrentTimeString() {

		final StringBuilder strinBuilder = new StringBuilder(PersistenceEntity.DATE_FORMAT.length());

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PersistenceEntity.DATE_FORMAT);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		strinBuilder.append(simpleDateFormat.format(new Date()));

		return strinBuilder.toString();
	}
}
