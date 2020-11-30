package com.intercorp.retail.ircliente.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerUtils {
	
	public static Integer getAgeFromBirthday(String sBirthday) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar today = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		try {
			birthday.setTime(simpleDateFormat.parse(sBirthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
		int m = today.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);
		if (m < 0 || (m == 0 && today.get(Calendar.DAY_OF_MONTH) > birthday.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}
		return age;
	}
	
	public static String getDateFormatted(String sDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat2.format(date);
	}
	
	public static String getDeathday(Long age) {
		Calendar today = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(today.getTimeInMillis() + ((75 - age) * 365 * 24 * 3600 * 1000));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(calendar.getTime());
	}
	
	public static Double average(List<Double> data) {
		double sum = 0, count = 0;
		for (double i : data) {
			sum += i;
			count++;
		}
		return sum / count;
	}
	
	public static Double standardDeviation(List<Double> data) {
		double avg = average(data);
		List<Double> squareDiffs = new ArrayList<Double>();
		for (double i : data) {
			squareDiffs.add(Math.pow(i - avg, 2));
		}
		double avgSquareDiff = average(squareDiffs);
		return Math.sqrt(avgSquareDiff);
	}

}
