package org.aidas.app.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.aidas.app.constant.AppConstants;

/**
 * The Class DateTimeUtil.
 */
public class DateTimeUtil {
	
	/** The Constant HOUR. */
	private static final long HOUR = 60 * 60 * 1000;
	
	/** The Constant DAY. */
	private static final long DAY = 24 * HOUR;
	
	/** The Constant MONTH. */
	private static final long MONTH = 30 * DAY;
	
	/** The Constant MINUTE. */
	private static final long MINUTE = 60 * 1000;
	

	/**
	 * Gets the current timstamp.
	 *
	 * @return the current timstamp
	 */
	public static Timestamp getCurrentTimstamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * Gets the current date and time.
	 *
	 * @return the current date and time
	 */
	public static String getCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return sdf.format(date);
	}

	/**
	 * Gets the current date and time.
	 *
	 * @param format the format
	 * @return the current date and time
	 */
	public static String getCurrentDateAndTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * Gets the today date.
	 *
	 * @return the today date
	 */
	public static String getTodayDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * Gets the date convertion.
	 *
	 * @param date the date
	 * @return the date convertion
	 * @throws Exception the exception
	 */
	public static String getDateConvertion(Date date) throws Exception {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		return ft.format(date);
	}

	/**
	 * Gets the date convertion.
	 *
	 * @param date the date
	 * @return the date convertion
	 */
	public static String getDateConvertion(Object date) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return ft.format(date);
	}

	/**
	 * Gets the parses the date.
	 *
	 * @param date the date
	 * @return the parses the date
	 * @throws ParseException the parse exception
	 */
	public static Date getParseDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		return sdf.parse(date);
	}

	/**
	 * Gets the date with time.
	 *
	 * @param date the date
	 * @return the date with time
	 * @throws ParseException the parse exception
	 */
	public static Date getDateWithTime(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (date != null && !date.equalsIgnoreCase("")) {
			return sdf.parse(date);
		} else {
			return null;
		}
	}

	/**
	 * Gets the string to date to display UI.
	 *
	 * @param date the date
	 * @return the string to date to display UI
	 */
	public static String getStringToDateToDisplayUI(String date) {
		SimpleDateFormat sdfString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MMM-yyyy");

		try {
			if (date != null && !date.equals("")) {
				return sdfDate.format(sdfString.parse(date));
			} else {
				return null;
			}
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Gets the date to date to display UI.
	 *
	 * @param date the date
	 * @return the date to date to display UI
	 */
	public static String getDateToDateToDisplayUI(Date date) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MMM-yyyy");
		return sdfDate.format(date);
	}

	/**
	 * Date time convertion.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String dateTimeConvertion(Date date) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return ft.format(date);
	}

	/**
	 * Convert string date to long.
	 *
	 * @param date the date
	 * @return the long
	 * @throws ParseException the parse exception
	 */
	public static Long convertStringDateToLong(String date)
			throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date now = formatter.parse(date);
		long dateInLong = now.getTime();
		return dateInLong;
	}

	/**
	 * Time difference.
	 *
	 * @param date the date
	 * @return the string
	 * @throws ParseException the parse exception
	 */
	public static String timeDifference(long date) throws ParseException {
		String s = String.format(
				"%02d:%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(date),
				TimeUnit.MILLISECONDS.toMinutes(date)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
								.toHours(date)),
				TimeUnit.MILLISECONDS.toSeconds(date)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
								.toMinutes(date)));
		return s;
	}

	/**
	 * Gets the today time.
	 *
	 * @param date the date
	 * @return the today time
	 */
	public static String getTodayTime(long date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:MM:SS");
		return timeFormat.format(date);
	}

	/**
	 * Gets the parsed month.
	 *
	 * @param date the date
	 * @return the parsed month
	 */
	public static String getParsedMonth(String date) {
		String formatedDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM d hh:mm:ss z yyyy");

		if (date != null && !date.equals("")) {
			try {
				formatedDate = String.valueOf(sdf.format(format.parse(date)));
			} catch (ParseException e) {
				return formatedDate;
			} catch (Exception e) {
				return formatedDate;
			}
			return formatedDate;
		} else {
			return formatedDate;
		}
	}
	
	/**
	 * Gets the parsed time.
	 *
	 * @param date the date
	 * @return the parsed time
	 */
	public static String getParsedTime(String date) {
		String formatedDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		if (date != null && !date.equals("")) {
			try {
				formatedDate = String.valueOf(sdf.format(format.parse(date)));
			} catch (ParseException e) {
				return formatedDate;
			} catch (Exception e) {
				return formatedDate;
			}
			return formatedDate;
		} else {
			return formatedDate;
		}
	}
	
	

	/**
	 * Gets the parsed date and month.
	 *
	 * @param date the date
	 * @return the parsed date and month
	 */
	public static String getParsedDateAndMonth(String date) {
		String format = "yyyy-MM-dd hh:mm:ss";
		String formatedDate = getParsedDateAndMonth(date, format);
		return formatedDate;
	}

	/**
	 * Gets the parsed date and month.
	 *
	 * @param date the date
	 * @param format the format
	 * @return the parsed date and month
	 */
	public static String getParsedDateAndMonth(String date, String format) {
		String formatedDate = null;
		SimpleDateFormat sDate = new SimpleDateFormat("dd");
		SimpleDateFormat sMonth = new SimpleDateFormat("MMM");
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		if (date != null && !date.equals("")) {
			try {
				formatedDate = String.valueOf(sDate.format(sdf.parse(date)))
						+ " " + String.valueOf(sMonth.format(sdf.parse(date)));
			} catch (ParseException e) {
				return "";
			} catch (Exception e) {
				return "";
			}
			return formatedDate;
		} else {
			return "";
		}
	}


	/**
	 * Gets the convertion date.
	 *
	 * @param date the date
	 * @return the convertion date
	 */
	public static String getConvertionDate(Date date) {
		String dateTime = null;
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			dateTime = ft.format(date);
			return dateTime;
		} catch (Exception e) {
			return dateTime;
		}
	}
	
	/**
	 * Gets the formatted date.
	 *
	 * @param date the date
	 * @return the formatted date
	 */
	public static String getFormattedDate(Date date) {
		try{
			SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");
			return ft.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}