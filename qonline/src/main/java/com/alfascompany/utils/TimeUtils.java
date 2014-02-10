package com.alfascompany.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.alfascompany.persistence.PersistenceEntity;

public class TimeUtils {

	public static final String DATE_FORMAT = "yyMMddHHmmssSSS";
	private static final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

	public static String getCurrentTimeString() {

		final StringBuilder strinBuilder = new StringBuilder(PersistenceEntity.DATE_FORMAT.length());

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PersistenceEntity.DATE_FORMAT);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		strinBuilder.append(simpleDateFormat.format(new Date()));

		return strinBuilder.toString();
	}

	public static boolean between(final Date date, final int deltaFromDays, final int DeltaToDays) {

		return TimeUtils.between(date, new Date(), deltaFromDays, DeltaToDays);
	}

	public static boolean between(final Date date, final Date dateBetween, final int deltaFromDays, final int DeltaToDays) {

		final int days = (int) ((dateBetween.getTime() - date.getTime()) / MILLIS_IN_DAY);

		return days >= deltaFromDays && days <= DeltaToDays;
	}
}
