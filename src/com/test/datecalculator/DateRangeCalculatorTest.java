package com.test.datecalculator;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import com.example.datecalculator.DateRangeCalculator;

/**
 * The Class JUnitServiceTestExample.
 */
public class DateRangeCalculatorTest {

	/**
	 * 
	 * @throws ParseException
	 */

	@Test
	public void shouldReturnNumberOfDaysBetweenDates() throws ParseException {
		DateRangeCalculator dateRangeCalculator = new DateRangeCalculator();
		String inputStartDate = "2017-11-12";
		String inputEndDate = "2017-12-12";

		Calendar startDate = new GregorianCalendar();
		Calendar endDate = new GregorianCalendar();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		Date date = dateFormat.parse(inputStartDate);
		startDate.setTime(date);
		date = dateFormat.parse(inputEndDate);
		endDate.setTime(date);

		int days = dateRangeCalculator.daysBetween(startDate.getTime(), endDate.getTime());

		assertEquals(30, days);

	}

	/**
	 * @throws ParseException
	 */
	@Test
	public void shouldReturnNumberOfMonthsBetweenDates() throws ParseException {
		DateRangeCalculator dateRangeCalculator = new DateRangeCalculator();

		List<String> evenMonthList = new ArrayList<String>();
		evenMonthList.add("JANUARY");
		evenMonthList.add("MARCH");
		evenMonthList.add("MAY");
		evenMonthList.add("JULY");
		evenMonthList.add("AUGUST");
		evenMonthList.add("OCTOBER");
		evenMonthList.add("DECEMBER");

		String inputStartDate = "2016-07-26";
		String inputEndDate = "2017-12-12";

		Calendar startDate = new GregorianCalendar();
		Calendar endDate = new GregorianCalendar();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		Date date = dateFormat.parse(inputStartDate);
		startDate.setTime(date);
		date = dateFormat.parse(inputEndDate);
		endDate.setTime(date);

		float months = dateRangeCalculator.getMonths(startDate, endDate, evenMonthList);
		assertEquals(16.533333, months, 1);

	}

}