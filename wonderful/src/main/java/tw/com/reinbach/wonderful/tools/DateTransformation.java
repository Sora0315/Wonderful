package tw.com.reinbach.wonderful.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTransformation {

	public static java.sql.Date currentDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}

	public static java.sql.Timestamp currentTime() {
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}

	public static java.sql.Date getDate(int year, int month, int day) {
		try {
			return new java.sql.Date(new SimpleDateFormat().parse(year + "-" + month + "-" + day).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static java.sql.Date getDate(String date) {
		try {
			return new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Timestamp getTime(int year, int month, int day, int hour, int min, int sec) {
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Timestamp getTime(int year, int month, int day, int hour, int min) {
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.parse(year + "-" + month + "-" + day + " " + hour + ":" + min).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Timestamp getTime(String time) {
		try {
			return new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(time).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getExpiredDate() {
		try {
			Calendar calendar = Calendar.getInstance(Locale.TAIWAN);
			calendar.setTime(new java.util.Date());
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DATE) + 3;
			return String.valueOf(year + "-" + month + "-" + day + " 23:59");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
