package com.alfascompany.utils;

import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.i18n.shared.DefaultDateTimeFormatInfo;

public class TimeUtils {

	public static final String DATE_FORMAT = "yyMMddHHmmssSSS";
	private static final long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

	public static Date addDays(final Date date, final int daysFromNow) {

		final DateTimeFormat dateTimeFormat = new DateTimeFormat(DATE_FORMAT, new DefaultDateTimeFormatInfo()) {
		};

		// TODO: terminar esto
		return date;
	}

	public static String getCurrentTimeString() {

		return getTimeString(new Date());
	}

	public static String getTimeString(final Date date) {
		final DateTimeFormat dateTimeFormat = new DateTimeFormat(DATE_FORMAT, new DefaultDateTimeFormatInfo()) {
		};

		final StringBuilder strinBuilder = new StringBuilder(DATE_FORMAT.length());
		strinBuilder.append(dateTimeFormat.format(date));
		return strinBuilder.toString();
	}

	public static boolean between(final Date date, final int deltaFromDays, final int DeltaToDays) {

		return TimeUtils.between(date, new Date(), deltaFromDays, DeltaToDays);
	}

	public static boolean between(final Date date, final Date dateBetween, final int deltaFromDays,
			final int DeltaToDays) {

		if (date == null)
			throw new IllegalArgumentException("Date cannot be null");

		final int days = (int) ((date.getTime() - dateBetween.getTime()) / MILLIS_IN_DAY);
		return days >= deltaFromDays && days <= DeltaToDays;
	}

	public static Date parseDate(final String dateString) {

		return parseDate(dateString, DATE_FORMAT);
	}

	public static Date parseDate(final String dateString, final String format) {

		final DateTimeFormat dateTimeFormat = new DateTimeFormat(format, new DefaultDateTimeFormatInfo()) {
		};

		return dateTimeFormat.parse(dateString);
	}

}
